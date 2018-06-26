package com.na.ui.mvp.databind;

import com.na.ui.mvp.model.IBaseModel;
import com.na.ui.mvp.view.IBaseView;

/**
 * Created by oneal23 on 2018/6/26.
 */
public interface IDataBinder<V extends IBaseView, M extends IBaseModel> {
    void viewBindModel(V viewDelegate, M data);
}
