package com.na.utils;

import android.support.annotation.Nullable;

import com.na.base.BuildConfig;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * @actor:taotao
 * @DATE: 2018/5/23
 */
public class LogUtils {

    public static String TAG = "NaLibs";
    public static boolean DEBUG = BuildConfig.DEBUG;
    private static boolean isInited = false;

    public static void setTag(String tag) {
        LogUtils.TAG = tag;
    }

    public static void setDebug(boolean debug) {
        LogUtils.DEBUG = debug;
    }

    public static void init(String tag){
        setTag(tag);
        init();
    }

    private static void init() {
        if (!isInited) {
            FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                    .showThreadInfo(true)
                    .methodCount(2)
                    .tag(TAG)   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                    .build();

            Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {

                @Override
                public boolean isLoggable(int priority, @Nullable String tag) {
                    return LogUtils.DEBUG;
                }
            });
        }
    }

    public static void e(String tag, String msg, Throwable e) {
        Logger.e(e, tag + ":" + msg);
    }

    public static void e(String tag, String msg) {
        Logger.e(tag + ":" + msg);
    }

    public static void w(String tag, String msg) {
        Logger.w(tag + ":" + msg);
    }

    public static void i(String tag, String msg) {
        Logger.i(tag + ":" + msg);
    }


    public static void d(String tag, String msg) {
        Logger.d(tag + ":" + msg);
    }

    public static void v(String tag, String msg) {
        Logger.v(tag + ":" + msg);
    }

    public static void json(String json) {
        Logger.json(json);
    }
}
