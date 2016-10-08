package com.atriumapp.fabric.event;

import android.util.Log;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by romain on 08/10/2016.
 */
public class RequestFailEvent {

    private static String TAG = "Response fail";

    public static void sendEvent(Call call, Throwable t){
        Log.e(TAG, "Response fail", t);
        Answers.getInstance().logCustom(new CustomEvent("Resquest Fail")
            .putCustomAttribute("URL", call.request().url().toString())
            .putCustomAttribute("Error message", t.getMessage()));
    }

    public static void sendEvent(Call call, Response response){
        Log.e(TAG, "Response fail", new Throwable(response.raw().message()));
        Answers.getInstance().logCustom(new CustomEvent("Resquest Fail")
                .putCustomAttribute("URL", call.request().url().toString())
                .putCustomAttribute("Error message", response.raw().message()));
    }
}
