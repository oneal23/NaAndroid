package com.na.demo.data.net;

import com.na.demo.data.net.api.GameStarVoteResponse;

import io.reactivex.Single;

/**
 * @actor:taotao
 * @DATE: 2018/5/25
 */
public interface IApiHelper {
    Single<GameStarVoteResponse> getGameStarVote();
}
