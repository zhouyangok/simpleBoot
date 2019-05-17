package com.crazyang.model;

/**
 * @ClassName LoginUser
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/17 上午9:36.
 */

public class LoginUser {

    private String username;
    private String password;
    private Integer rememberMe;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Integer rememberMe) {
        this.rememberMe = rememberMe;
    }
}
