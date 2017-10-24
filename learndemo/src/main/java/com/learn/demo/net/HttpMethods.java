package com.learn.demo.net;

import android.content.Context;
import android.util.Log;

import com.learn.demo.bean.Joke;
import com.learn.demo.bean.JokeDataWraper;
import com.learn.demo.bean.WeixinDataWraper;
import com.learn.demo.framework.LeApplication;
import com.learn.demo.util.CheckNetWorkStatus;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author: millioncoder@sina.com
 * Date: 2017/10/12
 * Dscreption:
 */

public class HttpMethods {

    private static final String BASE_URL = "http://japi.juhe.cn/";
    private static final int TIME_OUT=10*1000;
    private Retrofit retrofit;
    private ApiInterfaces apiService;

    private static final int TIMEOUT_CONNECT = 5; //5秒
    private static final int TIMEOUT_DISCONNECT = 60 * 60 * 24 * 7; //7天

    static Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();
            Response response = chain.proceed(request);

            if (CheckNetWorkStatus.isNetworkAvailable(LeApplication.application)) {
                int maxAge = 60*60*24*2;//缓存失效时间，单位为秒
                return response.newBuilder()
                        .removeHeader("Pragma")//清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            }
            return response;
        }
    };

    public Cache provideCache() {
        return new Cache(LeApplication.application.getCacheDir(), 1024*1024);
    }

    private HttpMethods() {
        /**
         * 构造函数私有化
         * 并在构造函数中进行retrofit的初始化
         */
        OkHttpClient client=new OkHttpClient();
        client.newBuilder().connectTimeout(10, TimeUnit.SECONDS)//设置连接超时
                .readTimeout(10, TimeUnit.SECONDS)//读取超时
                .writeTimeout(10, TimeUnit.SECONDS)//写入超时
                .addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)//添加缓存拦截器
                .cache(provideCache())
                .build();
        /**
         * 由于retrofit底层的实现是通过okhttp实现的，所以可以通过okHttp来设置一些连接参数
         * 如超时等
         */
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService=retrofit.create(ApiInterfaces.class);
    }


    private static class sinalInstance {
        public static final HttpMethods instance = new HttpMethods();
    }

    public  static HttpMethods getInstance(){
        return sinalInstance.instance;
    }

    public void getJoke(Observer<JokeDataWraper> observer, int page, int pageSize, long timestamp){
        Log.i("rxjava","timestamp : "+timestamp);
        apiService.getJokeList(page,pageSize,timestamp)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void getWeixin(Observer<WeixinDataWraper> observer,int pno){
        apiService.getWeixinList(pno)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }



}

