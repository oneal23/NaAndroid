package com.na.demo.app;

import com.na.app.BaseAppliction;
import com.na.demo.data.AppDataManager;
import com.na.utils.LogUtil;

/**
 * Created by oneal23 on 2018/6/26.
 */
public class DemoApp extends BaseAppliction{
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.init("NaLibsDemo");
        AppDataManager.getInstance().init(getApplicationContext());
    }
}
