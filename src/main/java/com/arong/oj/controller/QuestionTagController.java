package com.arong.oj.controller;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.common.Result;
import com.arong.oj.entity.request.questionTag.QuestionTagAddDto;
import com.arong.oj.entity.request.questionTag.QuestionTagEditDto;
import com.arong.oj.entity.request.questionTag.QuestionTagQueryDto;
import com.arong.oj.entity.response.QuestionTagResponse;
import com.arong.oj.service.QuestionTagService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@Slf4j
@RestController()
@RequestMapping(value = "/questionTag")
public class QuestionTagController {
    
    @Resource
    QuestionTagService questionTagService;

    /**
     * 获取题目标签列表
     * @param questionTagQueryDto
     * @return
     * @throws IOException
     */
    @PostMapping("/list")
    public Result<Page<QuestionTagResponse>> getQuestionTagList(@RequestBody QuestionTagQueryDto questionTagQueryDto) {
        Page<QuestionTagResponse> questionTagList = questionTagService.getQuestionTagList(questionTagQueryDto);
        return Result.succeed(questionTagList);
    }

    /**
     * 新增题目标签
     * @param questionTagAddDto
     * @return
     */
    @PostMapping("/add")
    public Result<QuestionTagResponse> addQuestionTag(@RequestBody QuestionTagAddDto questionTagAddDto) {
        Long questionTagId = questionTagService.publishQuestionTag(questionTagAddDto);
        QuestionTagResponse questionTagDetail = questionTagService.getQuestionTag(questionTagId);
        return Result.succeed(questionTagDetail);
    }

    /**
     * 获取单道题目标签详情
     * @param questionTagId
     * @return
     */
    @GetMapping("/detail/{questionTagId}")
    public Result<QuestionTagResponse> getQuestionTagDetail(@PathVariable Long questionTagId) {
        QuestionTagResponse questionTagDetail = questionTagService.getQuestionTag(questionTagId);
        return Result.succeed(questionTagDetail);
    }

    /**
     * 编辑题目标签
     * @param questionTagEditDto
     * @return
     */
    @PostMapping("/edit")
    public Result<Boolean> editQuestionTag(@RequestBody QuestionTagEditDto questionTagEditDto) {
        Long questionTagId = questionTagService.editQuestionTag(questionTagEditDto);
        return Result.succeed(questionTagId != null);
    }

    /**
     * 删除题目标签
     * @param deleteDto
     * @return
     */
    @PostMapping("/remove")
    public Result<Boolean> removeQuestionTag(@RequestBody DeleteDto deleteDto) {
        Boolean b = questionTagService.deleteQuestionTag(deleteDto);
        return Result.succeed(b);
    }
}
