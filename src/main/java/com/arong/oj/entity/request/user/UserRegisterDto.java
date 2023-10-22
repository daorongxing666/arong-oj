package com.arong.oj.entity.request.user;

import lombok.Data;

/**
 * 用户注册请求实体类
 */
@Data
public class UserRegisterDto {

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 确认密码
     */
    private String checkPassword;
}
