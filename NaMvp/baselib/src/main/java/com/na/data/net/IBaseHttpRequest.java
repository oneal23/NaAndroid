package com.na.data.net;

import java.io.Serializable;

/**
 * @actor:taotao
 * @DATE: 2018/5/25
 */
public interface IBaseHttpRequest<T> extends Serializable{
    int GET = 0;
    int POST = 1;
    int PUT = 2;
    int DELETE = 3;

    String getUrl();

    int getMethod();

    IHttpHeader getHeaders();

    IHttpParameter getParameters();

    Class<T> getResponseClass();
}
