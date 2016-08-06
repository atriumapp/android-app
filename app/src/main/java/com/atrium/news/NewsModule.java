package com.atrium.news;

import com.atrium.news.service.NewsService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by romain on 06/08/2016.
 */
@Module
public class NewsModule {

    @Provides
    public NewsService provideNewsService(Retrofit retrofit){
        return retrofit.create(NewsService.class);
    }
}
