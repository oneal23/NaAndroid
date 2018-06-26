package com.na.demo.app;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.na.app.BaseAppliction;
import com.na.demo.BuildConfig;
import com.na.utils.LogUtils;

/**
 * @actor:taotao
 * @DATE: 2018/5/22
 */
public class DemoApp extends BaseAppliction{
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.init("NaLibsDemo");
        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }
    }
}
