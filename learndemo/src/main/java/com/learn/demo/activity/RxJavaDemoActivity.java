package com.learn.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jakewharton.rxbinding.view.RxView;
import com.learn.demo.R;
import com.learn.demo.adapter.JokeListAdapter;
import com.learn.demo.bean.Joke;
import com.learn.demo.bean.JokeDataWraper;
import com.learn.demo.net.HttpMethods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by mahe on 2017/8/30.
 */

@Route(path = "/rxjavademo/")
public class RxJavaDemoActivity extends AppCompatActivity {

    @BindView(R.id.text_content) TextView textContent;
    @BindView(R.id.click) Button clickBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_demo_activity_layout);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView(){
        RxView.clicks(clickBtn).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                Toast.makeText(RxJavaDemoActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void initData(){
//        createObserableTest();
//        justObservableTest();
        fromObservableTest();
    }


    private void createObserableTest(){
        Observer<String> createObservableObserver = new Observer<String>() {
            Disposable disposable = null;
            @Override
            public void onSubscribe(Disposable d) {
                log("onSubscribe: "+d.isDisposed());
                disposable = d;
            }

            @Override
            public void onNext(String s) {
                if("?".equals(s)){
                    disposable.dispose();
                }
                log("disposable : "+disposable.isDisposed());
                log("onNext: "+s);
            }

            @Override
            public void onError(Throwable e) {
                log("onError: "+e.getMessage());
            }

            @Override
            public void onComplete() {
                log("onComplete");
            }
        };

        Observable<String> createObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter e) throws Exception {
                e.onNext("股票");
                e.onNext("还能不能涨了");
                e.onNext("?");
                e.onNext("完毕");
            }
        });

        createObservable.subscribe(createObservableObserver);
    }

    private void justObservableTest(){
        Observable justObservable = Observable.just(1,2,3);
        Observer<Integer> justObservableObserver = new Observer<Integer>() {
            Disposable disposable;
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(Integer integer) {
                if(2==integer){
                    disposable.dispose();
                }
                log("disposable : "+disposable.isDisposed());
                log("onNext: "+integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        justObservable.subscribe(justObservableObserver);
    }

    private void fromObservableTest(){
        String[] names = {"张三","李四","王二"};
        Observable<String> fromObservable = Observable.fromArray(names);

        Observer<String> fromObservableObserver = new Observer<String>() {
            Disposable disposable;
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(String s) {
                if("李四".equals(s)){
                    disposable.dispose();
                }
                log("disposable : "+disposable.isDisposed());
                log("onNext: "+s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        fromObservable.subscribe(fromObservableObserver);
    }



    private void log(String msg){
        Log.i("rxjava",msg);
    }



}
