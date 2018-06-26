package com.na.demo.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.na.demo.ui.login.LoginActivity;
import com.na.demo.ui.splash.view.SplashView;
import com.na.ui.mvp.databind.BaseRxDataBindActivity;
import com.na.utils.LogUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

public class SplashActivity extends BaseRxDataBindActivity<SplashView> {

    private static final String TAG = "SplashActivity";

    private final static int DELAY_TIME = 3000;

    private boolean isSplash = false;

    private void gotoLogin() {
        Intent intent = new Intent();
        intent.setClass(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public Class<SplashView> getBaseViewClass() {
        return SplashView.class;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        hideActionBar();
//        setStatusBarColorResId(R.color.bg_color_1);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isSplash) {
            isSplash = true;
            Observable<Long> observable = Observable.timer(DELAY_TIME, TimeUnit.MILLISECONDS)
                    .subscribeOn(getSchedulerProvider().io())
                    .observeOn(getSchedulerProvider().ui());
            getCompositeDisposable().add(observable.subscribeWith(new DisposableObserver<Long>() {

                @Override
                public void onNext(Long l) {
                    LogUtils.d(TAG, "onNext " + l);
                }

                @Override
                public void onError(Throwable e) {
                    LogUtils.d(TAG, "onError ");
                    isSplash = false;
                }

                @Override
                public void onComplete() {
                    LogUtils.d(TAG, "onComplete ");
                    isSplash = false;
//                    gotoLogin();
                }
            }));
        }
    }
}
