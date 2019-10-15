package com.learn.demo.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.learn.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mahe on 2018/3/8.
 */
@Route(path = "/glide/")
public class GlideActivity extends Activity {
    @BindView(R.id.image_view)
    ImageView mImageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_activity_layout);
        ButterKnife.bind(this);
        String imageUrl = "http://image2.i.haierzhongyou.com/xcy2190812.png";

        Glide.with(this).load(imageUrl).into(mImageView);
    }
}
