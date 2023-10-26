package com.arong.oj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.domain.CompetitionQuestion;
import com.arong.oj.entity.request.competitionQuestion.CompetitionQuestionAddDto;
import com.arong.oj.entity.request.competitionQuestion.CompetitionQuestionEditDto;
import com.arong.oj.entity.request.competitionQuestion.CompetitionQuestionQueryDto;
import com.arong.oj.entity.response.CompetitionQuestionResponse;
import com.arong.oj.entity.response.CompetitionQuestionResponse;
import com.arong.oj.error.BusinessException;
import com.arong.oj.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.CompetitionQuestion;
import com.arong.oj.service.CompetitionQuestionService;
import com.arong.oj.mapper.CompetitionQuestionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.arong.oj.common.Code.SQL_ERROR;

/**
* @author centos7
* @description 针对表【competition_question】的数据库操作Service实现
* @createDate 2023-10-22 10:35:09
*/
@Service
public class CompetitionQuestionServiceImpl extends ServiceImpl<CompetitionQuestionMapper, CompetitionQuestion>
    implements CompetitionQuestionService{

    @Override
    public Long publishCompetitionQuestion(CompetitionQuestionAddDto competitionQuestionAddDto) {
        CompetitionQuestion competitionQuestion = BeanUtil.copyProperties(competitionQuestionAddDto, CompetitionQuestion.class);
        boolean save = save(competitionQuestion);
        if(!save) {
            throw new BusinessException(SQL_ERROR);
        }
        return competitionQuestion.getId();
    }

    @Override
    public boolean deleteCompetitionQuestion(DeleteDto deleteDto) {
        return removeById(deleteDto.getId());
    }

    @Override
    public Long editCompetitionQuestion(CompetitionQuestionEditDto competitionQuestionEditDto) {
        CompetitionQuestion competitionQuestion = BeanUtil.copyProperties(competitionQuestionEditDto, CompetitionQuestion.class);
        boolean b = updateById(competitionQuestion);
        if(!b) {
            throw new BusinessException(SQL_ERROR);
        }
        return competitionQuestion.getId();
    }

    @Override
    public Page<CompetitionQuestionResponse> getCompetitionQuestionList(CompetitionQuestionQueryDto competitionQuestionQueryDto) {
        QueryWrapper<CompetitionQuestion> competitionQuestionQueryWrapper = new QueryWrapper<>();
        competitionQuestionQueryWrapper.lambda()
                .eq(competitionQuestionQueryDto.getId() != null && competitionQuestionQueryDto.getId() > 0, CompetitionQuestion::getId, competitionQuestionQueryDto.getId())
                .eq(competitionQuestionQueryDto.getCompetitionId() != null && competitionQuestionQueryDto.getCompetitionId() > 0, CompetitionQuestion::getCompetitionId, competitionQuestionQueryDto.getCompetitionId())
                .eq(competitionQuestionQueryDto.getQuestionId() != null, CompetitionQuestion::getQuestionId, competitionQuestionQueryDto.getQuestionId());


        List<CompetitionQuestion> list = list(competitionQuestionQueryWrapper);
        List<CompetitionQuestionResponse> collect = list.stream().map(competitionQuestion -> BeanUtil.copyProperties(competitionQuestion, CompetitionQuestionResponse.class)).collect(Collectors.toList());
        Page<CompetitionQuestionResponse> pageList = PageUtil.getPageList(collect, competitionQuestionQueryDto.getCurrentPage(), competitionQuestionQueryDto.getPageSize());
        return pageList;
    }

    @Override
    public CompetitionQuestionResponse getCompetitionQuestion(Long competitionQuestionId) {
        QueryWrapper<CompetitionQuestion> competitionQuestionQueryWrapper = new QueryWrapper<>();
        competitionQuestionQueryWrapper.lambda()
                .eq(competitionQuestionId != null && competitionQuestionId > 0, CompetitionQuestion::getId, competitionQuestionId);
        CompetitionQuestion one = getOne(competitionQuestionQueryWrapper);
        CompetitionQuestionResponse competitionQuestionResponse = BeanUtil.copyProperties(one, CompetitionQuestionResponse.class);
        return competitionQuestionResponse;
    }
}




