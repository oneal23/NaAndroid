package com.na.demo.data.net.api;

import com.na.demo.data.net.Urls;
import com.na.demo.data.net.base.ApiRequest;

/**
 * Created by oneal23 on 2018/6/26.
 */
public class GameStarVoteRequest extends ApiRequest<GameStarVoteResponse> {
    @Override
    public String getUrl() {
        return Urls.GAME_STARVOTE;
    }

    @Override
    public int getMethod() {
        return GET;
    }

    @Override
    public Class<GameStarVoteResponse> getResponseClass() {
        return GameStarVoteResponse.class;
    }


}
