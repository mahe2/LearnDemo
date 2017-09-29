package com.learn.demo.net;

import com.learn.demo.bean.Joke;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by mahe on 2017/9/29.
 */

public interface ApiInterfaces {
    /**
     * 聚合笑话接口
     *@return List<>
     */
    @GET("joke/content/list.from?key=fa15c60c109b0780c1a6c6bd816122d7&page={page}&pagesize={pagesize}&sort=asc&time={timestamp}")
    Observable<List<Joke>> getJokeList(@Path("page") int page,@Path("pagesize") int pagesize,@Path("timestamp") long timestamp);
}
