package com.na.demo.data;

import com.na.data.IDataManager;
import com.na.data.net.IBaseHttpRequest;
import com.na.data.net.IHttpHelper;
import com.na.data.net.fan.FastAndroidNetworkingHelper;
import com.na.demo.data.net.IApiHelper;
import com.na.demo.data.net.api.GameStarVoteRequest;
import com.na.demo.data.net.api.GameStarVoteResponse;

import io.reactivex.Single;

/**
 * Created by oneal23 on 2018/6/26.
 */
public class AppDataManager implements IDataManager, IApiHelper {

    private IHttpHelper httpHelper;

    private static class AppDataManagerHolder {
        public static AppDataManager INSTANCE = new AppDataManager();
    }

    public static AppDataManager getInstance(){
        return AppDataManagerHolder.INSTANCE;
    }

    protected Single<?> sendRequest(IBaseHttpRequest request) {
        return getHttpHelper().sendRequest(request);
    }

    private AppDataManager() {
        this.httpHelper = new FastAndroidNetworkingHelper();
    }

    @Override
    public Single<GameStarVoteResponse> getGameStarVote() {
        GameStarVoteRequest request = new GameStarVoteRequest();
        return (Single<GameStarVoteResponse>) sendRequest(request);
    }

    @Override
    public IHttpHelper getHttpHelper() {
        return httpHelper;
    }


}
