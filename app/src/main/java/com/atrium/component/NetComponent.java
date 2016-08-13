package com.atrium.component;

import android.app.Activity;
import android.content.SharedPreferences;

import com.atrium.module.ApplicationModule;
import com.atrium.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by romain on 06/08/2016.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
    SharedPreferences sharedPreferences();
}
