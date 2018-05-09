package com.na.mvp.utils.rx;

import io.reactivex.Scheduler;

/**
 *  @actor:taotao
 * @DATE: 2018/4/7
 */

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}
