package com.na.ui.mvp.databind;

import com.na.ui.mvp.model.IBaseModel;
import com.na.ui.mvp.view.IBaseView;

/**
 * @actor:taotao
 * @DATE: 2018/5/23
 */
public interface IDataBinder<V extends IBaseView, M extends IBaseModel> {
    void viewBindModel(V viewDelegate, M data);
}
