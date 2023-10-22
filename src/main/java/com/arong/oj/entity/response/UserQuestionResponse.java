package com.arong.oj.entity.response;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 用户答题响应类
 */
@Data
public class UserQuestionResponse implements Serializable {
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