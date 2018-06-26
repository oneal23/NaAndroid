package com.na.data.net;

import io.reactivex.Single;

/**
 * Created by oneal23 on 2018/6/26.
 */
public interface IHttpHelper<R> {
    Single<R> sendRequest(IBaseHttpRequest request);
}
