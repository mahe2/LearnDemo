package com.learn.demo.activity;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.learn.demo.R;
import com.learn.demo.framework.activity.LeActivity;
import com.mcxiaoke.packer.helper.PackerNg;

/**
 * Created by mahe on 2017/8/30.
 */

//@EActivity(R.layout.activity_splash_activity_layout)
public class SplashActivity extends LeActivity {

    @Override
    protected void onCreateActivityImpl() {
        setContentView(R.layout.activity_splash_activity_layout);
        ARouter.init(getApplication());
        String channel = PackerNg.getChannel(getApplication());
        Log.i("channel",channel+"");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                entryMain();
            }
        },2000);
    }


    private void entryMain(){
        Intent mainIntent = new Intent(this,EntryActivity.class);
        startActivity(mainIntent);
//        ARouter.getInstance().build("/test_arouter/").navigation();
    }
}
