package com.arong.oj.entity.request.solution;

import lombok.Data;

import java.util.Date;

/**
 * 
 * 题解返回响应类
 */
@Data
public class SolutionAddDto {

    /**
     * 题目id
     */
    private Long questionId;

    /**
     * 笔记链接
     */
    private String url;

    /**
     * 笔记标题
     */
    private String title;

    /**
     * 笔记字数
     */
    private Integer wordNum;
}