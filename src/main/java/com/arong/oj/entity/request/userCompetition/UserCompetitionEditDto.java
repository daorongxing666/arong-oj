package com.arong.oj.entity.request.userCompetition;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 用户比赛响应类
 */
@Data
public class UserCompetitionEditDto implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 竞赛id
     */
    private Long competitionId;

    /**
     * 用户成绩列表
     */
    private String score;

    /**
     * 用户完成时间列表
     */
    private String costTime;

    /**
     * 排名
     */
    private Long scoreRank;

}