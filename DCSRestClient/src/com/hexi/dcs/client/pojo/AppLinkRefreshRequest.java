package com.hexi.dcs.client.pojo;

public class AppLinkRefreshRequest {
    private String appLinkID;
    private String accessToken;
    private String refreshToken;

    public void setAppLinkID(String AppLinkID) {
        this.appLinkID = AppLinkID;
    }

    public String getAppLinkID() {
        return appLinkID;
    }

    public void setAccessToken(String AccessToken) {
        this.accessToken = AccessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setRefreshToken(String RefreshToken) {
        this.refreshToken = RefreshToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
