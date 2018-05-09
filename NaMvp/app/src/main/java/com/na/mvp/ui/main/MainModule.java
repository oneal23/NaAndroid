package com.na.mvp.ui.main;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @actor:taotao
 * @DATE: 2018/4/7
 */

@Module
public class MainModule {
    @Provides
    public MainItem proMainItem() {
        return new MainItem();
    }

    @Named("two")
    @Provides
    public MainItem provideMainItem() {
        return new MainItem();
    }

    @Provides
    @Singleton
    public MainItem1 proMainItem1() {
        return new MainItem1();
    }
}