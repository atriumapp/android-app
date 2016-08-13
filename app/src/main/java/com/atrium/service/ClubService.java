package com.atrium.service;

import com.atrium.model.ClubDetail;
import com.atrium.model.ListClubs;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by romain on 05/07/2016.
 */
public interface ClubService {

    @GET("api/clubs")
    Call<ListClubs> getClubs();

    @GET("api/clubs/{id}")
    Call<ClubDetail> getClub(@Path("id") String id);

}
