package com.arong.oj.entity.request.userNote;

import com.arong.oj.common.Page;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 
 * 用户笔记响应类
 */
@Data
public class UserNoteQueryDto extends Page {
    /**
     * 主键
     */
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
     * 是否收藏
     */
    private Integer collect;

}