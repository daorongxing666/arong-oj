package com.arong.oj.service.impl;

import com.arong.oj.entity.request.competitionQuestion.CompetitionQuestionAddDto;
import com.arong.oj.entity.request.competitionQuestion.CompetitionQuestionEditDto;
import com.arong.oj.entity.request.competitionQuestion.CompetitionQuestionQueryDto;
import com.arong.oj.entity.response.CompetitionQuestionResponse;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.CompetitionQuestion;
import com.arong.oj.service.CompetitionQuestionService;
import com.arong.oj.mapper.CompetitionQuestionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public boolean deleteCompetitionQuestion(Long competitionQuestionId) {
        return false;
    }

    @Override
    public Long editCompetitionQuestion(CompetitionQuestionEditDto competitionQuestionEditDto) {
        return null;
    }

    @Override
    public List<CompetitionQuestionResponse> getCompetitionQuestionList(CompetitionQuestionQueryDto competitionQuestionQueryDto) {
        return null;
    }

    @Override
    public CompetitionQuestionResponse getCompetitionQuestion(Long competitionQuestionId) {
        return null;
    }
}




