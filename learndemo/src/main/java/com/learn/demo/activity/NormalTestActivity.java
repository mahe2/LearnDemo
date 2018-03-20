package com.learn.demo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.demo.R;
import com.learn.demo.fragment.AddedFragment;
import com.learn.demo.framework.activity.LeActivity;

/**
 * Created by mahe on 2018/3/8.
 */
@Route(path = "/normaltest/")
public class NormalTestActivity extends LeActivity {

    private HandlerThread mHandlerThread;
    private Handler mHandler;

    @Override
    protected void onCreateActivityImpl() {
        setContentView(R.layout.activity_normaltest_activity_layout);

        mHandlerThread = new HandlerThread("handler thread ");
        mHandlerThread.start();

        mHandler = new Handler(mHandlerThread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                Log.i("tag","这个线程是: "+Thread.currentThread().getName());
            }
        };


        mHandler.sendEmptyMessage(1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(2);
            }
        }).start();


    }
}
