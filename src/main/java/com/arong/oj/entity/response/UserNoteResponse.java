package com.arong.oj.entity.response;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 用户笔记响应类
 */
@Data
public class UserNoteResponse {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 笔记链接
     */
    private String url;

    /**
     * 笔记标题
     */
    private String title;

    /**
     * 笔记字数
     */
    private Integer wordNum;

    /**
     * 是否收藏
     */
    private Integer collect;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;
}