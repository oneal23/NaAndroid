package com.na.demo.ui.splash.view;

import com.na.demo.R;
import com.na.ui.mvp.view.ButterKnifeView;
import com.na.ui.widget.NaImageView;

import butterknife.BindView;

/**
 * @actor:taotao
 * @DATE: 2018/5/23
 */
public class SplashView extends ButterKnifeView {

    @BindView(R.id.ivBg)
    NaImageView ivBg;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
