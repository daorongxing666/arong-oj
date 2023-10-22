package com.arong.oj.entity.request.comment;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 评价返回响应类
 */
@Data
public class CommentEditDto implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 内容
     */
    private String content;

}