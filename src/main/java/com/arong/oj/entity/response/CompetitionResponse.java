package com.arong.oj.entity.response;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 竞赛返回响应类
 */
@Data
public class CompetitionResponse {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 竞赛名称
     */
    private String competitionName;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 被订阅数
     */
    private Long subscribeCount;

    /**
     * 参加人数
     */
    private Long joinCount;

    /**
     * 平均分数
     */
    private Long averageScore;

    /**
     * 平均作答时间(min)
     */
    private Long averageTime;
}