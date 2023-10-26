package com.arong.oj.filter;

import com.arong.oj.util.JWTUtil;
import com.arong.oj.util.RedisUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Slf4j
@WebFilter(urlPatterns = "/user")
public class AuthFilter implements Filter {

    private static final String[] WHITE = new String[]{"/**/doc.*",
            "/**/swagger-ui.*",
            "/**/swagger-resources",
            "/**/webjars/**",
            "/**/v2/api-docs/**",
            "/register",
            "/login"};


    @Resource
    private RedisUtil redisUtil;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        try {
            // 如果路径在白名单中则直接放行
            String path = request.getServletPath();
            if(contains(WHITE, path)) {
                filterChain.doFilter(request, response);
                return;
            }

            // 如果token为空，过滤
            String token = request.getHeader("Authorization");
            if (StringUtils.isEmpty(token) || "null".equals(token)) {
                response.sendError(0, "token为空！");
                return ;
            }

            // 如果token不在redis缓存中，过滤
            if(redisUtil.get(token) == null) {
                response.sendError(1, "无有效登陆信息");
                return ;
            }

            // 若token解析失败，过滤
            Long id = JWTUtil.verify(token);
            if (id == 0) {
                response.sendError(2, "token解析失败！");
                return ;
            }

            // 如果鉴权成功，则更新token
            // 生成新的token
            String newToken = JWTUtil.getToken(id);
            // 删除旧的token
            if(!redisUtil.del(token)) {
                response.sendError(3, "token更新失败！");
                return ;
            }
            // 加入新的token
            if(!redisUtil.set(newToken, id.toString(), 900)) {
                response.sendError(4, "token更新失败！");
                return ;
            }
            response.addHeader("Authorization", newToken);
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            log.info("[AuthFilter.doFilter] exception: {}", e);
        }
    }

    public boolean contains(String[] array, String target) {
        return Arrays.asList(array).contains(target);
    }
}