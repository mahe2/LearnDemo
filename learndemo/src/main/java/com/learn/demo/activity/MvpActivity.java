package com.learn.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.demo.R;

/**
 * Created by mahe on 2017/8/30.
 */

@Route(path = "/mvp/")
public class MvpActivity extends AppCompatActivity {

    Button testDebugBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_activity_layout);

    }
}
