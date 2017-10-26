package com.learn.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.SingleSubject;

/**
 * Created by mahe on 2017/8/30.
 */

@Route(path = "/rxjavademo/")
public class RxJavaDemoActivity extends AppCompatActivity {

    @BindView(R.id.text_content) TextView textContent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_demo_activity_layout);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView(){
        Single.just(add(10,14))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull Integer s) {
//                textContent.setText(String.valueOf(s));
            }

            @Override
            public void onError(@NonNull Throwable e) {
                textContent.setText(e.getMessage());
            }
        });

        Observable<String> myObservable = Observable.just("hello word");


        Observer<String> myObserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                textContent.setText(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Toast.makeText(RxJavaDemoActivity.this, "onComplete", Toast.LENGTH_SHORT).show();
            }
        };


        myObservable.subscribe(myObserver);
    }

    private int add(int a,int b){
        return a+b;
    }

    private void initData(){

    }

    private void log(String msg){
        Log.i("rxjava",msg);
    }



}
