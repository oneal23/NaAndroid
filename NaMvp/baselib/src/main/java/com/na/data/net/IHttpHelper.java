package com.na.data.net;

import io.reactivex.Single;

/**
 * @actor:taotao
 * @DATE: 2018/5/25
 */
public interface IHttpHelper<R> {
    Single<R> sendRequest(IBaseHttpRequest request);
}
