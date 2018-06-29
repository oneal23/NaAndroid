package com.na.demo.app;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.na.app.BaseAppliction;
import com.na.demo.BuildConfig;
import com.na.utils.LogUtil;

/**
 * Created by oneal23 on 2018/6/26.
 */
public class DemoApp extends BaseAppliction{
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.init("NaLibsDemo");
        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }
    }
}
