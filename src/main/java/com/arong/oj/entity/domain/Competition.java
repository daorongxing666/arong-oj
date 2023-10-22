package com.arong.oj.entity.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName competition
 */
@TableName(value ="competition")
@Data
public class Competition implements Serializable {
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

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 是否删除
     */
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Competition other = (Competition) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompetitionName() == null ? other.getCompetitionName() == null : this.getCompetitionName().equals(other.getCompetitionName()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getSubscribeCount() == null ? other.getSubscribeCount() == null : this.getSubscribeCount().equals(other.getSubscribeCount()))
            && (this.getJoinCount() == null ? other.getJoinCount() == null : this.getJoinCount().equals(other.getJoinCount()))
            && (this.getAverageScore() == null ? other.getAverageScore() == null : this.getAverageScore().equals(other.getAverageScore()))
            && (this.getAverageTime() == null ? other.getAverageTime() == null : this.getAverageTime().equals(other.getAverageTime()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getIsdelete() == null ? other.getIsdelete() == null : this.getIsdelete().equals(other.getIsdelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompetitionName() == null) ? 0 : getCompetitionName().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getSubscribeCount() == null) ? 0 : getSubscribeCount().hashCode());
        result = prime * result + ((getJoinCount() == null) ? 0 : getJoinCount().hashCode());
        result = prime * result + ((getAverageScore() == null) ? 0 : getAverageScore().hashCode());
        result = prime * result + ((getAverageTime() == null) ? 0 : getAverageTime().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getIsdelete() == null) ? 0 : getIsdelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", competitionName=").append(competitionName);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", subscribeCount=").append(subscribeCount);
        sb.append(", joinCount=").append(joinCount);
        sb.append(", averageScore=").append(averageScore);
        sb.append(", averageTime=").append(averageTime);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", isdelete=").append(isdelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}