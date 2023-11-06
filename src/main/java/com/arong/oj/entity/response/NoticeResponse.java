package com.arong.oj.entity.response;

import com.arong.oj.common.Page;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 通知表
 * @TableName notice
 */
@Data
public class NoticeResponse {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 1-系统通知，2-点赞通知，3-回复通知，4-关注通知
     */
    private Long noticeType;

    /**
     * 内容
     */
    private String content;

    /**
     * 0-系统通知，行为用户
     */
    private Long noticeUserId;

    /**
     * 是否已读
     */
    private Integer isRead;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}