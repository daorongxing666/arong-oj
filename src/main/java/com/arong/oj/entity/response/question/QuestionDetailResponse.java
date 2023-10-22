package com.arong.oj.entity.response.question;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 题目详情返回相应类
 */
@Data
public class QuestionDetailResponse {
    /**
     * 主键
     */
    private Long id;

    /**
     * 题目标题
     */
    private String title;

    /**
     * 题目描述
     */
    private String description;

    /**
     * 输入列表
     */
    private String inputList;

    /**
     * 输出列表
     */
    private String outputList;

    /**
     * 时间限制
     */
    private Long timeLimit;

    /**
     * 内存限制
     */
    private Long spaceLimit;

    /**
     * 收藏数
     */
    private Integer starCount;

    /**
     * 难度（1-简单，2-中等，3-困难）
     */
    private Integer difficulty;

    /**
     * 标签集合
     */
    private String tags;

    /**
     * 通过数
     */
    private Integer acCount;

    /**
     * 提交数
     */
    private Integer commitCount;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

}