package com.learn.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.demo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mahe on 2017/8/30.
 */

@Route(path = "/eventbus/")
public class EventBusActivity extends AppCompatActivity {
    @BindView(R.id.event_bus_textview) TextView mEventBusTextView;
    @BindView(R.id.event_bus_post) Button mEventBusPostBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus_activity_layout);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.event_bus_post)
    public void postEventBusMsg(View view){
        EventBus.getDefault().post("test event bus");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void helloEventBus(String msg){
        mEventBusTextView.setText(msg);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
