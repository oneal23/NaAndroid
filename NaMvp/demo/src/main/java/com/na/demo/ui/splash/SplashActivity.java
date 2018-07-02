package com.na.demo.ui.splash;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.na.demo.R;
import com.na.demo.ui.login.LoginActivity;
import com.na.demo.ui.splash.view.SplashView;
import com.na.ui.mvp.databind.BaseRxDataBindActivity;
import com.na.utils.LogUtil;
import com.na.utils.permission.Permission;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SplashActivity extends BaseRxDataBindActivity<SplashView> {

    private static final String TAG = "SplashActivity";

    private final static int DELAY_TIME = 2000;
    private static final int PHONESTATE = 200;

    private boolean isSplash = false;

    private boolean isNeedCheckPermission = false;

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
        hideActionBar();
        setStatusBarColorResId(R.color.transparent);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!isNeedCheckPermission) {
            isNeedCheckPermission = true;
            Permission.with(this)
                    .addRequestCode(PHONESTATE)
                    .addPermissions(Manifest.permission.READ_PHONE_STATE)
                    .request(new Permission.PermissionCallback() {
                        @Override
                        public void onPermissionsGranted(int requestCode) {
                            LogUtil.e("permissionSuccess requsetCode=" + requestCode);
                            splash();
                        }

                        @Override
                        public void onPermissionsDenied(int requestCode) {
                            LogUtil.e("onPermissionsDenied requsetCode=" + requestCode);
                            splash();
                        }

                        @Override
                        public void onPermissionsDeniedAlways(int requestCode) {
                            LogUtil.e("onPermissionsDeniedAlways requsetCode=" + requestCode);
                            splash();
                        }
                    });
        } else {
            splash();
        }
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
                    LogUtil.d("onSubscribe current thread" + Thread.currentThread().getName());
                }

                @Override
                public void onNext(Long l) {
                    LogUtil.d(TAG, "onNext " + l);
                }

                @Override
                public void onError(Throwable e) {
                    LogUtil.d(TAG, "onError ");
                    isSplash = false;
                }

                @Override
                public void onComplete() {
                    LogUtil.d(TAG, "onComplete ");
                    isSplash = false;
                    gotoLogin();
                }
            });
        }
    }

}
