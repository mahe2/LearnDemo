package com.learn.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.demo.R;
import com.learn.demo.adapter.EntryAdapter;
import com.learn.demo.adapter.JokeListAdapter;
import com.learn.demo.bean.EntryData;
import com.learn.demo.bean.JokeDataWraper;
import com.learn.demo.net.HttpMethods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by mahe on 2017/8/30.
 */

@Route(path = "/rxjava/")
public class RxJavaActivity extends AppCompatActivity {

    private ArrayList<EntryData> mEntryDataSet = new ArrayList<EntryData>();
    private EntryAdapter mEntryAdapter;
    private ListView mRxJavaEntryListView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_activity_layout);
        initView();
        initData();
    }

    private void initView(){
        mRxJavaEntryListView = (ListView) findViewById(R.id.theme_listview);
    }

    private void initData(){
        EntryData jokelistEntry = new EntryData("笑话列表","/jokelist/");
        EntryData weixinEntry = new EntryData("微信精选","/weixin/");


        mEntryDataSet.add(jokelistEntry);
        mEntryDataSet.add(weixinEntry);

        mEntryAdapter = new EntryAdapter(this);
        mRxJavaEntryListView.setAdapter(mEntryAdapter);
        mEntryAdapter.setDataSet(mEntryDataSet);
    }

    private void log(String msg){
        Log.i("rxjava",msg);
    }

}
