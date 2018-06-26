package com.na.demo.data.net.base;

import com.na.data.net.IBaseHttpRequest;
import com.na.data.net.IHttpHeader;
import com.na.data.net.IHttpParameter;

/**
 * @actor:taotao
 * @DATE: 2018/5/25
 */
public abstract class ApiRequest<T> implements IBaseHttpRequest {

    @Override
    public IHttpHeader getHeaders() {
        return null;
    }

    @Override
    public IHttpParameter getParameters() {
        return null;
    }
}
