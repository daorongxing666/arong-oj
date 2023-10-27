package com.arong.oj.controller;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.common.Result;
import com.arong.oj.entity.request.solution.SolutionAddDto;
import com.arong.oj.entity.request.solution.SolutionEditDto;
import com.arong.oj.entity.request.solution.SolutionQueryDto;
import com.arong.oj.entity.response.SolutionResponse;
import com.arong.oj.service.SolutionService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@Slf4j
@RestController()
@RequestMapping(value = "/solution")
public class SolutionController {
    
    @Resource
    SolutionService solutionService;

    /**
     * 获取题解列表
     * @param solutionQueryDto
     * @return
     * @throws IOException
     */
    @PostMapping("/list")
    public Result<Page<SolutionResponse>> getSolutionList(@RequestBody SolutionQueryDto solutionQueryDto) {
        Page<SolutionResponse> solutionList = solutionService.getSolutionList(solutionQueryDto);
        return Result.succeed(solutionList);
    }

    /**
     * 新增题解
     * @param solutionAddDto
     * @return
     */
    @PostMapping("/add")
    public Result<SolutionResponse> addSolution(@RequestBody SolutionAddDto solutionAddDto) {
        Long solutionId = solutionService.publishSolution(solutionAddDto);
        SolutionResponse solutionDetail = solutionService.getSolution(solutionId);
        return Result.succeed(solutionDetail);
    }

    /**
     * 获取单道题解详情
     * @param solutionId
     * @return
     */
    @GetMapping("/detail/{solutionId}")
    public Result<SolutionResponse> getSolutionDetail(@PathVariable Long solutionId) {
        SolutionResponse solutionDetail = solutionService.getSolution(solutionId);
        return Result.succeed(solutionDetail);
    }

    /**
     * 编辑题解
     * @param solutionEditDto
     * @return
     */
    @PostMapping("/edit")
    public Result<Boolean> editSolution(@RequestBody SolutionEditDto solutionEditDto) {
        Long solutionId = solutionService.editSolution(solutionEditDto);
        return Result.succeed(solutionId != null);
    }

    /**
     * 删除题解
     * @param deleteDto
     * @return
     */
    @PostMapping("/remove")
    public Result<Boolean> removeSolution(@RequestBody DeleteDto deleteDto) {
        Boolean b = solutionService.deleteSolution(deleteDto);
        return Result.succeed(b);
    }
}
