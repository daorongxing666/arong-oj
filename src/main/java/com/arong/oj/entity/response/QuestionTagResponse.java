package com.arong.oj.entity.response;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 题目标签响应类
 */
@Data
public class QuestionTagResponse {
    /**
     * 主键
     */
    private Long id;

    /**
     * 标签标题
     */
    private String title;

}