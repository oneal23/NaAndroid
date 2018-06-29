package com.na.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by oneal23 on 2018/6/26.
 */
public class BaseAppliction extends Application{
    private static BaseAppliction mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }

    public static BaseAppliction getApp() {
        return mApp;
    }

    public static Context getContext() {
        return mApp.getApplicationContext();
    }
}
