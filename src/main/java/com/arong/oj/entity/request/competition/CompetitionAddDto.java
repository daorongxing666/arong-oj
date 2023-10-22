package com.arong.oj.entity.request.competition;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 
 * 竞赛返回响应类
 */
@Data
public class CompetitionAddDto {

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

}