package com.arong.oj.Interceptor;


import cn.hutool.json.JSON;
import cn.hutool.json.JSONParser;
import cn.hutool.json.JSONUtil;
import com.arong.oj.common.Code;
import com.arong.oj.entity.domain.User;
import com.arong.oj.entity.response.UserResponse;
import com.arong.oj.error.BusinessException;
import com.arong.oj.service.UserService;
import com.arong.oj.util.UserThreadLocal;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.json.Json;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        UserResponse LoginUser = UserThreadLocal.get();
        String token = LoginUser.getToken();
        request.getSession().setAttribute("Authorization", token);

        log.info("===============request start===============");
        log.info("request uri:{}", request.getRequestURI());
        log.info("request method:{}", request.getMethod());
        log.info("token:{}", token);
        log.info("===============request end===============");

        if (token == null) {
            throw new BusinessException(Code.UN_LOGIN_ERROR);
        }
        String s = stringRedisTemplate.opsForValue().get(token);
        UserResponse userResponse = JSONUtil.toBean(s, UserResponse.class);
        if (userResponse == null) {
            throw new BusinessException(Code.UN_LOGIN_ERROR);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserThreadLocal.remove();
    }
}
