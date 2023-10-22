package com.arong.oj.entity.request.question;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 题目新增请求类
 */
@Data
public class QuestionAddDto {

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
     * 难度（1-简单，2-中等，3-困难）
     */
    private Integer difficulty;

    /**
     * 标签集合
     */
    private String tags;

}