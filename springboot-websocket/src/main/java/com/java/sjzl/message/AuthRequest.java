package com.java.sjzl.message;

/**
 * @author Java升级之路
 * @description
 * @date 2021/5/27
 */
public class AuthRequest implements Message{
    public static final String TYPE = "AUTH_REQUEST";

    /**
     * 认证 Token
     */
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
