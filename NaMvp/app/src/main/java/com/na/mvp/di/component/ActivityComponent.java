package com.na.mvp.di.component;

import com.na.mvp.di.PerActivity;
import com.na.mvp.di.module.ActivityModule;

import dagger.Component;

/**
 * @actor:taotao
 * @DATE: 2018/4/7
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

}
