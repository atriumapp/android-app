package com.atrium.event.component;

import android.app.Activity;

import com.atrium.component.NetComponent;
import com.atrium.event.module.EventModule;
import com.atrium.event.scope.EventScope;
import com.atrium.event.service.EventService;

import dagger.Component;

/**
 * Created by romain on 06/08/2016.
 */
@EventScope
@Component(dependencies = NetComponent.class, modules = EventModule.class)
public interface EventComponent {
    EventService eventService();
}
