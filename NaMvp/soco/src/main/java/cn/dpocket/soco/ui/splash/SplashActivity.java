package cn.dpocket.soco.ui.splash;

import android.os.Bundle;

import com.na.ui.mvp.databind.BaseRxDataBindActivity;

import cn.dpocket.soco.ui.splash.view.SplashView;

public class SplashActivity extends BaseRxDataBindActivity<SplashView> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Class getBaseViewClass() {
        return SplashView.class;
    }
}
