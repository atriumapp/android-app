package com.atriumapp;

import android.app.Application;

import com.atriumapp.component.ClubComponent;
import com.atriumapp.component.DaggerClubComponent;
import com.atriumapp.component.DaggerEventComponent;
import com.atriumapp.component.DaggerNetComponent;
import com.atriumapp.component.DaggerNewsComponent;
import com.atriumapp.component.EventComponent;
import com.atriumapp.component.NetComponent;
import com.atriumapp.component.NewsComponent;
import com.atriumapp.module.ApplicationModule;
import com.atriumapp.module.ClubModule;
import com.atriumapp.module.EventModule;
import com.atriumapp.module.NetModule;
import com.atriumapp.module.NewsModule;
import com.crashlytics.android.Crashlytics;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import io.fabric.sdk.android.Fabric;

/**
 * Created by romain on 06/08/2016.
 */
public class MyApplication extends Application {

    private NetComponent netComponent;
    private ClubComponent clubComponent;
    private EventComponent eventComponent;
    private NewsComponent newsComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        CustomActivityOnCrash.install(this);
        CustomActivityOnCrash.setShowErrorDetails(false);
        CustomActivityOnCrash.setDefaultErrorActivityDrawable(R.drawable.atrium_logo_hololight);

        netComponent = DaggerNetComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netModule(new NetModule("http://isen.atrium-app.com/"))
                .build();

        clubComponent = DaggerClubComponent.builder()
                .netComponent(netComponent)
                .clubModule(new ClubModule())
                .build();

        eventComponent = DaggerEventComponent.builder()
                .netComponent(netComponent)
                .eventModule(new EventModule())
                .build();

        newsComponent = DaggerNewsComponent.builder()
                .netComponent(netComponent)
                .newsModule(new NewsModule())
                .build();

    }

    public ClubComponent getClubComponent(){
        return clubComponent;
    }

    public EventComponent getEventComponent(){
        return eventComponent;
    }

    public NewsComponent getNewsComponent(){
        return newsComponent;
    }
}
