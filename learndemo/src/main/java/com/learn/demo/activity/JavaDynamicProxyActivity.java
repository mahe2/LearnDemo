package com.learn.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.learn.demo.R;
import com.learn.demo.proxy.CakeMachine;
import com.learn.demo.proxy.DynamicProxy;
import com.learn.demo.proxy.FruitCakeMachine;

import java.lang.reflect.Proxy;

/**
 * Author: millioncoder@sina.com
 * Date: 2018/1/24
 * Dscreption:
 */

@Route(path = "/dynamicproxy/")
public class JavaDynamicProxyActivity extends AppCompatActivity {

    Button testDebugBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_dynamic_proxy_activity_layout);


        testDynamicProxy();


    }

    private void testDynamicProxy(){
        CakeMachine buyer = new FruitCakeMachine();

        CakeMachine dynamicProxy = (CakeMachine) Proxy.newProxyInstance(buyer.getClass().getClassLoader(),
                buyer.getClass().getInterfaces(),new DynamicProxy(buyer));

        dynamicProxy.makeCacke();
    }


}
