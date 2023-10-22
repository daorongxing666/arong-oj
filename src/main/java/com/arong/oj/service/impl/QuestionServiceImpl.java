package com.arong.oj.service.impl;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.request.question.QuestionAddDto;
import com.arong.oj.entity.request.question.QuestionEditDto;
import com.arong.oj.entity.request.question.QuestionQueryDto;
import com.arong.oj.entity.response.question.QuestionDetailResponse;
import com.arong.oj.entity.response.question.QuestionResponse;
import com.arong.oj.service.QuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.Question;
import com.arong.oj.mapper.QuestionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author centos7
* @description 针对表【question】的数据库操作Service实现
* @createDate 2023-10-21 15:54:27
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
    implements QuestionService {

    @Override
    public Long addQuestion(QuestionAddDto questionAddDto) {
        return null;
    }

    @Override
    public Long editQuestion(QuestionEditDto questionEditDto) {
        return null;
    }

    @Override
    public boolean deleteQuestion(DeleteDto deleteDto) {
        return false;
    }

    @Override
    public List<QuestionResponse> getQuestionList(QuestionQueryDto questionQueryDto) {
        return null;
    }

    @Override
    public QuestionDetailResponse getQuestionDetail(Long questionId) {
        return null;
    }

    @Override
    public void execute() {

    }
}




