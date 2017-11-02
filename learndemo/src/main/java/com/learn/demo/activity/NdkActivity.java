package com.learn.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.demo.R;
import com.learn.demo.ndk.NDKManager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mahe on 2017/8/30.
 */

@Route(path = "/ndk/")
public class NdkActivity extends AppCompatActivity {

    @BindView(R.id.content) TextView content;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndk_activity_layout);
        ButterKnife.bind(this);
        initView();
    }



    private void initView(){
        String str = NDKManager.GetStringFromC("test ndk method call : ");
        content.setText(str);
    }

    private void initData(){

    }


    private void log(String msg){
        Log.i("lamb",msg);
    }
}
