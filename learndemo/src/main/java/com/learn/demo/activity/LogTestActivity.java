package com.learn.demo.activity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.demo.R;
import com.learn.demo.framework.activity.LeActivity;

/**
 * Created by mahe on 2018/3/8.
 */
@Route(path = "/log/")
public class LogTestActivity extends LeActivity {


    @Override
    protected void onCreateActivityImpl() {
        setContentView(R.layout.activity_log_activity_layout);



    }
}
