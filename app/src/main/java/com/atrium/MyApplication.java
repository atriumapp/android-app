package com.atrium;

import android.app.Application;

import com.atrium.club.component.ClubComponent;
import com.atrium.club.component.DaggerClubComponent;
import com.atrium.club.module.ClubModule;
import com.atrium.component.DaggerNetComponent;
import com.atrium.component.NetComponent;
import com.atrium.event.component.DaggerEventComponent;
import com.atrium.event.component.EventComponent;
import com.atrium.event.module.EventModule;
import com.atrium.module.ApplicationModule;
import com.atrium.module.NetModule;
import com.atrium.news.NewsModule;
import com.atrium.news.component.DaggerNewsComponent;
import com.atrium.news.component.NewsComponent;

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
