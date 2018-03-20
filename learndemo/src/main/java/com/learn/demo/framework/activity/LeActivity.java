package com.learn.demo.framework.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by mahe on 2017/8/30.
 */

//@EActivity
public abstract class LeActivity extends AppCompatActivity {
    @Override
    final protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("s","Le Activity onCreate");
        onCreateActivityImpl();
    }

    protected  abstract void onCreateActivityImpl();

    protected void onClearActivity(){

    }

    @Override
    final protected void onDestroy() {
        onClearActivity();
        super.onDestroy();

    }

    //    @AfterViews
//    protected abstract void afterViewsInject();
}
