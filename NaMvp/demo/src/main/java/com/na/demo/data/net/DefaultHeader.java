package com.na.demo.data.net;

import com.google.gson.annotations.SerializedName;
import com.na.data.net.IHttpHeader;

/**
 * @actor:taotao
 * @DATE: 2018/5/25
 */
public class DefaultHeader implements IHttpHeader {
    @SerializedName("versionNumber")
    private String versionCode;

    @SerializedName("versionName")
    private String versionName;

    @SerializedName("meAppType")
    private String appType;

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }
}
