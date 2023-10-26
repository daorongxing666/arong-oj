package com.arong.oj.entity.request.userCompetition;

import com.arong.oj.common.Page;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 用户比赛响应类
 */
@Data
public class UserCompetitionQueryDto extends Page {
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
     * 排名
     */
    private Long scoreRank;

}