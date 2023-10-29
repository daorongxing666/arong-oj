package com.arong.oj.common;

public enum Code {
    /**
     * 成功
     */
    SUCCEED(20000, "成功"),

    /**
     * 失败总称
     */
    FAIL(400, "失败"),

    SYSTEM_ERROR(40000, "系统服务错误"),
    AUTH_ERROR(40001, "没有相应权限"),
    UN_LOGIN_ERROR(40002, "没有登录"),

    SQL_ERROR(40010, "数据库错误"),

    PARAM_ERROR(40001, "参数错误"),

    WRONG_INPUT(40002, "错误输入值"),

    EMPTY_INPUT(40003, "没有输入值");



    private Integer codeNum;

    private String description;

    Code(Integer codeNum, String description) {
        this.codeNum = codeNum;
        this.description = description;
    }

    public Integer getCodeNum() {
        return codeNum;
    }

    public String getDescription() {
        return description;
    }
}
