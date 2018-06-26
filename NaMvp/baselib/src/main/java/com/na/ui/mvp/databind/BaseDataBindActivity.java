package com.na.ui.mvp.databind;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.na.ui.mvp.model.IBaseModel;
import com.na.ui.mvp.presenter.BaseActivityPresenter;
import com.na.ui.mvp.view.IBaseView;

/**
 * @actor:taotao
 * @DATE: 2018/5/23
 */
public abstract class BaseDataBindActivity<V extends IBaseView> extends BaseActivityPresenter<V> {
    protected IDataBinder mDataBinder;

    protected IDataBinder createDataBinder(){
        return null;
    }

    protected IDataBinder getDataBinder() {
        return mDataBinder;
    }

    protected void setDataBinder(IDataBinder binder) {
        mDataBinder = binder;
    }

    public <M extends IBaseModel> void onUpdateData(M data){
        if(getDataBinder() != null){
            getDataBinder().viewBindModel(getBaseView(), data);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDataBinder(createDataBinder());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(getDataBinder() != null){
            setDataBinder(null);
        }
    }
}
