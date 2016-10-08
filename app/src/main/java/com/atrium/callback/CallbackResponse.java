package com.atrium.callback;

import android.util.Log;

import com.atrium.fabric.event.RequestFailEvent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by romain on 08/10/2016.
 */
public abstract class CallbackResponse<T> implements Callback<T> {

    private static final String TAG = "CalbackResponse";

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        RequestFailEvent.sendEvent(call, t);
        Log.e(TAG, "Resquest fail", t);
    }
}
