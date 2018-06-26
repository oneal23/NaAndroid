package com.na.ui.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.na.utils.AppManager;

/**
 * @actor:taotao
 * @DATE: 2018/5/23
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().removeActivity(this);
    }

    protected void hideActionBar() {
        getSupportActionBar().hide();
    }

    protected void showActionBar() {
        getSupportActionBar().show();
    }

    protected boolean setStatusBarColor(@ColorInt int color){
        boolean flag = false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(color);
            flag = true;
        }
        return flag;
    }

    protected boolean setStatusBarColorResId(int colorResId) {
        boolean flag = false;
        if (colorResId > 0){
            int color = getResources().getColor(colorResId);
            flag = setStatusBarColor(color);
        }
        return flag;
    }

    protected boolean setLightStatusBar(){
        boolean flag = false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            flag = true;
        }
        return flag;
    }
}
