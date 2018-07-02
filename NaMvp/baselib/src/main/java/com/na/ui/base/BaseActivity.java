package com.na.ui.base;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.na.utils.AppManager;
import com.na.utils.permission.PermissionChecker;

/**
 * Created by oneal23 on 2018/6/26.
 */
public class BaseActivity extends AppCompatActivity {

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

    protected boolean isFullSreen() {
        return false;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (isFullSreen()){
            hideActionBar();
            setStatusBarColor(Color.TRANSPARENT);
        }
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().removeActivity(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionChecker.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        PermissionChecker.onActivityResult(this, requestCode, resultCode, data);
    }
}
