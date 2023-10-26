package com.arong.oj.service.impl;
import java.util.Date;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.arong.oj.common.Code;
import com.arong.oj.common.DeleteDto;
import com.arong.oj.common.Result;
import com.arong.oj.entity.request.user.UserLoginDto;
import com.arong.oj.entity.request.user.UserRegisterDto;
import com.arong.oj.entity.request.user.UserSearchDto;
import com.arong.oj.entity.request.user.UserUpdateDto;
import com.arong.oj.entity.response.UserResponse;
import com.arong.oj.error.BusinessException;
import com.arong.oj.error.UserException;
import com.arong.oj.service.UserService;
import com.arong.oj.util.JWTUtil;
import com.arong.oj.util.PageUtil;
import com.arong.oj.util.RedisUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.arong.oj.entity.domain.User;
import com.arong.oj.mapper.UserMapper;
import com.google.code.kaptcha.Constants;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static com.arong.oj.common.Code.PARAM_ERROR;
import static com.arong.oj.common.Code.SYSTEM_ERROR;

/**
* @author centos7
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-10-21 15:54:15
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Resource
    JWTUtil jwtUtil;

    @Resource
    UserMapper userMapper;

    @Override
    public UserResponse register(UserRegisterDto userRegisterDto) {
        // 空参数校验
        String account = userRegisterDto.getAccount();
        if(account == null) {
            throw new UserException(Code.WRONG_INPUT.getCodeNum(), "请输入您的账号");
        }
        if(userRegisterDto.getPassword() == null || userRegisterDto.getCheckPassword() == null) {
            throw new UserException(Code.WRONG_INPUT.getCodeNum(), "请输入您的密码");
        }
        // 校验用户名是否重复
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(User::getUserName, account);
        List<User> list = this.list(userQueryWrapper);
        if(list.size() > 0) {
            throw new UserException(Code.WRONG_INPUT.getCodeNum(), "用户账号重复，请重新输入");
        }
        // 校验两次密码输入是否一致
        if(!Objects.equals(userRegisterDto.getPassword(), userRegisterDto.getCheckPassword())) {
            throw new UserException(Code.WRONG_INPUT.getCodeNum(), "两次密码输入不一致，请重新输入");
        }
        String psw = SecureUtil.md5(userRegisterDto.getPassword());
        User user = new User();
        user.setUserName(account);
        user.setNickname(account);
        user.setPassword(psw);
        user.setAvatar(Optional.ofNullable(userRegisterDto.getAvatar()).orElse(null));
        user.setEmail(Optional.ofNullable(userRegisterDto.getEmail()).orElse(null));
        user.setGithubAddress(Optional.ofNullable(userRegisterDto.getGithubAddress()).orElse(null));
        boolean save = this.save(user);
        if(!save) {
            throw new BusinessException(SYSTEM_ERROR.getCodeNum(), "系统错误");
        }
        return BeanUtil.copyProperties(user, UserResponse.class);
    }

    @Override
    public UserResponse login(UserLoginDto userLoginDto) {
        // 获取验证码
        Object redisCode = stringRedisTemplate.opsForValue().get(userLoginDto.getTime()+"-"+ Constants.KAPTCHA_SESSION_KEY);
        if(redisCode == null) {
            throw new BusinessException(SYSTEM_ERROR);
        }
        else if(!Objects.equals(redisCode, userLoginDto.getCheckCode())) {
            throw new UserException(Code.EMPTY_INPUT.getCodeNum(), "验证码输入错误");
        }
        if(userLoginDto.getAccount() == null) {
            throw new UserException(Code.EMPTY_INPUT.getCodeNum(), "请输入用户名");
        }
        if(userLoginDto.getPassword() == null) {
            throw new UserException(Code.EMPTY_INPUT.getCodeNum(), "请输入密码");
        }
        String psw = SecureUtil.md5(userLoginDto.getPassword());
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(User::getUserName, userLoginDto.getAccount());
        userQueryWrapper.lambda().eq(User::getPassword, psw);
        User user = this.getOne(userQueryWrapper);
        if(user == null) {
            throw new UserException(Code.WRONG_INPUT.getCodeNum(), "用户名或者密码错误");
        }
        String token = jwtUtil.getToken(user.getId());
        if(token == null) {
            throw new UserException(PARAM_ERROR.getCodeNum(),"登录失效");
        }
        UserResponse userResponse = BeanUtil.copyProperties(user, UserResponse.class);
        userResponse.setToken(token);
        stringRedisTemplate.opsForValue().set(user.getId().toString(), String.valueOf(userResponse), 1, TimeUnit.DAYS);
        return userResponse;
    }

    @Override
    public void logout(DeleteDto deleteDto) {
        stringRedisTemplate.delete(deleteDto.getId().toString());
    }

    @Override
    public Page<User> getUserList(UserSearchDto userSearchDto) {
        String userAccount = userSearchDto.getUserAccount();
        String nickName = userSearchDto.getNickName();
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(userAccount != null, User::getUserName, userAccount)
                .eq(nickName != null, User::getNickname, nickName);
        List<User> list = this.list(userQueryWrapper);
        Page<User> userPage = PageUtil.getPageList(list, userSearchDto.getCurrentPage(), userSearchDto.getPageSize());
        return userPage;
    }

    @Override
    public boolean updateUser(UserUpdateDto userUpdateDto) {
        User user = BeanUtil.copyProperties(userUpdateDto, User.class);
        return updateById(user);
    }

    @Override
    public boolean deleteUser(DeleteDto deleteDto) {
        return this.removeById(deleteDto.getId());
    }

    @Override
    public UserResponse getLoginUser(Long userId) {
        String userResponseString = stringRedisTemplate.opsForValue().get(userId.toString());
        return JSONUtil.toBean(userResponseString, UserResponse.class);
    }
}




