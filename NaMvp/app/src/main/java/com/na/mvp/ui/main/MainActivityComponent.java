package com.na.mvp.ui.main;

import javax.inject.Singleton;

import dagger.Subcomponent;

/**
 * @actor:taotao
 * @DATE: 2018/4/6
 */
@Singleton()
@Subcomponent(modules = MainModule.class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
