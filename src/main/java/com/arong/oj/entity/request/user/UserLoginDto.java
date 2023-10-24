package com.arong.oj.entity.request.user;

import lombok.Data;

/**
 * 用户登录请求实体类
 */
@Data
public class UserLoginDto {

    /**
     * 时间
     */
    private String time;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String checkCode;
}
