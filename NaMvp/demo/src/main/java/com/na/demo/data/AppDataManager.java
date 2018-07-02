package com.na.demo.data;

import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.na.data.IDataManager;
import com.na.data.net.IBaseHttpRequest;
import com.na.data.net.IHttpHelper;
import com.na.data.net.fan.FastAndroidNetworkingHelper;
import com.na.demo.BuildConfig;
import com.na.demo.data.net.HeaderMananger;
import com.na.demo.data.net.IApiHelper;
import com.na.demo.data.net.api.GameStarVoteRequest;
import com.na.demo.data.net.api.GameStarVoteResponse;
import com.na.utils.rx.AppSchedulerProvider;
import com.na.utils.rx.SchedulerProvider;

import io.reactivex.Single;
import io.reactivex.SingleObserver;

/**
 * Created by oneal23 on 2018/6/26.
 */
public class AppDataManager implements IDataManager, IApiHelper {

    private IHttpHelper httpHelper;
    private SchedulerProvider schedulerProvider;

    public void init(Context context) {
        AndroidNetworking.initialize(context);
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }
    }

    public SchedulerProvider getSchedulerProvider() {
        if (schedulerProvider == null){
            schedulerProvider = new AppSchedulerProvider();
        }
        return schedulerProvider;
    }

    private static class AppDataManagerHolder {
        public static AppDataManager INSTANCE = new AppDataManager();
    }

    public static AppDataManager getInstance(){
        return AppDataManagerHolder.INSTANCE;
    }

    protected Single<?> sendRequest(IBaseHttpRequest request) {
        return getHttpHelper().sendRequest(request)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui());
    }

    private AppDataManager() {
        this.httpHelper = new FastAndroidNetworkingHelper();
    }

    @Override
    public void getGameStarVote(SingleObserver<GameStarVoteResponse> singleObserver) {
        GameStarVoteRequest request = new GameStarVoteRequest();
        request.setHeaders(HeaderMananger.getInstance().getDefaultHeader());
        Single<GameStarVoteResponse> single = (Single<GameStarVoteResponse>) sendRequest(request);
        single.subscribe(singleObserver);
    }

    @Override
    public IHttpHelper getHttpHelper() {
        return httpHelper;
    }


}
