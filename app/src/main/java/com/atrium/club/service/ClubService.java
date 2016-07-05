package com.atrium.club.service;

import com.atrium.club.pojo.Club;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by romain on 05/07/2016.
 */
public interface ClubService {

    @GET("/clubs")
    Call<List<Club>> getClubs();

    @GET("/clubs/{id}")
    Call<Club> getClub(@Path("id") String id);

}
