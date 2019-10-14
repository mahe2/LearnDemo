package com.learn.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.demo.R;
import com.learn.demo.fragment.AddedFragment;
import com.learn.demo.fragment.SecondFragment;

/**
 * Created by mahe on 2018/3/8.
 */
@Route(path = "/fragment/")
public class FragActivity extends FragmentActivity {
    FragmentTransaction frgmentTransaction;
    TextView mOptionBtn;
    TextView mOptionBtn2;
    Fragment fragment1 = new AddedFragment();
    Fragment fragment2 = new SecondFragment();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragactivity);
        frgmentTransaction = getSupportFragmentManager().beginTransaction();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_layout, fragment1)
                .commit();
        mOptionBtn = (TextView) findViewById(R.id.option_btn);
        mOptionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchContentFragment(fragment2,fragment1);
            }
        });
        mOptionBtn2 = (TextView) findViewById(R.id.option_btn2);
        mOptionBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchContentFragment(fragment1,fragment2);

            }
        });
    }
    public void switchContentFragment(Fragment from, Fragment to) {
        if (!to.isAdded()) {    // 先判断是否被add过
            getSupportFragmentManager().beginTransaction().hide(from).add(R.id.content_layout, to).commit();
        } else {
            getSupportFragmentManager().beginTransaction().hide(from).show(to).commit();
        }
    }
}
