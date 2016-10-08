package com.atriumapp.component;

import com.atriumapp.module.EventModule;
import com.atriumapp.scope.EventScope;
import com.atriumapp.service.EventService;

import dagger.Component;

/**
 * Created by romain on 06/08/2016.
 */
@EventScope
@Component(dependencies = NetComponent.class, modules = EventModule.class)
public interface EventComponent {
    EventService eventService();
}
