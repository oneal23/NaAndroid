package com.na.ui.mvp.presenter;

import com.na.ui.mvp.view.IBaseView;

/**
 * @actor:taotao
 * @DATE: 2018/5/23
 */
public interface IBasePresenter<V extends IBaseView> {
    Class<V> getBaseViewClass();
    V getBaseView();
}
