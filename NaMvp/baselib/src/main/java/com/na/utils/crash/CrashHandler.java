package com.na.utils.crash;

import com.na.utils.LogUtil;

/**
 * Created by oneal23 on 2018/6/26.
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static final String TAG = "CrashHandler";

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        LogUtil.e(e, TAG, t);
    }
}
