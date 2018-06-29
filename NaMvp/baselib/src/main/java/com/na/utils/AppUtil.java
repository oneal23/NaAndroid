package com.na.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by oneal23 on 2018/6/26.
 */
public final class AppUtil extends BaseUtil{
    private static class AppUtilHolder{
        public final static AppUtil INSTANCE = new AppUtil();
    }

    private AppUtil() {

    }

    public static AppUtil getInstance(){
        return AppUtilHolder.INSTANCE;
    }

    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public String getVersionName() {
        String version = "";
        try {
            PackageManager manager = getContext().getPackageManager();
            PackageInfo info = manager.getPackageInfo(getContext().getPackageName(), PackageManager.GET_PERMISSIONS);
            version = info.versionName;
        } catch (Exception e) {
           version = "";

        }
        return version;
    }

    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public int getVersionCode() {
        int versionCode = -1;
        try {
            PackageManager manager = getContext().getPackageManager();
            PackageInfo info = manager.getPackageInfo(getContext().getPackageName(), PackageManager.GET_PERMISSIONS);
            versionCode = info.versionCode;
        } catch (Exception e) {
            LogUtil.e(e, "getVersionCode error");
        }
        return versionCode;
    }
}
