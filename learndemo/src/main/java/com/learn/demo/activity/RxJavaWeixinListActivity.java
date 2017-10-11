package com.learn.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.demo.R;
import com.learn.demo.adapter.JokeListAdapter;
import com.learn.demo.adapter.WeixinAdapter;
import com.learn.demo.bean.Joke;
import com.learn.demo.bean.JokeDataWraper;
import com.learn.demo.bean.Weixin;
import com.learn.demo.bean.WeixinDataWraper;
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

@Route(path = "/weixin/")
public class RxJavaWeixinListActivity extends AppCompatActivity {

    private ArrayList<Weixin> mWeixinListAdapterDataSet = new ArrayList<Weixin>();
    private ListView mThemeListView;
    private WeixinAdapter mWeixinAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_weixinlist_activity_layout);
        initView();
        initData();
    }

    private void initView(){
        mThemeListView = (ListView) findViewById(R.id.theme_listview);
        mWeixinAdapter = new WeixinAdapter(this);
        mWeixinAdapter.setDataSet(mWeixinListAdapterDataSet);
        mThemeListView.setAdapter(mWeixinAdapter);
    }

    private void initData(){
        HttpMethods.getInstance().getWeixin(new Observer<WeixinDataWraper>() {
            @Override
            public void onSubscribe(Disposable d) {
                log("onSubscribe ");
            }

            @Override
            public void onNext(WeixinDataWraper weixinDataWraper) {
                mWeixinListAdapterDataSet.clear();
                mWeixinListAdapterDataSet.addAll(weixinDataWraper.result.list);
                mWeixinAdapter.notifyDataSetChanged();
                log("success : "+weixinDataWraper.result.list.size());
            }

            @Override
            public void onError(Throwable e) {
                log("error : "+e.getMessage());
            }

            @Override
            public void onComplete() {
                log("onComplete ");
            }
        },1);
    }

    private void log(String msg){
        Log.i("rxjava",msg);
    }

}
