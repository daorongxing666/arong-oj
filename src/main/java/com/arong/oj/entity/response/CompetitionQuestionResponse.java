package com.arong.oj.entity.response;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 竞赛题目响应类
 */
@Data
public class CompetitionQuestionResponse {
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

    /**
     * 在竞赛中的题号
     */
    private Long competitionQuestionNum;

}