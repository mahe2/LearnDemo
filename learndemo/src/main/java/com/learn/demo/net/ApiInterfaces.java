package com.learn.demo.net;

import com.learn.demo.bean.Joke;
import com.learn.demo.bean.JokeDataWraper;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mahe on 2017/9/29.
 */

public interface ApiInterfaces {
    /**
     * 聚合笑话接口
     *@return List<>
     */
    @GET("joke/content/list.from?key=fa15c60c109b0780c1a6c6bd816122d7&sort=asc")
    Observable<JokeDataWraper> getJokeList(@Query("page") int page, @Query("pagesize") int pagesize, @Query("time") long timestamp);
}
