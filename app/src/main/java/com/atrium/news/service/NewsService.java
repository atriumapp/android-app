package com.atrium.news.service;

import com.atrium.news.pojo.News;
import com.atrium.pojo.utils.PaginationResponse;

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
    Call<PaginationResponse<News>> getAllNews();

    @GET("/news/{id}")
    Call<News> findNewsById(@Path("id") String id);

    /**
     *
     * @param options
     * Map d'option pour cette méthode si on veut récupérer les news d'un club : "club":"bda"
     * et pour les page : "page":"2"
     * @return Une liste de news avec une pagination
     */
    @GET("/news")
    Call<PaginationResponse<News>> findNewsByClub(@QueryMap Map<String, String> options);
}
