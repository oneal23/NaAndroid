package com.na.utils.rx;

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
