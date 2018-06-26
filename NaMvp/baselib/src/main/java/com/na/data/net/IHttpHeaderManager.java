package com.na.data.net;

/**
 * @actor:taotao
 * @DATE: 2018/5/25
 */
public interface IHttpHeaderManager {

    IHttpHeader getDefaultHeader();

    IHttpHeader getPrivateHeader();
}
