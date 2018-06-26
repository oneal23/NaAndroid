package com.na.demo.data.net.base;

import com.google.gson.annotations.SerializedName;
import com.na.data.net.IBaseHttpResponse;

/**
 * @actor:taotao
 * @DATE: 2018/5/25
 */
public abstract class ApiResponse<D> implements IBaseHttpResponse {

    @SerializedName("success")
    private boolean success = false;

    @SerializedName("message")
    private String message;

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
