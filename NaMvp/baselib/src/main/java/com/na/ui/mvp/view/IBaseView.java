package com.na.ui.mvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @actor:taotao
 * @DATE: 2018/5/23
 */
public interface IBaseView {

    View getView();

    View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    void onViewCreated();

    void onDestroy();

    void onResume();

    void onPause();

    void onStart();

    void onStop();
}
