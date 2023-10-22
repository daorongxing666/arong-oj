package com.arong.oj.service.impl;

import com.arong.oj.entity.request.questionTag.QuestionTagAddDto;
import com.arong.oj.entity.request.questionTag.QuestionTagEditDto;
import com.arong.oj.entity.request.questionTag.QuestionTagQueryDto;
import com.arong.oj.entity.response.QuestionTagResponse;
import com.arong.oj.service.QuestionTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.QuestionTag;
import com.arong.oj.mapper.QuestionTagMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author centos7
* @description 针对表【question_tag】的数据库操作Service实现
* @createDate 2023-10-21 15:54:31
*/
@Service
public class QuestionTagServiceImpl extends ServiceImpl<QuestionTagMapper, QuestionTag>
    implements QuestionTagService {

    @Override
    public Long publishQuestionTag(QuestionTagAddDto questionTagAddDto) {
        return null;
    }

    @Override
    public boolean deleteQuestionTag(Long questionTagId) {
        return false;
    }

    @Override
    public Long editQuestionTag(QuestionTagEditDto questionTagEditDto) {
        return null;
    }

    @Override
    public List<QuestionTagResponse> getQuestionTagList(QuestionTagQueryDto questionTagQueryDto) {
        return null;
    }

    @Override
    public QuestionTagResponse getQuestionTag(Long questionTagId) {
        return null;
    }
}




