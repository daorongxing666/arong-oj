package com.arong.oj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.domain.Competition;
import com.arong.oj.entity.request.competition.CompetitionAddDto;
import com.arong.oj.entity.request.competition.CompetitionEditDto;
import com.arong.oj.entity.request.competition.CompetitionQueryDto;
import com.arong.oj.entity.response.CompetitionResponse;
import com.arong.oj.entity.response.CompetitionResponse;
import com.arong.oj.error.BusinessException;
import com.arong.oj.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.Competition;
import com.arong.oj.service.CompetitionService;
import com.arong.oj.mapper.CompetitionMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.arong.oj.common.Code.SQL_ERROR;

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
        Competition competition = BeanUtil.copyProperties(competitionAddDto, Competition.class);
        boolean save = save(competition);
        if(!save) {
            throw new BusinessException(SQL_ERROR);
        }
        return competition.getId();
    }

    @Override
    public boolean deleteCompetition(DeleteDto deleteDto) {
        return removeById(deleteDto.getId());
    }

    @Override
    public Long editCompetition(CompetitionEditDto competitionEditDto) {
        Competition competition = BeanUtil.copyProperties(competitionEditDto, Competition.class);
        boolean b = updateById(competition);
        if(!b) {
            throw new BusinessException(SQL_ERROR);
        }
        return competition.getId();
    }

    @Override
    public Page<CompetitionResponse> getCompetitionList(CompetitionQueryDto competitionQueryDto) {
        QueryWrapper<Competition> competitionQueryWrapper = new QueryWrapper<>();
        competitionQueryWrapper.lambda()
                .eq(competitionQueryDto.getId() != null && competitionQueryDto.getId() > 0, Competition::getId, competitionQueryDto.getId())
                .eq(competitionQueryDto.getCompetitionName() != null && competitionQueryDto.getCompetitionName().equals(""), Competition::getCompetitionName, competitionQueryDto.getCompetitionName())
;
        List<Competition> list = list(competitionQueryWrapper);
        List<CompetitionResponse> collect = list.stream().map(competition -> BeanUtil.copyProperties(competition, CompetitionResponse.class)).collect(Collectors.toList());
        Page<CompetitionResponse> pageList = PageUtil.getPageList(collect, competitionQueryDto.getCurrentPage(), competitionQueryDto.getPageSize());
        return pageList;
    }

    @Override
    public CompetitionResponse getCompetition(Long competitionId) {
        QueryWrapper<Competition> competitionQueryWrapper = new QueryWrapper<>();
        competitionQueryWrapper.lambda()
                .eq(competitionId != null && competitionId > 0, Competition::getId, competitionId);
        Competition one = getOne(competitionQueryWrapper);
        CompetitionResponse competitionResponse = BeanUtil.copyProperties(one, CompetitionResponse.class);
        return competitionResponse;
    }
}




