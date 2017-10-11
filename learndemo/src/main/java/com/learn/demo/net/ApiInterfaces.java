package com.learn.demo.net;

import com.learn.demo.bean.Joke;
import com.learn.demo.bean.JokeDataWraper;
import com.learn.demo.bean.WeixinDataWraper;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mahe on 2017/9/29.
 */

public interface ApiInterfaces {
    static final String DATA_API_KEY = "fa15c60c109b0780c1a6c6bd816122d7";
    /**
     * 聚合笑话接口
     *@return List<>
     */
    @GET("joke/content/list.from?key="+DATA_API_KEY+"&sort=asc")
    Observable<JokeDataWraper> getJokeList(@Query("page") int page, @Query("pagesize") int pagesize, @Query("time") long timestamp);

    @GET("weixin/query?key="+DATA_API_KEY)
    Observable<WeixinDataWraper> getWeixinList(@Query("pno") int pno);
}
