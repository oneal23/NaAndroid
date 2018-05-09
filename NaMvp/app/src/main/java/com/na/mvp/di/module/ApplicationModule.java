package com.na.mvp.di.module;

import android.app.Application;
import android.content.Context;

import com.na.mvp.di.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * @actor:taotao
 * @DATE: 2018/4/7
 */

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }
}
