package com.soco.ui.main;

import com.na.ui.mvp.databind.BaseDataBindActivity;
import com.soco.ui.main.view.MainView;

public class MainActivity extends BaseDataBindActivity<MainView> {

    @Override
    public Class getBaseViewClass() {
        return MainView.class;
    }
}
