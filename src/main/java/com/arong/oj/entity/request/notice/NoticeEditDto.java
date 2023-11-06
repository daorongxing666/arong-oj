package com.arong.oj.entity.request.notice;

import lombok.Data;

import java.io.Serializable;

/**
 * 通知表
 * @TableName notice
 */
@Data
public class NoticeEditDto implements Serializable {

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

}