package com.arong.oj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.domain.Question;
import com.arong.oj.entity.request.question.QuestionAddDto;
import com.arong.oj.entity.request.question.QuestionEditDto;
import com.arong.oj.entity.request.question.QuestionQueryDto;
import com.arong.oj.entity.response.QuestionResponse;
import com.arong.oj.entity.response.question.QuestionDetailResponse;
import com.arong.oj.entity.response.question.QuestionResponse;
import com.arong.oj.error.BusinessException;
import com.arong.oj.service.QuestionService;
import com.arong.oj.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.Question;
import com.arong.oj.mapper.QuestionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.arong.oj.common.Code.SQL_ERROR;

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
        Question question = BeanUtil.copyProperties(questionAddDto, Question.class);
        boolean save = save(question);
        if(!save) {
            throw new BusinessException(SQL_ERROR);
        }
        return question.getId();
    }

    @Override
    public Long editQuestion(QuestionEditDto questionEditDto) {
        Question question = BeanUtil.copyProperties(questionEditDto, Question.class);
        boolean b = updateById(question);
        if(!b) {
            throw new BusinessException(SQL_ERROR);
        }
        return question.getId();
    }

    @Override
    public boolean deleteQuestion(DeleteDto deleteDto) {
        return removeById(deleteDto.getId());
    }

    @Override
    public Page<QuestionResponse> getQuestionList(QuestionQueryDto questionQueryDto) {
        QueryWrapper<Question> questionQueryWrapper = new QueryWrapper<>();
        questionQueryWrapper.lambda()
                .eq(questionQueryDto.getId() != null && questionQueryDto.getId() > 0, Question::getId, questionQueryDto.getId())
                .eq(questionQueryDto.getDifficulty() != null && questionQueryDto.getDifficulty() > 0, Question::getDifficulty, questionQueryDto.getDifficulty())
                .like(questionQueryDto.getTags() != null, Question::getTags, questionQueryDto.getTags())
                .like(questionQueryDto.getTitle() != null && questionQueryDto.getTitle().equals(""), Question::getTitle, questionQueryDto.getTitle());

        List<Question> list = list(questionQueryWrapper);
        List<QuestionResponse> collect = list.stream().map(question -> BeanUtil.copyProperties(question, QuestionResponse.class)).collect(Collectors.toList());
        Page<QuestionResponse> pageList = PageUtil.getPageList(collect, questionQueryDto.getCurrentPage(), questionQueryDto.getPageSize());
        return pageList;
    }

    @Override
    public QuestionDetailResponse getQuestionDetail(Long questionId) {
        QueryWrapper<Question> questionQueryWrapper = new QueryWrapper<>();
        questionQueryWrapper.lambda()
                .eq(questionId != null && questionId > 0, Question::getId, questionId);
        Question one = getOne(questionQueryWrapper);
        QuestionDetailResponse questionResponse = BeanUtil.copyProperties(one, QuestionDetailResponse.class);
        return questionResponse;
    }

    @Override
    public void execute() {

    }
}




