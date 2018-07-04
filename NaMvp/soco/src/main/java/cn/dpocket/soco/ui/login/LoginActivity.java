package cn.dpocket.soco.ui.login;

import android.os.Bundle;

import com.na.ui.mvp.databind.BaseRxDataBindActivity;

import cn.dpocket.soco.ui.login.view.LoginView;

public class LoginActivity extends BaseRxDataBindActivity<LoginView> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Class getBaseViewClass() {
        return LoginView.class;
    }
}
