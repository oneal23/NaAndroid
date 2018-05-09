package com.na.mvp.app;

import android.app.Application;

import com.na.mvp.di.component.ApplicationComponent;
import com.na.mvp.di.component.DaggerApplicationComponent;
import com.na.mvp.di.module.ApplicationModule;

/**
 * @actor:taotao
 * @DATE: 2018/4/6
 */

public class NaApplication extends Application {
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
