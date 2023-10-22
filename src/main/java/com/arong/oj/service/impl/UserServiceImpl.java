package com.arong.oj.service.impl;

import com.arong.oj.common.DeleteDto;
import com.arong.oj.entity.request.user.UserLoginDto;
import com.arong.oj.entity.request.user.UserRegisterDto;
import com.arong.oj.entity.request.user.UserSearchDto;
import com.arong.oj.entity.request.user.UserUpdateDto;
import com.arong.oj.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.User;
import com.arong.oj.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author centos7
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-10-21 15:54:15
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Override
    public void register(UserRegisterDto userRegisterDto) {

    }

    @Override
    public void login(UserLoginDto userLoginDto) {

    }

    @Override
    public void logout(DeleteDto deleteDto) {

    }

    @Override
    public List<User> getUserList(UserSearchDto userSearchDto) {
        return null;
    }

    @Override
    public boolean updateUser(UserUpdateDto userUpdateDto) {
        return false;
    }

    @Override
    public boolean deleteUser(Long userId) {
        return false;
    }
}




