package com.na.ui.mvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * @actor:taotao
 * @DATE: 2018/5/23
 */
public abstract class ButterKnifeView extends BaseView {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        bind(view);
        return view;
    }

    private void bind(View view) {
        ButterKnife.bind(this, view);
    }
}
