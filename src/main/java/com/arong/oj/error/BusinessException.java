package com.arong.oj.error;

import com.arong.oj.common.Code;
import com.squareup.okhttp.internal.framed.ErrorCode;

public class BusinessException extends RuntimeException {
    /**
     * 错误码
     */
    private int code;

    private String message;

    public BusinessException(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public BusinessException(Code code) {
        super(code.getDescription());
        this.code = code.getCodeNum();
    }

    public BusinessException(Code code, String message) {
        this.message = message;
        this.code = code.getCodeNum();
    }

    public int getCode() {
        return code;
    }

}
