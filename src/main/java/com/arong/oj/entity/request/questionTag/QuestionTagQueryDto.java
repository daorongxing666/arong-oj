package com.arong.oj.entity.request.questionTag;

import com.arong.oj.common.Page;
import lombok.Data;

/**
 * 
 * 题目标签查询请求类
 */
@Data
public class QuestionTagQueryDto extends Page {
    /**
     * 主键
     */
    private Long id;

    /**
     * 标签标题
     */
    private String title;

}