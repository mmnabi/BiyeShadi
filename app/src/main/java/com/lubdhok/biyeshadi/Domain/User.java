package com.lubdhok.biyeshadi.Domain;

import java.io.Serializable;

/**
 * Created by PrinceOfNightmareH on 29-Dec-17.
 */

public class User implements Serializable{
    private int userId;
    private String username, password;
    private UserInfo userInfo;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
