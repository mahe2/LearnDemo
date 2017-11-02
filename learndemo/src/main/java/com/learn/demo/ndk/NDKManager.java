package com.learn.demo.ndk;

/**
 * Created by mahe on 2017/11/2.
 */

public class NDKManager {

    static {
        System.loadLibrary("palmread-lib");
    }

    public static native String GetStringFromC(String str);
}
