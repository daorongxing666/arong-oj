package com.arong.oj.controller;


import com.alibaba.excel.util.StringUtils;
import com.arong.oj.common.Result;
import com.arong.oj.entity.request.user.UserLoginDto;
import com.arong.oj.entity.request.user.UserRegisterDto;
import com.arong.oj.entity.response.UserResponse;
import com.arong.oj.service.UserService;
import com.arong.oj.util.RedisUtil;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController()
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private Producer producer;

    @Resource
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/register")
    public Result<UserResponse> register(@RequestBody UserRegisterDto userRegisterDto) throws IOException {
        UserResponse register = userService.register(userRegisterDto);
        return Result.succeed(register);
    }

    @PostMapping("/login")
    public Result<UserResponse> login(@RequestBody UserLoginDto userLoginDto) throws IOException {
        UserResponse userResponse = userService.login(userLoginDto);
        return Result.succeed(userResponse);
    }

    @ApiOperation("获取验证码")
    @GetMapping("/code")
    public ModelAndView code(String time, HttpServletResponse response) throws IOException {
        StringBuffer key = new StringBuffer();
        key.append(time).append("-").append(Constants.KAPTCHA_SESSION_KEY);

        //响应的过期时间，通过将Expires字段设置为0，可以告诉浏览器不要缓存这个响应，每次都需要重新请求服务器获取最新的数据。
        response.setDateHeader("Expires", 0);

        // 设置标准 HTTP1.1 无缓存标头。
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

        // 设置 IE 扩展 HTTP1.1 无缓存标头（使用 addHeader）。
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");

        // 设置标准 HTTP1.0 无缓存标头。
        response.setHeader("Pragma", "no-cache");

        // 返回一个 jpeg
        response.setContentType("image/jpeg");

        // 为图像创建文本
        String capText = producer.createText();

        // 为图像创建文本
        if (!StringUtils.isEmpty(time)){
            //时间戳不为空才加入缓存
            stringRedisTemplate.opsForValue().set(key.toString(),capText);
            stringRedisTemplate.expire(key.toString(), 5, TimeUnit.MINUTES);
        }
        // 用文本创建图像
        BufferedImage bi = producer.createImage(capText);

        ServletOutputStream out = response.getOutputStream();

        // 将数据写出
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }
}
