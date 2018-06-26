package com.na.utils.crash;

import com.na.utils.LogUtils;

/**
 * Created by oneal23 on 2018/6/26.
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static final String TAG = "CrashHandler";

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        LogUtils.e(e, TAG, t);
    }
}
