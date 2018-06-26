package com.na.utils;

/**
 * Created by oneal23 on 2018/6/26.
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
