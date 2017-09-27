package com.learn.demo.activity;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.learn.demo.R;
import com.learn.demo.framework.activity.LeActivity;
import com.mcxiaoke.packer.helper.PackerNg;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mahe on 2017/8/30.
 */

//@EActivity(R.layout.activity_splash_activity_layout)
public class SplashActivity extends LeActivity {
    @BindView(R.id.channel_textview) TextView mChannelTextView;
    @BindView(R.id.count_down_textview) TextView mCountDownTextView;
    private String channel;
    @Override
    protected void onCreateActivityImpl() {
        setContentView(R.layout.activity_splash_activity_layout);
        ARouter.init(getApplication());

        channel = PackerNg.getChannel(getApplication());
        Log.i("channel",channel+"");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                entryMain();
            }
        },3000);
        ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        mChannelTextView.setText(getString(R.string.channel_text,channel));
        mCountDownTextView.setText(getString(R.string.count_down_text));
    }


    private void entryMain(){
        Intent mainIntent = new Intent(this,EntryActivity.class);
        startActivity(mainIntent);
//        ARouter.getInstance().build("/test_arouter/").navigation();
    }
}
