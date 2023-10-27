package com.arong.oj.controller;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.common.Result;
import com.arong.oj.entity.request.comment.CommentAddDto;
import com.arong.oj.entity.request.comment.CommentEditDto;
import com.arong.oj.entity.request.comment.CommentQueryDto;
import com.arong.oj.entity.response.CommentResponse;
import com.arong.oj.service.CommentService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@Slf4j
@RestController()
@RequestMapping(value = "/comment")
public class CommentController {
    
    @Resource
    CommentService commentService;

    /**
     * 获取帖子列表
     * @param commentQueryDto
     * @return
     * @throws IOException
     */
    @PostMapping("/list")
    public Result<Page<CommentResponse>> getCommentList(@RequestBody CommentQueryDto commentQueryDto) {
        Page<CommentResponse> commentList = commentService.getCommentList(commentQueryDto);
        return Result.succeed(commentList);
    }

    /**
     * 新增帖子
     * @param commentAddDto
     * @return
     */
    @PostMapping("/add")
    public Result<CommentResponse> addComment(@RequestBody CommentAddDto commentAddDto) {
        Long commentId = commentService.publishComment(commentAddDto);
        CommentResponse commentDetail = commentService.getComment(commentId);
        return Result.succeed(commentDetail);
    }

    /**
     * 获取单道帖子详情
     * @param commentId
     * @return
     */
    @GetMapping("/detail/{commentId}")
    public Result<CommentResponse> getCommentDetail(@PathVariable Long commentId) {
        CommentResponse commentDetail = commentService.getComment(commentId);
        return Result.succeed(commentDetail);
    }

    /**
     * 编辑帖子
     * @param commentEditDto
     * @return
     */
    @PostMapping("/edit")
    public Result<Boolean> editComment(@RequestBody CommentEditDto commentEditDto) {
        Long commentId = commentService.editComment(commentEditDto);
        return Result.succeed(commentId != null);
    }

    /**
     * 删除帖子
     * @param deleteDto
     * @return
     */
    @PostMapping("/remove")
    public Result<Boolean> removeComment(@RequestBody DeleteDto deleteDto) {
        Boolean b = commentService.deleteComment(deleteDto);
        return Result.succeed(b);
    }
}
