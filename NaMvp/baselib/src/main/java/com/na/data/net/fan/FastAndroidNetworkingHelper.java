package com.na.data.net.fan;

import com.na.data.net.IBaseHttpRequest;
import com.na.data.net.IHttpHelper;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import io.reactivex.Single;

/**
 * @actor:taotao
 * @DATE: 2018/5/25
 */
public class FastAndroidNetworkingHelper implements IHttpHelper {

    @Override
    public Single<?> sendRequest(IBaseHttpRequest request) {
              Single<?> single = null;
        if (request != null) {
            switch (request.getMethod()) {
                case IBaseHttpRequest.GET: {
                    single = get(request);
                    break;
                }
                case IBaseHttpRequest.POST: {
                    single = post(request);
                    break;
                }
            }
        }
        return single;
    }

    public Single<?> get(IBaseHttpRequest request) {
        return Rx2AndroidNetworking.get(request.getUrl())
                .addHeaders(request.getHeaders())
                .addPathParameter(request.getParameters())
                .build()
                .getObjectSingle(request.getResponseClass());
    }


    public Single<?> post(IBaseHttpRequest request) {
        return Rx2AndroidNetworking.post(request.getUrl())
                .addHeaders(request.getHeaders())
                .addPathParameter(request.getParameters())
                .build()
                .getObjectSingle(request.getResponseClass());
    }
}
