package com.na.mvp.utils.rx;

import io.reactivex.Scheduler;

/**
 *  @actor:taotao
 * @DATE: 2018/4/7
 */

public interface ISchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}
