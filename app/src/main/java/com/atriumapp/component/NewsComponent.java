package com.atriumapp.component;

import com.atriumapp.scope.EventScope;
import com.atriumapp.module.NewsModule;
import com.atriumapp.service.NewsService;

import dagger.Component;

/**
 * Created by romain on 06/08/2016.
 */
@EventScope
@Component(dependencies = NetComponent.class, modules = NewsModule.class)
public interface NewsComponent {

    NewsService newsService();
}
