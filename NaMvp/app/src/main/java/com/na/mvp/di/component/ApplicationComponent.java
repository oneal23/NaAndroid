package com.na.mvp.di.component;

import android.app.Application;
import android.content.Context;

import com.na.mvp.app.NaApplication;
import com.na.mvp.di.ApplicationContext;
import com.na.mvp.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @actor:taotao
 * @DATE: 2018/4/7
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(NaApplication naApplication);

    @ApplicationContext
    Context context();

    Application application();
}
