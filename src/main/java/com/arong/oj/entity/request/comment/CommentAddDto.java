package com.arong.oj.entity.request.comment;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 评价返回响应类
 */
@Data
public class CommentAddDto {

    /**
     * 回复评论id(没有则-1)
     */
    private Long parentCommentId;

    /**
     * 内容
     */
    private String content;
}