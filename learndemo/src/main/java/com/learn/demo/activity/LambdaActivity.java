package com.learn.demo.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.demo.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mahe on 2017/8/30.
 */

@Route(path = "/lambda/")
public class LambdaActivity extends AppCompatActivity {

    Button testDebugBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lambda_activity_layout);
        initData();
    }



    private void initView(){

    }

    private void initData(){
//        Runnable runnable = () -> {
//            Log.i("lamb","hello word");
//        };

//        new Thread(runnable).start();

    }


    private void log(String msg){
        Log.i("lamb",msg);
    }
}
