package com.learn.demo.util;

import android.util.Log;

/**
 * Created by mahe on 2018/1/24.
 */

public class Logger {
    public static boolean DEBUG = true;
    private static final String TAG = "learn";

    public static void i(String msg){
        i(TAG,msg);
    }

    public static void i(String tag,String msg){
        if(DEBUG){
            Log.i(tag,msg);
        }
    }
}
