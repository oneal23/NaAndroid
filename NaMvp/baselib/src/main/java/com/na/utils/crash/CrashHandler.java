package com.na.utils.crash;

import com.na.utils.LogUtils;

/**
 * @actor:taotao
 * @DATE: 2018/5/28
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static final String TAG = "CrashHandler";

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        LogUtils.e(e, TAG, t);
    }
}
