package com.arong.oj.controller;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.common.Result;
import com.arong.oj.entity.request.post.PostEditDto;
import com.arong.oj.entity.request.post.PostPublishDto;
import com.arong.oj.entity.request.post.PostQueryDto;
import com.arong.oj.entity.response.PostResponse;
import com.arong.oj.service.PostService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@Slf4j
@RestController()
@RequestMapping(value = "/post")
public class PostController {
    
    @Resource
    PostService postService;

    /**
     * 获取帖子列表
     * @param postQueryDto
     * @return
     * @throws IOException
     */
    @PostMapping("/list")
    public Result<Page<PostResponse>> getPostList(@RequestBody PostQueryDto postQueryDto) {
        Page<PostResponse> postList = postService.getPostList(postQueryDto);
        return Result.succeed(postList);
    }

    /**
     * 新增帖子
     * @param postAddDto
     * @return
     */
    @PostMapping("/add")
    public Result<PostResponse> addPost(@RequestBody PostPublishDto postAddDto) {
        Long postId = postService.publishPost(postAddDto);
        PostResponse postDetail = postService.getPost(postId);
        return Result.succeed(postDetail);
    }

    /**
     * 获取单道帖子详情
     * @param postId
     * @return
     */
    @GetMapping("/detail/{postId}")
    public Result<PostResponse> getPostDetail(@PathVariable Long postId) {
        PostResponse postDetail = postService.getPost(postId);
        return Result.succeed(postDetail);
    }

    /**
     * 编辑帖子
     * @param postEditDto
     * @return
     */
    @PostMapping("/edit")
    public Result<Boolean> editPost(@RequestBody PostEditDto postEditDto) {
        Long postId = postService.editPost(postEditDto);
        return Result.succeed(postId != null);
    }

    /**
     * 删除帖子
     * @param deleteDto
     * @return
     */
    @PostMapping("/remove")
    public Result<Boolean> removePost(@RequestBody DeleteDto deleteDto) {
        Boolean b = postService.deletePost(deleteDto);
        return Result.succeed(b);
    }
}
