package com.arong.oj.entity.response;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 用户返回实体类
 */
@Data
public class UserResponse {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户名
     */
    private String nickname;

    /**
     * token
     */
    private String token;
}
