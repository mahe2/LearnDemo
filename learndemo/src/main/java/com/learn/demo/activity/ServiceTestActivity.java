package com.learn.demo.activity;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.demo.R;
import com.learn.demo.framework.activity.LeActivity;

/**
 * Created by mahe on 2018/3/8.
 */
@Route(path = "/servicetest/")
public class ServiceTestActivity extends LeActivity {


    @Override
    protected void onCreateActivityImpl() {
        setContentView(R.layout.activity_servicetest_activity_layout);



    }
}
