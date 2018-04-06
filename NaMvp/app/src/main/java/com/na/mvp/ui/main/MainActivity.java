package com.na.mvp.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.na.mvp.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    MainItem mainItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainActivityComponent.create().inject(this);
    }
}
