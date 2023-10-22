package com.arong.oj.entity.response;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 题解返回响应类
 */
@Data
public class SolutionResponse {
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

    /**
     * 点赞数
     */
    private Integer starCount;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;
}