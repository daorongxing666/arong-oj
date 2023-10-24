package com.arong.oj.common;

import lombok.Data;

/**
 * 返回结果封装类
 * @param <T>
 */
@Data
public class Result<T>  {
    private Integer code;

    private String message;

    private T data;

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public Result(T data) {
        this.data = data;
        this.code = Code.SUCCEED.getCodeNum();
        this.message = "调用接口成功";
    }

    /**
     * 成功返回封装类
     * @param data
     * @return
     */
    public static <T> Result<T> succeed(T data) {
        return new Result<T>(data);
    }

    /**
     * 失败返回封装类
     * @param code
     * @param msg
     * @return
     */
    public static <T> Result fail(Integer code, String msg) {
        return new Result(code, msg);
    }

    /**
     * 失败返回封装类
     * @param msg
     * @return
     */
    public static <T> Result fail(String msg) {
        return new Result(Code.FAIL.getCodeNum(), msg);
    }
}
