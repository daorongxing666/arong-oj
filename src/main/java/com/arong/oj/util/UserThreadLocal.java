package com.arong.oj.util;


import com.arong.oj.entity.domain.User;
import com.arong.oj.entity.response.UserResponse;

public class UserThreadLocal {
    private UserThreadLocal() {

    }

    private static final ThreadLocal<UserResponse> LOCAL = new ThreadLocal<>();

    public static void put(UserResponse userResponse) {
        LOCAL.set(userResponse);
    }

    public static UserResponse get() {
        return LOCAL.get();
    }

    public static void remove() {
        LOCAL.remove();
    }
}

