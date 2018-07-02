package com.na.ui.mvp.databind;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.na.ui.mvp.view.IBaseView;
import com.na.utils.rx.AppSchedulerProvider;
import com.na.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by oneal23 on 2018/6/26.
 */
public abstract class BaseRxDataBindActivity<V extends IBaseView> extends BaseDataBindActivity<V> {

    private SchedulerProvider mSchedulerProvider;

    private CompositeDisposable mCompositeDisposable;

    protected SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    protected CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    protected void setSchedulerProvider(SchedulerProvider mSchedulerProvider) {
        this.mSchedulerProvider = mSchedulerProvider;
    }

    protected void setCompositeDisposable(CompositeDisposable mCompositeDisposable) {
        this.mCompositeDisposable = mCompositeDisposable;
    }

    protected void createSchedulerProvider(){
        if(getSchedulerProvider() == null){
           setSchedulerProvider(new AppSchedulerProvider());
        }
    }

    protected void createCompositeDisposable(){
        if (getCompositeDisposable() == null){
            setCompositeDisposable(new CompositeDisposable());
        }
    }

    protected void addDisposable(Disposable disposable) {
        if (getCompositeDisposable() != null) {
            getCompositeDisposable().add(disposable);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createSchedulerProvider();
        createCompositeDisposable();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getCompositeDisposable() != null){
            getCompositeDisposable().dispose();
        }
    }
}
