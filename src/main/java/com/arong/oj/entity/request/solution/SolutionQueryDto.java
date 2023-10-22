package com.arong.oj.entity.request.solution;

import com.arong.oj.common.Page;
import lombok.Data;

import java.util.Date;

/**
 * 
 * 题解查询请求类
 */
@Data
public class SolutionQueryDto extends Page {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 题目id
     */
    private Long questionId;

    /**
     * 笔记标题
     */
    private String title;

}