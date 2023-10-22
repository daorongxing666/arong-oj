package com.arong.oj.entity.request.competitionQuestion;

import lombok.Data;

/**
 * 
 * 竞赛题目响应类
 */
@Data
public class CompetitionQuestionEditDto {
    /**
     * 主键
     */
    private Long id;

    /**
     * 竞赛id
     */
    private Long competitionId;

    /**
     * 第一道题目id
     */
    private Long questionId;

    /**
     * 第一道题目分数
     */
    private Long questionScore;

    /**
     * 在竞赛中的题号
     */
    private Long competitionQuestionNum;

}