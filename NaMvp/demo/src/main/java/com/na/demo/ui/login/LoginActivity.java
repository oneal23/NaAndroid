package com.na.demo.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.na.demo.data.AppDataManager;
import com.na.demo.data.net.api.GameStarVoteResponse;
import com.na.demo.ui.login.view.LoginView;
import com.na.ui.mvp.databind.BaseRxDataBindActivity;
import com.na.ui.mvp.view.BaseView;
import com.na.utils.LogUtils;

import io.reactivex.functions.Consumer;

public class LoginActivity extends BaseRxDataBindActivity<LoginView> implements BaseView.EventListener{

    @Override
    public Class<LoginView> getBaseViewClass() {
        return LoginView.class;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideActionBar();

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Context context = this;
//
//            getWindow().setStatusBarColor(getResources().getColor(R.color.bg_color1));   //这里动态修改颜色
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        }

    }

    @Override
    public void bindEventListener() {
        getBaseView().setEventListener(this);
    }

    @Override
    public void onEvent(int event) {
        getCompositeDisposable().add(AppDataManager.getInstance().getGameStarVote()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<GameStarVoteResponse>() {
                    @Override
                    public void accept(GameStarVoteResponse gameStarVoteResponse) throws Exception {
                        LogUtils.d("isSuc=",  "" + gameStarVoteResponse.isSuccess());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogUtils.d("error", throwable.getMessage());
                    }
                }));
//        getCompositeDisposable().add((Disposable) AppDataManager.getInstance().getGameStarVote().observeOn(getSchedulerProvider().ui()));

//        getCompositeDisposable().add(getDataManager()
//                .doFacebookLoginApiCall(new LoginRequest.FacebookLoginRequest("test3", "test4"))
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(new Consumer<LoginResponse>() {
//                    @Override
//                    public void accept(LoginResponse response) throws Exception {
//                        getDataManager().updateUserInfo(
//                                response.getAccessToken(),
//                                response.getUserId(),
//                                DataManager.LoggedInMode.LOGGED_IN_MODE_FB,
//                                response.getUserName(),
//                                response.getUserEmail(),
//                                response.getGoogleProfilePicUrl());
//
//                        if (!isViewAttached()) {
//                            return;
//                        }
//
//                        getMvpView().hideLoading();
//                        getMvpView().openMainActivity();
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//
//                        if (!isViewAttached()) {
//                            return;
//                        }
//
//                        getMvpView().hideLoading();
//
//                        // handle the login error here
//                        if (throwable instanceof ANError) {
//                            ANError anError = (ANError) throwable;
//                            handleApiError(anError);
//                        }
//                    }
//                }));
    }
}
