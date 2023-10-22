package com.arong.oj.entity.request.post;

import lombok.Data;

import java.util.List;

/**
 * 帖子发布请求类
 */
@Data
public class PostEditDto {

    /**
     * 帖子id
     */
    private Long postId;

    /**
     * 帖子标题
     */
    private String title;

    /**
     * 帖子内容
     */
    private String content;

    /**
     * 话题标签集合
     */
    private List<Long> topicList;
}
