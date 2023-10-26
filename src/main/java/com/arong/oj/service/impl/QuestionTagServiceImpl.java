package com.arong.oj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.domain.QuestionTag;
import com.arong.oj.entity.request.questionTag.QuestionTagAddDto;
import com.arong.oj.entity.request.questionTag.QuestionTagEditDto;
import com.arong.oj.entity.request.questionTag.QuestionTagQueryDto;
import com.arong.oj.entity.response.QuestionTagResponse;
import com.arong.oj.entity.response.QuestionTagResponse;
import com.arong.oj.error.BusinessException;
import com.arong.oj.service.QuestionTagService;
import com.arong.oj.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.QuestionTag;
import com.arong.oj.mapper.QuestionTagMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.arong.oj.common.Code.SQL_ERROR;

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
        QuestionTag questionTag = BeanUtil.copyProperties(questionTagAddDto, QuestionTag.class);
        boolean save = save(questionTag);
        if(!save) {
            throw new BusinessException(SQL_ERROR);
        }
        return questionTag.getId();
    }

    @Override
    public boolean deleteQuestionTag(DeleteDto deleteDto) {
        return removeById(deleteDto.getId());
    }

    @Override
    public Long editQuestionTag(QuestionTagEditDto questionTagEditDto) {
        QuestionTag questionTag = BeanUtil.copyProperties(questionTagEditDto, QuestionTag.class);
        boolean b = updateById(questionTag);
        if(!b) {
            throw new BusinessException(SQL_ERROR);
        }
        return questionTag.getId();
    }

    @Override
    public Page<QuestionTagResponse> getQuestionTagList(QuestionTagQueryDto questionTagQueryDto) {
        QueryWrapper<QuestionTag> questionTagQueryWrapper = new QueryWrapper<>();
        questionTagQueryWrapper.lambda()
                .eq(questionTagQueryDto.getId() != null && questionTagQueryDto.getId() > 0, QuestionTag::getId, questionTagQueryDto.getId())
                .like(questionTagQueryDto.getTitle() != null && questionTagQueryDto.getTitle().equals(""), QuestionTag::getTitle, questionTagQueryDto.getTitle())
;
        List<QuestionTag> list = list(questionTagQueryWrapper);
        List<QuestionTagResponse> collect = list.stream().map(questionTag -> BeanUtil.copyProperties(questionTag, QuestionTagResponse.class)).collect(Collectors.toList());
        Page<QuestionTagResponse> pageList = PageUtil.getPageList(collect, questionTagQueryDto.getCurrentPage(), questionTagQueryDto.getPageSize());
        return pageList;
    }

    @Override
    public QuestionTagResponse getQuestionTag(Long questionTagId) {
        QueryWrapper<QuestionTag> questionTagQueryWrapper = new QueryWrapper<>();
        questionTagQueryWrapper.lambda()
                .eq(questionTagId != null && questionTagId > 0, QuestionTag::getId, questionTagId);
        QuestionTag one = getOne(questionTagQueryWrapper);
        QuestionTagResponse questionTagResponse = BeanUtil.copyProperties(one, QuestionTagResponse.class);
        return questionTagResponse;
    }
}




