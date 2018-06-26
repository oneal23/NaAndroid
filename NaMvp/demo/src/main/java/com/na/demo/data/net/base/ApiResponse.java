package com.na.demo.data.net.base;

import com.google.gson.annotations.SerializedName;
import com.na.data.net.IBaseHttpResponse;

/**
 * Created by oneal23 on 2018/6/26.
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
