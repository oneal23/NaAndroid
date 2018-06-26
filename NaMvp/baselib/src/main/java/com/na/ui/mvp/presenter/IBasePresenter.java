package com.na.ui.mvp.presenter;

import com.na.ui.mvp.view.IBaseView;

/**
 * Created by oneal23 on 2018/6/26.
 */
public interface IBasePresenter<V extends IBaseView> {
    Class<V> getBaseViewClass();
    V getBaseView();
}
