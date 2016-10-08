package com.atriumapp.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by romain on 06/08/2016.
 */
@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext(){
        return context;
    }
}
