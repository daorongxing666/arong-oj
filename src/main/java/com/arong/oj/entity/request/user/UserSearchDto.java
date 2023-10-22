package com.arong.oj.entity.request.user;

import com.arong.oj.common.Page;
import lombok.Data;

/**
 *  用户搜索请求实体类
 */
@Data
public class UserSearchDto extends Page {

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     *
     */

}
