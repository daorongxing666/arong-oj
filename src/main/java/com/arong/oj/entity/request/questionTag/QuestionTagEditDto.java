package com.arong.oj.entity.request.questionTag;

import lombok.Data;

/**
 * 
 * 题目标签编辑请求类
 */
@Data
public class QuestionTagEditDto {
    /**
     * 主键
     */
    private Long id;

    /**
     * 标签标题
     */
    private String title;

}