package com.atrium.component;

import com.atrium.module.EventModule;
import com.atrium.scope.EventScope;
import com.atrium.service.EventService;

import dagger.Component;

/**
 * Created by romain on 06/08/2016.
 */
@EventScope
@Component(dependencies = NetComponent.class, modules = EventModule.class)
public interface EventComponent {
    EventService eventService();
}
