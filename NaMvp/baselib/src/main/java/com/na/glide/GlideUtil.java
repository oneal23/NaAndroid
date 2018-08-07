package com.na.glide;

import com.na.ui.widget.BaseImageView;

/**
 * Created by oneal23 on 2018/8/7.
 */
public class GlideUtil {

    public static void urlAndPlace(BaseImageView view, String url, int place) {
        GlideApp.with(view).load(url).placeholder(place).centerCrop().into(view);
    }

    public static void resId(BaseImageView view, int resId) {
        urlAndPlace(view, "", resId);
    }

    public static void url(BaseImageView view, String url) {
        urlAndPlace(view, url, -1);
    }

}
