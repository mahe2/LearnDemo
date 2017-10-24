package com.learn.demo.framework;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by mahe on 2017/8/30.
 */

public class LeApplication extends Application {

    public static Application application;
    public void onCreate() {
        super.onCreate();
        application = this;
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
