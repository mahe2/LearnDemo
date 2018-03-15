package com.learn.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.demo.R;
import com.learn.demo.fragment.AddedFragment;

/**
 * Created by mahe on 2018/3/8.
 */
@Route(path = "/fragment/")
public class FragActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragactivity);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_layout, new AddedFragment())
                .commit();
    }
}
