package com.na.demo.data.net;

import com.na.demo.data.net.api.GameStarVoteResponse;

import io.reactivex.Single;

/**
 * Created by oneal23 on 2018/6/26.
 */
public interface IApiHelper {
    Single<GameStarVoteResponse> getGameStarVote();
}
