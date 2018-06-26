package com.na.utils;

import android.support.annotation.NonNull;
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

    public static void e(@Nullable Throwable throwable, @NonNull String message, @Nullable Object... args){
        Logger.e(throwable, message, args);
    }

    public static void e(@NonNull String message, @Nullable Object... args) {
        e(null, message, args);
    }

    public static void w(@NonNull String message, @Nullable Object... args) {
        Logger.w(message, args);
    }

    public static void i(@NonNull String message, @Nullable Object... args) {
        Logger.i(message, args);
    }


    public static void d(@NonNull String message, @Nullable Object... args) {
        Logger.d(message, args);
    }

    public static void v(@NonNull String message, @Nullable Object... args) {
        Logger.v(message, args);
    }

    public static void json(String json) {
        Logger.json(json);
    }

    public static void xml(String xml){
        Logger.xml(xml);
    }
}
