package com.na.demo.data.net.base;

import com.na.data.net.IBaseHttpRequest;
import com.na.data.net.IHttpBodyParameter;
import com.na.data.net.IHttpHeader;
import com.na.data.net.IHttpPathParameter;

/**
 * Created by oneal23 on 2018/6/26.
 */
public abstract class ApiRequest<T> implements IBaseHttpRequest {
    public static String CONTENT_TYPE_GSON = "application/json;charset=UTF-8";

    private IHttpHeader headers;

    public void setHeaders(IHttpHeader headers) {
        this.headers = headers;
    }

    @Override
    public IHttpHeader getHeaders() {
        return headers;
    }

    @Override
    public IHttpPathParameter getPathParameters() {
        return null;
    }

    @Override
    public IHttpBodyParameter getBodyParmeter() {
        return null;
    }

    @Override
    public String getContentType() {
        return CONTENT_TYPE_GSON;
    }

    @Override
    public String getUserAgent() {
        return "android-demo";
    }
}
