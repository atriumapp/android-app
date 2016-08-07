package com.atrium.club.component;

import android.app.Activity;

import com.atrium.club.module.ClubModule;
import com.atrium.club.scope.ClubScope;
import com.atrium.club.service.ClubService;
import com.atrium.component.NetComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by romain on 06/08/2016.
 */
@ClubScope
@Component(dependencies = NetComponent.class, modules = ClubModule.class)
public interface ClubComponent {
    //void inject(Activity activity);

    ClubService clubService();
}
