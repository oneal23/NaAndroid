package com.na.ui.base;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.na.utils.permission.PermissionChecker;

/**
 * Created by oneal23 on 2018/6/26.
 */
public class BaseFragment extends Fragment {

    protected void hideActionBar() {
       getBaseActivity().hideActionBar();
    }

    protected void showActionBar() {
        getBaseActivity().showActionBar();
    }

    protected boolean setStatusBarColor(@ColorInt int color){
        return getBaseActivity().setStatusBarColor(color);
    }

    protected boolean setStatusBarColorResId(int colorResId) {
        return getBaseActivity().setStatusBarColorResId(colorResId);
    }

    protected boolean setLightStatusBar(){
        return getBaseActivity().setLightStatusBar();
    }

    protected boolean isFullSreen() {
        return false;
    }


    protected BaseActivity getBaseActivity(){
        return (BaseActivity) getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (isFullSreen()){
            hideActionBar();
            setStatusBarColor(Color.TRANSPARENT);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionChecker.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        PermissionChecker.onActivityResult(this, requestCode, resultCode, data);
    }
}
