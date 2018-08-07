package com.na.ui.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.na.glide.GlideApp;


/**
 * Created by oneal23 on 2018/6/26.
 */
public class BaseImageView extends AppCompatImageView {
    public BaseImageView(Context context) {
        super(context);
    }

    public BaseImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void urlAndPlace(String url, int place) {
        GlideApp.with(this).load(url).placeholder(place).centerCrop().into(this);
    }

    public void resId(int resId) {
        urlAndPlace("", resId);
    }

    public void url(String url) {
        urlAndPlace(url, -1);
    }
}
