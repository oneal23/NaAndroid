package com.na.data.net;

import java.io.Serializable;

/**
 * Created by oneal23 on 2018/6/26.
 */
public interface IBaseHttpResponse<D> extends Serializable {

    boolean isSuccess();

    String getMessage();

    D getData();
}
