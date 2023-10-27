package com.arong.oj.controller;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.common.Result;
import com.arong.oj.entity.request.question.QuestionAddDto;
import com.arong.oj.entity.request.question.QuestionEditDto;
import com.arong.oj.entity.request.question.QuestionQueryDto;
import com.arong.oj.entity.request.user.UserRegisterDto;
import com.arong.oj.entity.response.UserResponse;
import com.arong.oj.entity.response.question.QuestionDetailResponse;
import com.arong.oj.entity.response.question.QuestionResponse;
import com.arong.oj.service.QuestionService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@Slf4j
@RestController()
@RequestMapping(value = "/question")
public class QuestionController {

    @Resource
    QuestionService questionService;

    /**
     * 获取题目列表
     * @param questionQueryDto
     * @return
     * @throws IOException
     */
    @PostMapping("/list")
    public Result<Page<QuestionResponse>> getQuestionList(@RequestBody QuestionQueryDto questionQueryDto) {
        Page<QuestionResponse> questionList = questionService.getQuestionList(questionQueryDto);
        return Result.succeed(questionList);
    }

    /**
     * 新增题目
     * @param questionAddDto
     * @return
     */
    @PostMapping("/add")
    public Result<QuestionDetailResponse> addQuestion(@RequestBody QuestionAddDto questionAddDto) {
        Long questionId = questionService.addQuestion(questionAddDto);
        QuestionDetailResponse questionDetail = questionService.getQuestionDetail(questionId);
        return Result.succeed(questionDetail);
    }

    /**
     * 获取单道题目详情
     * @param questionId
     * @return
     */
    @GetMapping("/detail/{questionId}")
    public Result<QuestionDetailResponse> getQuestionDetail(@PathVariable Long questionId) {
        QuestionDetailResponse questionDetail = questionService.getQuestionDetail(questionId);
        return Result.succeed(questionDetail);
    }

    /**
     * 编辑题目
     * @param questionEditDto
     * @return
     */
    @PostMapping("/edit")
    public Result<Boolean> editQuestion(@RequestBody QuestionEditDto questionEditDto) {
        Long editQuestionId = questionService.editQuestion(questionEditDto);
        return Result.succeed(editQuestionId != null);
    }

    /**
     * 删除题目
     * @param deleteDto
     * @return
     */
    @PostMapping("/remove")
    public Result<Boolean> removeQuestion(@RequestBody DeleteDto deleteDto) {
        Boolean b = questionService.deleteQuestion(deleteDto);
        return Result.succeed(b);
    }
}
