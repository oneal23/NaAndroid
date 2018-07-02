package com.na.data.net;

import java.io.Serializable;

/**
 * Created by oneal23 on 2018/6/26.
 */
public interface IBaseHttpRequest<T> extends Serializable{
    int GET = 0;
    int POST = 1;
    int PUT = 2;
    int DELETE = 3;

    String getUrl();

    int getMethod();

    IHttpHeader getHeaders();

    IHttpPathParameter getPathParameters();

    IHttpBodyParameter getBodyParmeter();

    Class<T> getResponseClass();

    String getContentType();

    String getUserAgent();
}
