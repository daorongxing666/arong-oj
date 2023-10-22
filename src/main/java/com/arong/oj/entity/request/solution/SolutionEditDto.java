package com.arong.oj.entity.request.solution;

import lombok.Data;

import java.util.Date;

/**
 * 
 * 题解编辑请求类
 */
@Data
public class SolutionEditDto {
    /**
     * 主键
     */
    private Long id;

    /**
     * 笔记链接
     */
    private String url;

    /**
     * 笔记标题
     */
    private String title;

}