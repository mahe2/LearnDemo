package com.learn.demo.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
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
    private static final int MSG_COUNT_DOWN = 1;
    @BindView(R.id.channel_textview) TextView mChannelTextView;
    @BindView(R.id.count_down_textview) TextView mCountDownTextView;
    private String channel = "debug";
    private int countDown = 5;

    private Handler splashHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MSG_COUNT_DOWN:
                    if(countDown == 1){
                        entryMain();
                    }else{
                        countDown -- ;
                        mCountDownTextView.setText(getString(R.string.count_down_text,String.valueOf(countDown)));
                        splashHandler.sendEmptyMessageDelayed(MSG_COUNT_DOWN,1000);
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreateActivityImpl() {
        setContentView(R.layout.activity_splash_activity_layout);
        ARouter.init(getApplication());
        channel = TextUtils.isEmpty(PackerNg.getChannel(getApplication())) ? "debug" : PackerNg.getChannel(getApplication());
        ButterKnife.bind(this);
        initView();
        splashHandler.sendEmptyMessageDelayed(MSG_COUNT_DOWN,1000);
    }

    private void initView(){
        mChannelTextView.setText(getString(R.string.channel_text,channel));
        mCountDownTextView.setText(getString(R.string.count_down_text,String.valueOf(countDown)));
    }


    private void entryMain(){
        Intent mainIntent = new Intent(this,EntryActivity.class);
        startActivity(mainIntent);
        finish();
//        ARouter.getInstance().build("/test_arouter/").navigation();
    }
}
