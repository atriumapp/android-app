package com.atrium.club.module;

import com.atrium.club.service.ClubService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by romain on 06/08/2016.
 */
@Module
public class ClubModule {

    @Provides
    public ClubService provideClubService(Retrofit retrofit){
        return retrofit.create(ClubService.class);
    }
}
