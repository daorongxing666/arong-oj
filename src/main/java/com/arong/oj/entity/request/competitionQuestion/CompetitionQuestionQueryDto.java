package com.arong.oj.entity.request.competitionQuestion;

import com.arong.oj.common.Page;
import lombok.Data;

/**
 * 
 * 竞赛题目响应类
 */
@Data
public class CompetitionQuestionQueryDto extends Page {
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
     * 第一道题目通过率
     */
    private Long questionPassRate;

    /**
     * 第一道题目难度分
     */
    private Long questionDifficultyScore;


}