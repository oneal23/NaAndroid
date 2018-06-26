package com.na.utils;

/**
 * @actor:taotao
 * @DATE: 2018/5/23
 */
public class AppUtils {
    public static class AppUtilsHolder{
        public final static AppUtils INSTANCE = new AppUtils();
    }

    private AppUtils() {

    }

    public static AppUtils getInstance(){
        return AppUtilsHolder.INSTANCE;
    }
}
