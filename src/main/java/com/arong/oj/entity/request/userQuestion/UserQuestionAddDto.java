package com.arong.oj.entity.request.userQuestion;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 用户答题响应类
 */
@Data
public class UserQuestionAddDto {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 题目id
     */
    private Long questionId;

    /**
     * 答题语言(后面用枚举类)
     */
    private Integer language;

    /**
     * 答题状态(后面用枚举类)
     */
    private Integer status;

    /**
     * 答题代码
     */
    private String code;

    /**
     * 答题信息
     */
    private String msg;
}