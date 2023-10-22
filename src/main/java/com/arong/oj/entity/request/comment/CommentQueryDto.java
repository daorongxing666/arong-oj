package com.arong.oj.entity.request.comment;

import com.arong.oj.common.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 评价返回响应类
 */
@Data
public class CommentQueryDto extends Page {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 回复评论id(没有则-1)
     */
    private Long parentCommentId;

    /**
     * 内容
     */
    private String content;

}