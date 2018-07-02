package com.na.demo.ui.splash.view;

import com.na.demo.R;
import com.na.ui.mvp.view.ButterKnifeView;
import com.na.ui.widget.BaseImageView;

import butterknife.BindView;

/**
 * Created by oneal23 on 2018/6/26.
 */
public class SplashView extends ButterKnifeView {

    @BindView(R.id.ivBg)
    BaseImageView ivBg;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
