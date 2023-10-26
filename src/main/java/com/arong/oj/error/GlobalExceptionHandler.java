package com.arong.oj.error;

import com.arong.oj.common.Code;
import com.arong.oj.common.Result;
import com.arong.oj.entity.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Result<?> businessExceptionHandler(BusinessException e) {
        log.error("BusinessException", e);
        return Result.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(UserException.class)
    public Result<?> userExceptionHandler(UserException e) {
        log.error("BusinessException", e);
        return Result.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Result<?> runtimeExceptionHandler(RuntimeException e) {
        log.error("RuntimeException", e);
        return Result.fail(Code.FAIL.getCodeNum(), "系统错误");
    }

}
