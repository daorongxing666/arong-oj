package com.arong.oj.error;

/**
 * 用户操作错误返回类
 */
public class UserException extends RuntimeException {

    private final int code;

    private final String msg;

    public UserException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public UserException(int code) {
        super("用户操作错误");
        this.code = code;
        this.msg = "用户操作错误";
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
