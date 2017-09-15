package com.learn.demo.framework.logger;

/**
 * Created by mahe on 2017/8/30.
 */

public class LeLogger {

    public static boolean debug = false;

    public static void openDebug(){
        debug = true;
    }

    public void logi(){

    }

    public void logd(){
        if(debug){

        }
    }
}
