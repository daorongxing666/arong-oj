package com.arong.oj.common;

import lombok.Data;

/**
 * 分页参数请求类
 */
@Data
public class Page {

    /**
     * 每页条码数
     */
    private Integer pageSize;

    /**
     * 当前页码数
     */
    private Integer currentPage;

    /**
     * 总数
     */
    private Integer totalCount;
}
