package com.arong.oj.service.impl;

import com.arong.oj.entity.request.competition.CompetitionAddDto;
import com.arong.oj.entity.request.competition.CompetitionEditDto;
import com.arong.oj.entity.request.competition.CompetitionQueryDto;
import com.arong.oj.entity.response.CompetitionResponse;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.Competition;
import com.arong.oj.service.CompetitionService;
import com.arong.oj.mapper.CompetitionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author centos7
* @description 针对表【competition】的数据库操作Service实现
* @createDate 2023-10-22 10:35:05
*/
@Service
public class CompetitionServiceImpl extends ServiceImpl<CompetitionMapper, Competition>
    implements CompetitionService{

    @Override
    public Long publishCompetition(CompetitionAddDto competitionAddDto) {
        return null;
    }

    @Override
    public boolean deleteCompetition(Long competitionId) {
        return false;
    }

    @Override
    public Long editCompetition(CompetitionEditDto competitionEditDto) {
        return null;
    }

    @Override
    public List<CompetitionResponse> getCompetitionList(CompetitionQueryDto competitionQueryDto) {
        return null;
    }

    @Override
    public CompetitionResponse getCompetition(Long competitionId) {
        return null;
    }
}




