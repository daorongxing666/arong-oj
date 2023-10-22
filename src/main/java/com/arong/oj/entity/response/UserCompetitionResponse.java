package com.arong.oj.entity.response;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 用户比赛响应类
 */
@Data
public class UserCompetitionResponse implements Serializable {
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