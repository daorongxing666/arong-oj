package com.arong.oj.entity.request.topic;

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
@Data
public class TopicPublishDto implements Serializable {

    /**
     * 话题标题
     */
    private String title;

    /**
     * 话题内容
     */
    private String content;




}