package com.arong.oj.common;

public enum Code {
    /**
     * 成功
     */
    SUCCEED(20000, "成功"),

    /**
     * 失败总称
     */
    FAIL(400, "失败");



    private Integer codeNum;

    private String description;

    Code(Integer codeNum, String description) {
        this.codeNum = codeNum;
        this.description = description;
    }

    public Integer getCodeNum() {
        return codeNum;
    }
}
