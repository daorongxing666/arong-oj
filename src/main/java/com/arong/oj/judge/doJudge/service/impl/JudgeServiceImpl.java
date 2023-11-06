package com.arong.oj.judge.doJudge.service.impl;
import cn.hutool.json.JSONUtil;
import com.arong.oj.entity.enums.JudgeInfoMessageEnum;
import com.arong.oj.entity.enums.QuestionSummitStatusEnum;
import com.arong.oj.entity.request.judge.JudgeInfo;
import java.util.List;
import java.util.Arrays;
import java.util.Objects;

import com.arong.oj.common.Code;
import com.arong.oj.entity.domain.UserQuestion;
import com.arong.oj.entity.response.question.QuestionDetailResponse;
import com.arong.oj.error.BusinessException;
import com.arong.oj.judge.codeSandbox.CodeSandbox;
import com.arong.oj.judge.codeSandbox.factory.CodeSandBoxFactory;
import com.arong.oj.judge.codeSandbox.proxy.CodeSandBoxProxy;
import com.arong.oj.judge.doJudge.service.JudgeService;
import com.arong.oj.judge.doJudge.strategy.JudgeContext;
import com.arong.oj.judge.doJudge.strategy.JudgeManger;
import com.arong.oj.judge.domain.JudgeInfoRequest;
import com.arong.oj.judge.domain.JudgeInfoResponse;
import com.arong.oj.service.QuestionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

public class JudgeServiceImpl implements JudgeService {

    @Value("${codeSandBox.type:example}")
    private String type;


    @Resource
    private QuestionService questionService;

    @Override
    public UserQuestion doJudge(UserQuestion userQuestion) {
        // 获取题目信息，封装成为代码沙箱判题请求类(JudgeInfoRequest)
        Long questionId = userQuestion.getQuestionId();
        QuestionDetailResponse questionDetail = questionService.getQuestionDetail(questionId);
        if(ObjectUtils.isEmpty(questionDetail)) {
            throw new BusinessException(Code.FAIL, "题目不存在");
        }

        List<String> inputList = Arrays.asList(questionDetail.getInputList().split(","));
        JudgeInfoRequest judgeInfoRequest = JudgeInfoRequest.builder()
                .code(userQuestion.getCode())
                .inputList(inputList)
                .language(userQuestion.getLanguage())
                .build();

        // 将代码输入代码沙箱执行，得到判题结果(JudgeInfoResponse)
        // 更改用户答题类状态为判题中
        userQuestion.setAnswerStatus(QuestionSummitStatusEnum.RUNNING.getValue());
        CodeSandbox codeSandbox = CodeSandBoxFactory.getCodeSandBoxInstance(type);
        // 代理类增强功能
        codeSandbox = new CodeSandBoxProxy(codeSandbox);
        JudgeInfoResponse judgeInfoResponse = codeSandbox.execute(judgeInfoRequest);
        // 封装判题信息
        JudgeContext judgeContext = new JudgeContext();
        judgeContext.setJudgeInfoResponse(judgeInfoResponse);
        judgeContext.setUserQuestion(userQuestion);
        judgeContext.setInputList(inputList);
        judgeContext.setLanguage(userQuestion.getLanguage());

        // 实现判题
        userQuestion = JudgeManger.getStrategy(judgeContext);
        return userQuestion;
    }
}
