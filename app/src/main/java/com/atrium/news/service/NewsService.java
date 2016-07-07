package com.atrium.news.service;

import com.atrium.news.pojo.News;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by A613792 on 07/07/2016.
 */
public interface NewsService {

    @GET("/news")
    Call<Response<News>> getAllNews();

    @GET("/news/{id}")
    Call<News> findNewsById(@Path("id") String id);

    @GET("/news")
    Call<Response<News>> findNewsByClub(@QueryMap Map<String, String> options);
}
