package com.na.mvp.ui.main;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * @actor:taotao
 * @DATE: 2018/4/7
 */

@Module
public class AppModule {
    Application application;

//    @Provides
//    public Application provideApplication() {
//        return application;
//    }

    @Provides
    public AppItem provideAppItem() {
        return new AppItem();
    }

    public AppModule(Application application) {
        this.application = application;
    }
}