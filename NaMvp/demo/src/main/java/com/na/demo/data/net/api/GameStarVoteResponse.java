package com.na.demo.data.net.api;

import com.google.gson.annotations.SerializedName;
import com.na.demo.data.net.base.ApiResponse;

import java.util.List;

/**
 * Created by oneal23 on 2018/6/26.
 */
public class GameStarVoteResponse extends ApiResponse<List<GameStarVoteResponse.LastWinUser>> {

    @SerializedName("data")
    private List<LastWinUser> data;

    @Override
    public List<LastWinUser> getData() {
        return data;
    }

    public static class LastWinUser {
        @SerializedName("prizeName")
        private String prizeName;
        @SerializedName("nickName")
        private String nickName;

        public String getPrizeName() {
            return prizeName;
        }

        public void setPrizeName(String prizeName) {
            this.prizeName = prizeName;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }
    }
}
