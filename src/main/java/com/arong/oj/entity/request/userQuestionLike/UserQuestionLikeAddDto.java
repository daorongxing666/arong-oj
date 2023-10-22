package com.arong.oj.entity.request.userQuestionLike;

import lombok.Data;

import java.util.Date;

/**
 * 
 * 用户题目收藏响应类
 */
@Data
public class UserQuestionLikeAddDto {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 题目id
     */
    private Long questionId;
}