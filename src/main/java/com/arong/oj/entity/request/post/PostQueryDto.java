package com.arong.oj.entity.request.post;

import com.arong.oj.common.Page;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 帖子返回相应类
 */
@Data
public class PostQueryDto extends Page {
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
     * 话题id
     */
    private List<Long> topicIdList;

    /**
     * 创建时间
     */
    private Date createtime;

}
