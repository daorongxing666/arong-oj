package com.arong.oj.judge.doJudge.strategy.common;

import cn.hutool.json.JSONUtil;
import com.arong.oj.entity.domain.UserQuestion;
import com.arong.oj.entity.enums.JudgeInfoMessageEnum;
import com.arong.oj.entity.enums.QuestionSummitStatusEnum;
import com.arong.oj.entity.request.judge.JudgeInfo;
import com.arong.oj.judge.doJudge.strategy.JudgeContext;
import com.arong.oj.judge.doJudge.strategy.JudgeStrategy;
import com.arong.oj.judge.domain.JudgeInfoResponse;

import java.util.List;
import java.util.Objects;

public class CppJudgeStrategy implements JudgeStrategy {
    @Override
    public UserQuestion judge(JudgeContext judgeContext) {
        JudgeInfoResponse judgeInfoResponse = judgeContext.getJudgeInfoResponse();
        UserQuestion userQuestion = judgeContext.getUserQuestion();
        List<String> inputList = judgeContext.getInputList();

        // 比对判题结果是否正确，并更新用户提交判题信息
        List<String> outputList = judgeInfoResponse.getOutputList();
        String msg = judgeInfoResponse.getMsg();
        String judgeStatus = judgeInfoResponse.getStatus();
        JudgeInfo judgeInfo = judgeInfoResponse.getJudgeInfo();
        // 比对输入输出是否数量一致
        if(!Objects.equals(inputList.size(), outputList.size())) {
            userQuestion.setAnswerStatus(QuestionSummitStatusEnum.FAILED.getValue());
            userQuestion.setJudgeStatus(judgeStatus);
            return userQuestion;
        }
        // 比较输入输出是否一致
        int length = inputList.size();
        for(int i = 0; i < length; i++) {
            if(!Objects.equals(inputList.get(i), outputList.get(i))) {
                userQuestion.setAnswerStatus(QuestionSummitStatusEnum.FAILED.getValue());
                userQuestion.setJudgeStatus(JudgeInfoMessageEnum.WRONG_ANSWER.name());
                return userQuestion;
            }
        }
        // 比较判题信息，时间，内存
        JudgeInfo userJudgeInfo = JSONUtil.toBean(userQuestion.getJudgeInfo(), JudgeInfo.class);
        if(userJudgeInfo.getTimeLimit() > judgeInfo.getTimeLimit()) {
            // 时间方面不符合要求
            userQuestion.setAnswerStatus(QuestionSummitStatusEnum.FAILED.getValue());
            userQuestion.setJudgeStatus(JudgeInfoMessageEnum.TIME_LIMIT_ERROR.name());
            return userQuestion;
        }
        if(userJudgeInfo.getMemoryLimit() > judgeInfo.getMemoryLimit()) {
            // 空间方面不符合要求
            userQuestion.setAnswerStatus(QuestionSummitStatusEnum.FAILED.getValue());
            userQuestion.setJudgeStatus(JudgeInfoMessageEnum.MEMORY_LIMIT_ERROR.name());
            return userQuestion;
        }
        // 成功
        // 新增带状态的用户题目提交信息
        userQuestion.setAnswerStatus(QuestionSummitStatusEnum.SUCCEED.getValue());
        userQuestion.setJudgeStatus(JudgeInfoMessageEnum.ACCEPTED.name());

        return userQuestion;
    }
}
