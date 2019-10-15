package com.learn.demo.activity;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.demo.R;
import com.learn.demo.adapter.EntryAdapter;
import com.learn.demo.bean.EntryData;
import com.learn.demo.framework.activity.LeActivity;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;


public class EntryActivity extends LeActivity {
    private ArrayList<EntryData> mEntryDataSet = new ArrayList<EntryData>();
    private EntryAdapter mEntryAdapter;
    private ListView mEntryListView;

    @Override
    protected void onCreateActivityImpl() {
        setContentView(R.layout.activity_main);
        initView();
        initData();


    }


    private void initView(){
        mEntryListView = (ListView) findViewById(R.id.entry_listview);
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    private void initData(){
        EntryData rxJavaEntry = new EntryData("RxJava","/rxjava/");
        EntryData eventBusEntry = new EntryData("EventBus","/eventbus/");
        EntryData mvpEntry = new EntryData("Mvp模式","/mvp/");
        EntryData arouterEntry = new EntryData("ARouter页","/test_arouter/");
        EntryData lambdaEntry = new EntryData("Lambda表达式","/lambda/");
        EntryData ndkEntry = new EntryData("ndk调用","/ndk/");
        EntryData cyanEntry = new EntryData("畅言评论系统","/cyan/");
        EntryData javaDynamicProxyEntry = new EntryData("Java动态代理","/dynamicproxy/");
        EntryData materialDesignEntry = new EntryData("MaterialDesign","/materialDesign/");
        EntryData fragmentEntry = new EntryData("Fragment","/fragment/");
        EntryData normalTest = new EntryData("NormalTest","/normaltest/");
        EntryData serviceTest = new EntryData("ServiceTest","/servicetest/");
        EntryData log = new EntryData("Log","/log/");
        EntryData recyclerView1 = new EntryData("RecyclerView1","/recyclerview1/");
        EntryData lauchApp= new EntryData("包名启动app","/lauchapp/");
        EntryData md5= new EntryData("获取文件md5","/md5/");
        EntryData glide= new EntryData("glide图片加载","/glide/");

        mEntryDataSet.add(rxJavaEntry);
        mEntryDataSet.add(eventBusEntry);
        mEntryDataSet.add(mvpEntry);
        mEntryDataSet.add(arouterEntry);
        mEntryDataSet.add(lambdaEntry);
        mEntryDataSet.add(ndkEntry);
        mEntryDataSet.add(cyanEntry);
        mEntryDataSet.add(javaDynamicProxyEntry);
        mEntryDataSet.add(materialDesignEntry);
        mEntryDataSet.add(fragmentEntry);
        mEntryDataSet.add(normalTest);
        mEntryDataSet.add(serviceTest);
        mEntryDataSet.add(log);
        mEntryDataSet.add(recyclerView1);
        mEntryDataSet.add(lauchApp);
        mEntryDataSet.add(md5);
        mEntryDataSet.add(glide);

        mEntryAdapter = new EntryAdapter(this);
        mEntryListView.setAdapter(mEntryAdapter);
        mEntryAdapter.setDataSet(mEntryDataSet);
    }


}
