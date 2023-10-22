package com.arong.oj.entity.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName competition_question
 */
@TableName(value ="competition_question")
@Data
public class CompetitionQuestion implements Serializable {
    /**
     * 主键
     */
    @TableId
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
     * 第一道题目难度分（目前设想是根据通过率，通过时间最后算出来）
     */
    private Long questionDifficultyScore;

    /**
     * 在竞赛中的题号
     */
    private Long competitionQuestionNum;

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
        CompetitionQuestion other = (CompetitionQuestion) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompetitionId() == null ? other.getCompetitionId() == null : this.getCompetitionId().equals(other.getCompetitionId()))
            && (this.getQuestionId() == null ? other.getQuestionId() == null : this.getQuestionId().equals(other.getQuestionId()))
            && (this.getQuestionScore() == null ? other.getQuestionScore() == null : this.getQuestionScore().equals(other.getQuestionScore()))
            && (this.getQuestionPassRate() == null ? other.getQuestionPassRate() == null : this.getQuestionPassRate().equals(other.getQuestionPassRate()))
            && (this.getQuestionDifficultyScore() == null ? other.getQuestionDifficultyScore() == null : this.getQuestionDifficultyScore().equals(other.getQuestionDifficultyScore()))
            && (this.getCompetitionQuestionNum() == null ? other.getCompetitionQuestionNum() == null : this.getCompetitionQuestionNum().equals(other.getCompetitionQuestionNum()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getIsdelete() == null ? other.getIsdelete() == null : this.getIsdelete().equals(other.getIsdelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompetitionId() == null) ? 0 : getCompetitionId().hashCode());
        result = prime * result + ((getQuestionId() == null) ? 0 : getQuestionId().hashCode());
        result = prime * result + ((getQuestionScore() == null) ? 0 : getQuestionScore().hashCode());
        result = prime * result + ((getQuestionPassRate() == null) ? 0 : getQuestionPassRate().hashCode());
        result = prime * result + ((getQuestionDifficultyScore() == null) ? 0 : getQuestionDifficultyScore().hashCode());
        result = prime * result + ((getCompetitionQuestionNum() == null) ? 0 : getCompetitionQuestionNum().hashCode());
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
        sb.append(", competitionId=").append(competitionId);
        sb.append(", questionId=").append(questionId);
        sb.append(", questionScore=").append(questionScore);
        sb.append(", questionPassRate=").append(questionPassRate);
        sb.append(", questionDifficultyScore=").append(questionDifficultyScore);
        sb.append(", competitionQuestionNum=").append(competitionQuestionNum);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", isdelete=").append(isdelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}