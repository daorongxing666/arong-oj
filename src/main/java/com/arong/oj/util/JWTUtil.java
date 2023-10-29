package com.arong.oj.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import springfox.documentation.annotations.Cacheable;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtil {
    // 过期时间15分钟
    private static final long EXPIRE_TIME = 15 * 60 * 1000;
    // 私钥
    private static final String TOKEN_SECRET = "privateKey";

    private static StringRedisTemplate stringRedisTemplate;

    @Autowired
    ApplicationContext applicationContext;
    @PostConstruct
    public void init() {
        JWTUtil.stringRedisTemplate = applicationContext.getBean(StringRedisTemplate.class);
    }

    public static String getToken(Long id) {
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // 返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withClaim("id", id)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Long verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("id").asLong();
        } catch (Exception e){
            return 0L;
        }
    }


    public static Long getCurrentUser(HttpServletRequest request) {
        Object token = request.getSession().getAttribute("token");
        String userId = stringRedisTemplate.opsForValue().get(token);
        if(userId == null) {
            return 0L;
        }
        return Long.valueOf(userId);
    }
}