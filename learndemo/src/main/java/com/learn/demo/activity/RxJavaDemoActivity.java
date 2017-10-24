package com.learn.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.demo.R;
import com.learn.demo.adapter.JokeListAdapter;
import com.learn.demo.bean.Joke;
import com.learn.demo.bean.JokeDataWraper;
import com.learn.demo.net.HttpMethods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by mahe on 2017/8/30.
 */

@Route(path = "/rxjavademo/")
public class RxJavaDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_demo_activity_layout);
        initView();
        initData();
    }

    private void initView(){

    }

    private void initData(){

    }

    private void log(String msg){
        Log.i("rxjava",msg);
    }



}
