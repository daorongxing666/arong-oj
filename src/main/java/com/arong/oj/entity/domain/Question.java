package com.arong.oj.entity.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName question
 */
@TableName(value ="question")
@Data
public class Question implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 题目标题
     */
    private String title;

    /**
     * 题目描述
     */
    private String description;

    /**
     * 输入列表
     */
    private String inputList;

    /**
     * 输出列表
     */
    private String outputList;

    /**
     * 时间限制
     */
    private Long timeLimit;

    /**
     * 内存限制
     */
    private Long spaceLimit;

    /**
     * 收藏数
     */
    private Integer starCount;

    /**
     * 难度（1-简单，2-中等，3-困难）
     */
    private Integer difficulty;

    /**
     * 标签集合
     */
    private String tags;

    /**
     * 通过数
     */
    private Integer acCount;

    /**
     * 提交数
     */
    private Integer commitCount;

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
        Question other = (Question) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getInputList() == null ? other.getInputList() == null : this.getInputList().equals(other.getInputList()))
            && (this.getOutputList() == null ? other.getOutputList() == null : this.getOutputList().equals(other.getOutputList()))
            && (this.getTimeLimit() == null ? other.getTimeLimit() == null : this.getTimeLimit().equals(other.getTimeLimit()))
            && (this.getSpaceLimit() == null ? other.getSpaceLimit() == null : this.getSpaceLimit().equals(other.getSpaceLimit()))
            && (this.getStarCount() == null ? other.getStarCount() == null : this.getStarCount().equals(other.getStarCount()))
            && (this.getDifficulty() == null ? other.getDifficulty() == null : this.getDifficulty().equals(other.getDifficulty()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()))
            && (this.getAcCount() == null ? other.getAcCount() == null : this.getAcCount().equals(other.getAcCount()))
            && (this.getCommitCount() == null ? other.getCommitCount() == null : this.getCommitCount().equals(other.getCommitCount()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getIsdelete() == null ? other.getIsdelete() == null : this.getIsdelete().equals(other.getIsdelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getInputList() == null) ? 0 : getInputList().hashCode());
        result = prime * result + ((getOutputList() == null) ? 0 : getOutputList().hashCode());
        result = prime * result + ((getTimeLimit() == null) ? 0 : getTimeLimit().hashCode());
        result = prime * result + ((getSpaceLimit() == null) ? 0 : getSpaceLimit().hashCode());
        result = prime * result + ((getStarCount() == null) ? 0 : getStarCount().hashCode());
        result = prime * result + ((getDifficulty() == null) ? 0 : getDifficulty().hashCode());
        result = prime * result + ((getTags() == null) ? 0 : getTags().hashCode());
        result = prime * result + ((getAcCount() == null) ? 0 : getAcCount().hashCode());
        result = prime * result + ((getCommitCount() == null) ? 0 : getCommitCount().hashCode());
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
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", inputList=").append(inputList);
        sb.append(", outputList=").append(outputList);
        sb.append(", timeLimit=").append(timeLimit);
        sb.append(", spaceLimit=").append(spaceLimit);
        sb.append(", starCount=").append(starCount);
        sb.append(", difficulty=").append(difficulty);
        sb.append(", tags=").append(tags);
        sb.append(", acCount=").append(acCount);
        sb.append(", commitCount=").append(commitCount);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", isdelete=").append(isdelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}