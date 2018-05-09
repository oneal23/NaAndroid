package com.na.mvp.ui.main;

import dagger.Component;

/**
 * @actor:taotao
 * @DATE: 2018/4/6
 */

@Component(modules = AppModule.class)
public interface AppComponent {
    AppItem provideAppItem();
    MainActivityComponent activityComponent();
}
