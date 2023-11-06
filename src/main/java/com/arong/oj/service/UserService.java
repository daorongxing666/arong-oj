package com.arong.oj.service;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.domain.User;
import com.arong.oj.entity.request.user.UserLoginDto;
import com.arong.oj.entity.request.user.UserRegisterDto;
import com.arong.oj.entity.request.user.UserSearchDto;
import com.arong.oj.entity.request.user.UserUpdateDto;
import com.arong.oj.entity.response.UserResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author centos7
* @description 针对表【user】的数据库操作Service
* @createDate 2023-10-21 15:54:15
*/
public interface UserService extends IService<User> {

    /**
     * 用户注册
     * @param userRegisterDto 用户注册请求类
     */
    public UserResponse register(UserRegisterDto userRegisterDto);

    /**
     * 用户登录
     * @param userLoginDto 用户登录请求类
     */
    public UserResponse login(UserLoginDto userLoginDto);

    /**
     * 用户注销
     * @param deleteDto 用户id
     */
    public void logout(DeleteDto deleteDto);

    /**
     * 获取用户列表
     * @param userSearchDto 用户请求封装类
     * @return
     */
    public Page<User> getUserList(UserSearchDto userSearchDto);

    /**
     * 用户个人信息更新
     * @param userUpdateDto 用户更新请求类
     * @return
     */
    public boolean updateUser(UserUpdateDto userUpdateDto);

    /**
     * 删除用户
     * @param userId 用户id
     * @return
     */
    public boolean deleteUser(DeleteDto deleteDto);

    /**
     * 获取当前登录用户
     * @param userId
     * @return
     */
    public UserResponse getLoginUser(HttpServletRequest request);
}
