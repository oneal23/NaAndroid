package com.na.demo.ui.main;

import com.na.demo.ui.main.view.MainView;
import com.na.ui.mvp.databind.BaseRxDataBindActivity;

public class MainActivity extends BaseRxDataBindActivity<MainView> {
    @Override
    public Class getBaseViewClass() {
        return MainView.class;
    }
}
