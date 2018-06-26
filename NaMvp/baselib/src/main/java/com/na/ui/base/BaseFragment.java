package com.na.ui.base;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.na.utils.permission.NaPermission;

/**
 * Created by oneal23 on 2018/6/26.
 */
public class BaseFragment extends Fragment {
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        NaPermission.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }
}
