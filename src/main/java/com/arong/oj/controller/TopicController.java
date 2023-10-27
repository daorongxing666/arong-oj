package com.arong.oj.controller;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.common.Result;
import com.arong.oj.entity.request.topic.TopicEditDto;
import com.arong.oj.entity.request.topic.TopicPublishDto;
import com.arong.oj.entity.request.topic.TopicQueryDto;
import com.arong.oj.entity.response.TopicResponse;
import com.arong.oj.service.TopicService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@Slf4j
@RestController()
@RequestMapping(value = "/topic")
public class TopicController {
    
    @Resource
    TopicService topicService;

    /**
     * 获取主题列表
     * @param topicQueryDto
     * @return
     * @throws IOException
     */
    @PostMapping("/list")
    public Result<Page<TopicResponse>> getTopicList(@RequestBody TopicQueryDto topicQueryDto) {
        Page<TopicResponse> topicList = topicService.getTopicList(topicQueryDto);
        return Result.succeed(topicList);
    }

    /**
     * 新增主题
     * @param topicAddDto
     * @return
     */
    @PostMapping("/add")
    public Result<TopicResponse> addTopic(@RequestBody TopicPublishDto topicAddDto) {
        Long topicId = topicService.publishTopic(topicAddDto);
        TopicResponse topicDetail = topicService.getTopic(topicId);
        return Result.succeed(topicDetail);
    }

    /**
     * 获取单道主题详情
     * @param topicId
     * @return
     */
    @GetMapping("/detail/{topicId}")
    public Result<TopicResponse> getTopicDetail(@PathVariable Long topicId) {
        TopicResponse topicDetail = topicService.getTopic(topicId);
        return Result.succeed(topicDetail);
    }

    /**
     * 编辑主题
     * @param topicEditDto
     * @return
     */
    @PostMapping("/edit")
    public Result<Boolean> editTopic(@RequestBody TopicEditDto topicEditDto) {
        boolean b = topicService.editTopic(topicEditDto);
        return Result.succeed(b);
    }

    /**
     * 删除主题
     * @param deleteDto
     * @return
     */
    @PostMapping("/remove")
    public Result<Boolean> removeTopic(@RequestBody DeleteDto deleteDto) {
        Boolean b = topicService.deleteTopic(deleteDto);
        return Result.succeed(b);
    }
}
