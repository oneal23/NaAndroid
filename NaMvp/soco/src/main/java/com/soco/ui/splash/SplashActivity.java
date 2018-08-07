package com.soco.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.na.ui.mvp.databind.BaseRxDataBindActivity;
import com.soco.ui.login.LoginActivity;
import com.soco.ui.splash.view.SplashView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SplashActivity extends BaseRxDataBindActivity<SplashView> {
    private final static int DELAY_TIME = 2000;
    private boolean isSplash = false;


    @Override
    public Class getBaseViewClass() {
        return SplashView.class;
    }

    @Override
    protected boolean isFullSreen() {
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setStatusBarColorResId(R.color.bg_color_5);
    }

    @Override
    protected void onResume() {
        super.onResume();
        splash();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void splash() {
        if (!isSplash) {
            isSplash = true;
            Observable<Long> observable = Observable.timer(DELAY_TIME, TimeUnit.MILLISECONDS)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui());
            observable.subscribe(new Observer<Long>() {
                @Override
                public void onSubscribe(Disposable d) {
                    addDisposable(d);
                }

                @Override
                public void onNext(Long l) {
                }

                @Override
                public void onError(Throwable e) {
                    isSplash = false;
                    gotoLogin();
                }

                @Override
                public void onComplete() {
                    isSplash = false;
                    gotoLogin();
                }
            });
        } else {
            gotoLogin();
        }
    }

    private void gotoLogin() {
        Intent intent = new Intent();
        intent.setClass(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
