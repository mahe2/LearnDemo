package com.learn.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.demo.R;
import com.learn.demo.adapter.JokeListAdapter;
import com.learn.demo.bean.Joke;
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

@Route(path = "/jokelist/")
public class RxJavaJokeListActivity extends AppCompatActivity {

    private ArrayList<Joke> mJokeListAdapterDataSet = new ArrayList<Joke>();
    private ListView mThemeListView;
    private JokeListAdapter mJokeListAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_jokelist_activity_layout);
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
        HttpMethods.getInstance().getJoke(new Observer<JokeDataWraper>() {
            @Override
            public void onSubscribe(Disposable d) {
                log("onSubscribe ");
            }

            @Override
            public void onNext(JokeDataWraper jokeDataWraper) {
                mJokeListAdapterDataSet.clear();
                mJokeListAdapterDataSet.addAll(jokeDataWraper.result.data);
                mJokeListAdapter.notifyDataSetChanged();
                log("success : "+jokeDataWraper.result.data.size());
            }

            @Override
            public void onError(Throwable e) {
                log("error : "+e.getMessage());
            }

            @Override
            public void onComplete() {
                log("onComplete ");
            }
        },1,10,getTimeStamp());
    }

    private void log(String msg){
        Log.i("rxjava",msg);
    }


    private long getTimeStamp(){
        try {
            String time = "2014/10/01 14:50:11";
            Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(time);
            long unixTimestamp = date.getTime()/1000;
            return unixTimestamp;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0L;
    }
}
