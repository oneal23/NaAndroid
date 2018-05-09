package com.na.mvp.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.na.mvp.R;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {
    @Inject
    MainItem mainItem;
    @Inject
    MainItem1 mainItem1;
    @Inject
    MainItem1 mainItem2;

    @Named("two")
    @Inject
    MainItem mainItem3;

    @Inject
    AppItem appItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule(getApplication())).build();
//        DaggerMainActivityComponent.builder().appComponent(appComponent).build().inject(this);
    }
}
