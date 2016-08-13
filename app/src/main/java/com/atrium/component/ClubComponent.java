package com.atrium.component;

import com.atrium.module.ClubModule;
import com.atrium.scope.ClubScope;
import com.atrium.service.ClubService;

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
