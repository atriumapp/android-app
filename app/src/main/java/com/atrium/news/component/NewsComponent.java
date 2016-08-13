package com.atrium.news.component;

import android.app.Activity;

import com.atrium.component.NetComponent;
import com.atrium.event.scope.EventScope;
import com.atrium.news.NewsModule;
import com.atrium.news.service.NewsService;

import dagger.Component;

/**
 * Created by romain on 06/08/2016.
 */
@EventScope
@Component(dependencies = NetComponent.class, modules = NewsModule.class)
public interface NewsComponent {

    NewsService newsService();
}
