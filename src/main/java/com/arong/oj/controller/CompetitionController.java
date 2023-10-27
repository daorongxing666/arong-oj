package com.arong.oj.controller;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.common.Result;
import com.arong.oj.entity.request.competition.CompetitionAddDto;
import com.arong.oj.entity.request.competition.CompetitionEditDto;
import com.arong.oj.entity.request.competition.CompetitionQueryDto;
import com.arong.oj.entity.response.CompetitionResponse;
import com.arong.oj.service.CompetitionService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@Slf4j
@RestController()
@RequestMapping(value = "/competition")
public class CompetitionController {
    
    @Resource
    CompetitionService competitionService;

    /**
     * 获取竞赛列表
     * @param competitionQueryDto
     * @return
     * @throws IOException
     */
    @PostMapping("/list")
    public Result<Page<CompetitionResponse>> getCompetitionList(@RequestBody CompetitionQueryDto competitionQueryDto) {
        Page<CompetitionResponse> competitionList = competitionService.getCompetitionList(competitionQueryDto);
        return Result.succeed(competitionList);
    }

    /**
     * 新增竞赛
     * @param competitionAddDto
     * @return
     */
    @PostMapping("/add")
    public Result<CompetitionResponse> addCompetition(@RequestBody CompetitionAddDto competitionAddDto) {
        Long competitionId = competitionService.publishCompetition(competitionAddDto);
        CompetitionResponse competitionDetail = competitionService.getCompetition(competitionId);
        return Result.succeed(competitionDetail);
    }

    /**
     * 获取单道竞赛详情
     * @param competitionId
     * @return
     */
    @GetMapping("/detail/{competitionId}")
    public Result<CompetitionResponse> getCompetitionDetail(@PathVariable Long competitionId) {
        CompetitionResponse competitionDetail = competitionService.getCompetition(competitionId);
        return Result.succeed(competitionDetail);
    }

    /**
     * 编辑竞赛
     * @param competitionEditDto
     * @return
     */
    @PostMapping("/edit")
    public Result<Boolean> editCompetition(@RequestBody CompetitionEditDto competitionEditDto) {
        Long aLong = competitionService.editCompetition(competitionEditDto);
        return Result.succeed(aLong != null);
    }

    /**
     * 删除竞赛
     * @param deleteDto
     * @return
     */
    @PostMapping("/remove")
    public Result<Boolean> removeCompetition(@RequestBody DeleteDto deleteDto) {
        Boolean b = competitionService.deleteCompetition(deleteDto);
        return Result.succeed(b);
    }
}
