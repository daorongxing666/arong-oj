package com.arong.oj.entity.request.userQuestionLike;

import com.arong.oj.common.Page;
import lombok.Data;

import java.util.Date;

/**
 * 
 * 用户题目收藏响应类
 */
@Data
public class UserQuestionLikeQueryDto extends Page {
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

}