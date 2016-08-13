package com.atrium.component;

import com.atrium.scope.EventScope;
import com.atrium.module.NewsModule;
import com.atrium.service.NewsService;

import dagger.Component;

/**
 * Created by romain on 06/08/2016.
 */
@EventScope
@Component(dependencies = NetComponent.class, modules = NewsModule.class)
public interface NewsComponent {

    NewsService newsService();
}
