package com.atrium.event.service;

import com.atrium.event.pojo.Event;
import com.atrium.pojo.utils.PaginationResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by A613792 on 07/07/2016.
 */
public interface EventService {

    @GET("/api/events")
    Call<PaginationResponse<Event>> getAllEvents(@QueryMap Map<String, String> options);

    @GET("/api/events/{id}")
    Call<Event> findEventById(@Path("id") String id);

    /**
     *
     * @param options
     * Map d'option pour cette méthode si on veut récupérer les envent d'un club : "club":"bda"
     * et pour les page : "page":"2"
     * @return Une liste d'event avec une pagination
     */
    @GET("/api/events")
    Call<PaginationResponse<Event>> findEventByClub(@QueryMap Map<String, String> options);

}
