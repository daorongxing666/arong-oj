package com.arong.oj.entity.response;

import com.arong.oj.common.Page;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName topic
 */
@TableName(value ="topic")
@Data
public class TopicResponse {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 帖子标题
     */
    private String title;

    /**
     * 帖子内容
     */
    private String content;

    /**
     * 热度
     */
    private Integer hot;

    /**
     * 点赞数
     */
    private Integer starCount;

}