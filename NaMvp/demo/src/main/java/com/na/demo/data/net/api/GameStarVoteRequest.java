package com.na.demo.data.net.api;

import com.na.demo.data.net.Urls;
import com.na.demo.data.net.base.ApiRequest;

/**
 * @actor:taotao
 * @DATE: 2018/5/25
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
