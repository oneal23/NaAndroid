package com.na.mvp.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by oneal23 on 2018/6/26.
 */

public interface ISchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}
