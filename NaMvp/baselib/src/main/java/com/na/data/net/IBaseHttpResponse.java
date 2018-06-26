package com.na.data.net;

import java.io.Serializable;

/**
 * @actor:taotao
 * @DATE: 2018/5/25
 */
public interface IBaseHttpResponse<D> extends Serializable {

    boolean isSuccess();

    String getMessage();

    D getData();
}
