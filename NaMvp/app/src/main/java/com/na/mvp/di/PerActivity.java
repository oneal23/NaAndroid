package com.na.mvp.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @actor:taotao
 * @DATE: 2018/4/7
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {

}
