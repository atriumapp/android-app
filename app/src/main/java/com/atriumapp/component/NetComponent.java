package com.atriumapp.component;

import android.content.SharedPreferences;

import com.atriumapp.module.ApplicationModule;
import com.atriumapp.module.NetModule;

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
