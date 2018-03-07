package com.learn.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.demo.R;


/**
 * Author: millioncoder@sina.com
 * Date: 2018/2/22
 * Dscreption: activity for material design
 */

@Route(path = "/materialDesign/")
public class MaterialDesignActivity extends AppCompatActivity {

    LinearLayout mMainLayout;
    Button mSnackbarBtn;
    Button mTextInputLayoutBtn;
    Button mTableLayoutActivityBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materialdesign_activity_layout);
        mMainLayout = (LinearLayout) findViewById(R.id.main_layout);
        mSnackbarBtn = (Button) findViewById(R.id.snackbar_btn);
        mTextInputLayoutBtn = (Button) findViewById(R.id.textinpulayout_btn);
        mTableLayoutActivityBtn = (Button) findViewById(R.id.tablelayout_activity_btn);
        mSnackbarBtn.setOnClickListener(onClickListener);
        mTextInputLayoutBtn.setOnClickListener(onClickListener);
        mTableLayoutActivityBtn.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.snackbar_btn:
                    showSnackBar();
                    break;
                case R.id.textinpulayout_btn:
                    Intent loginIntent = new Intent(MaterialDesignActivity.this,LoginActivity.class);
                    startActivity(loginIntent);
                    break;
                case R.id.tablelayout_activity_btn:
                    Intent tableLayoutIntent = new Intent(MaterialDesignActivity.this,TableLayoutActivity.class);
                    startActivity(tableLayoutIntent);
                    break;
            }
        }
    };

    private void showSnackBar(){
        Snackbar.make(mMainLayout,"test snack bar ",Snackbar.LENGTH_LONG).setAction("点击事件", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MaterialDesignActivity.this,"Toast",Toast.LENGTH_SHORT).show();
            }
        }).setDuration(Snackbar.LENGTH_LONG).show();
    }
}
