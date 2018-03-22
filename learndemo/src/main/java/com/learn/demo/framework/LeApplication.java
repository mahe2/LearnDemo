package com.learn.demo.framework;

import android.app.Application;
import android.support.annotation.NonNull;
import android.util.Log;

import com.learn.demo.BuildConfig;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

/**
 * Author: millioncoder@sina.com
 * Date: 2018/3/20
 * Dscreption: 
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

        if (BuildConfig.DEBUG) {
            Timber.plant(new LeLogTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }
    }


    private static class LeLogTree extends Timber.DebugTree{
        @Override
        protected void log(int priority, String tag, String message, Throwable t) {
            if(BuildConfig.DEBUG || Log.isLoggable("tag",Log.DEBUG)){
                super.log(priority, tag, message, t);
            }

        }
    }

    /** A tree which logs important information for crash reporting. */
    private static class CrashReportingTree extends Timber.Tree {
        @Override
        protected void log(int priority, String tag, @NonNull String message, Throwable t) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return;
            }

            FakeCrashLibrary.log(priority, tag, message);

            if (t != null) {
                if (priority == Log.ERROR) {
                    FakeCrashLibrary.logError(t);
                } else if (priority == Log.WARN) {
                    FakeCrashLibrary.logWarning(t);
                }
            }
        }
    }
}
