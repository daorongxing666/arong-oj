package com.arong.oj.entity.request.userQuestion;

import com.arong.oj.common.Page;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 用户答题响应类
 */
@Data
public class UserQuestionQueryDto extends Page {
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

}