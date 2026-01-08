package com.mkahn.mkahn.config;

import com.mkahn.mkahn.dto.UserDto;

public class UserContext {

    private static final ThreadLocal<UserDto> userHolder = new ThreadLocal<>();

    public static void setUser(UserDto user) {
        userHolder.set(user);
    }

    public static UserDto getUser() {
        return userHolder.get();
    }

    public static void clear() {
        userHolder.remove();
    }
}
