package com.atriumapp.component;

import com.atriumapp.module.ClubModule;
import com.atriumapp.scope.ClubScope;
import com.atriumapp.service.ClubService;

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
