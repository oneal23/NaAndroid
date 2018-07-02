package com.na.demo.data.net;

import com.na.demo.data.net.api.GameStarVoteResponse;

import io.reactivex.SingleObserver;

/**
 * Created by oneal23 on 2018/6/26.
 */
public interface IApiHelper {
    void getGameStarVote(SingleObserver<GameStarVoteResponse> singleObserver);
}
