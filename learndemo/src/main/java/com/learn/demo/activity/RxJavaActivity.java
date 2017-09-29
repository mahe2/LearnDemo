package com.learn.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.demo.R;
import com.learn.demo.adapter.JokeListAdapter;
import com.learn.demo.bean.Joke;

import java.util.ArrayList;

/**
 * Created by mahe on 2017/8/30.
 */

@Route(path = "/rxjava/")
public class RxJavaActivity extends AppCompatActivity {

    private ArrayList<Joke> mJokeListAdapterDataSet = new ArrayList<Joke>();
    private ListView mThemeListView;
    private JokeListAdapter mJokeListAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_activity_layout);
        initView();
        initData();
    }

    private void initView(){
        mThemeListView = (ListView) findViewById(R.id.theme_listview);
        mJokeListAdapter = new JokeListAdapter(this);
        mJokeListAdapter.setDataSet(mJokeListAdapterDataSet);
        mThemeListView.setAdapter(mJokeListAdapter);
    }

    private void initData(){

    }
}
