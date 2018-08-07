package com.soco.ui.splash.view;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;

import com.na.ui.mvp.view.ButterKnifeView;
import com.na.ui.widget.BaseImageView;
import com.soco.R;

import butterknife.BindView;

/**
 * Created by oneal23 on 2018/8/7.
 */
public class SplashView extends ButterKnifeView {
    @BindView(R.id.ivLogo)
    BaseImageView ivLogo;
    @BindView(R.id.ivAnim)
    BaseImageView ivAnim;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        ivLogo.resId(R.drawable.splash_logo);
        ivAnim.resId(R.drawable.splash_anim);
    }

    @Override
    public void onResume() {
        super.onResume();
        startAnim();

    }

    @Override
    public void onPause() {
        super.onPause();
        stopAnim();
    }

    private void startAnim() {
        Drawable drawable = ivAnim.getDrawable();
        if (drawable != null && drawable instanceof AnimationDrawable) {
            AnimationDrawable ad = (AnimationDrawable) drawable;
            if (!ad.isRunning()) {
                ad.start();
            }
        }
    }

    private void stopAnim() {
        Drawable drawable = ivAnim.getDrawable();
        if (drawable != null && drawable instanceof AnimationDrawable) {
            AnimationDrawable ad = (AnimationDrawable) drawable;
            if (ad.isRunning()) {
                ad.stop();
            }
        }
    }
}
