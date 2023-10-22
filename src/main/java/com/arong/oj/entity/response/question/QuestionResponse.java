package com.arong.oj.entity.response.question;

import com.arong.oj.common.Page;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 题目返回相应类
 */
@Data
public class QuestionResponse {
    /**
     * 主键
     */
    private Long id;

    /**
     * 题目标题
     */
    private String title;

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