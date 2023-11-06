package com.arong.oj.entity.request.userQuestion;

import lombok.Data;

@Data
public class UserQuestionSummitDto {

    /**
     * 题目id
     */
    private Long questionId;

    /**
     * 语言
     */
    private String language;

    /**
     * 代码
     */
    private String code;
}
