package com.learn.demo.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.demo.R;
import com.learn.demo.fragment.SongsFragment;

import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mahe on 2018/3/8.
 */
@Route(path = "/lauchapp/")
public class LaunchAppActivity extends FragmentActivity {
    @BindView(R.id.launch_app_btn)
    Button mBtnLaunchApp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_app_activity_layout);
        ButterKnife.bind(this);
        mBtnLaunchApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchApp2(LaunchAppActivity.this,"com.zhongyou.quanjing.a262");
            }
        });
    }

    public void launchApp2(Context context,String pkgName){
        PackageManager packageManager = context.getPackageManager();
        Intent intent=new Intent();
        intent =packageManager.getLaunchIntentForPackage(pkgName);
        if(intent==null){
            Toast.makeText(context, "未安装", Toast.LENGTH_LONG).show();
        }else{
            context.startActivity(intent);
            Toast.makeText(context, "启动", Toast.LENGTH_LONG).show();
        }
    }

    public static void launchApp(Context context, String packageName) {
        // 通过包名获取此APP详细信息，包括Activities、services、versioncode、name等等
        PackageInfo packageinfo = null;
        try {
            packageinfo =context.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageinfo == null) {
            Toast.makeText(context, "解析程序失败", Toast.LENGTH_SHORT).show();
            return;
        }

        // 创建一个类别为CATEGORY_LAUNCHER的该包名的Intent
        Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
//	    resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        resolveIntent.setPackage(packageinfo.packageName);
        // 通过getPackageManager()的queryIntentActivities方法遍历
        List<ResolveInfo> resolveinfoList = context.getPackageManager().queryIntentActivities(resolveIntent, 0);
        Iterator<ResolveInfo> iterator = resolveinfoList.iterator();
        if(!iterator.hasNext()){
            Toast.makeText(context, "解析程序失败", Toast.LENGTH_SHORT).show();
            return;
        }
        ResolveInfo resolveinfo = iterator.next();
        if (resolveinfo != null) {
            // packagename = 参数packname
            String pkeName = resolveinfo.activityInfo.packageName;
            // 这个就是我们要找的该APP的LAUNCHER的Activity[组织形式：packagename.mainActivityname]
            String className = resolveinfo.activityInfo.name;
            // LAUNCHER Intent
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            // 设置ComponentName参数1:packagename参数2:MainActivity路径
            ComponentName cn = new ComponentName(pkeName, className);
            intent.setComponent(cn);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
