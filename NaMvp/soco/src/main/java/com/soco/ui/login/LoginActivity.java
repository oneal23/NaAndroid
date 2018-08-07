package com.soco.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.na.ui.mvp.databind.BaseDataBindActivity;
import com.soco.ui.login.view.LoginView;

public class LoginActivity extends BaseDataBindActivity<LoginView> {

    @Override
    public Class getBaseViewClass() {
        return LoginView.class;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
