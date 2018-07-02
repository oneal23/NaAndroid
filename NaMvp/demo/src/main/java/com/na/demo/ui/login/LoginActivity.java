package com.na.demo.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.na.demo.data.AppDataManager;
import com.na.demo.data.net.api.GameStarVoteResponse;
import com.na.demo.ui.login.view.LoginView;
import com.na.ui.mvp.databind.BaseRxDataBindActivity;
import com.na.ui.mvp.view.BaseView;
import com.na.utils.LogUtil;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class LoginActivity extends BaseRxDataBindActivity<LoginView> implements BaseView.EventListener{

    @Override
    public Class<LoginView> getBaseViewClass() {
        return LoginView.class;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        hideActionBar();
        super.onCreate(savedInstanceState);
    }

    @Override
    public void bindEventListener() {
        getBaseView().setEventListener(this);
    }

    @Override
    public void onEvent(int event) {
        AppDataManager.getInstance().getGameStarVote(new SingleObserver<GameStarVoteResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                addDisposable(d);
            }

            @Override
            public void onSuccess(GameStarVoteResponse gameStarVoteResponse) {
                LogUtil.d("onSuccess isSuc=",  "" + gameStarVoteResponse.isSuccess());
            }

            @Override
            public void onError(Throwable e) {
                LogUtil.d("onError=");
            }
        });
    }
}
