package com.atrium.generator;

import android.util.Log;

import com.bluelinelabs.logansquare.LoganSquare;
import com.github.aurae.retrofit2.LoganSquareConverterFactory;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by romain on 05/07/2016.
 */
public class ServicesGenerator {
    public static final String URL = "http://isen.atrium-app.com/api/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    //permet de voir le contenu du body de la reponse
    private static Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response response = chain.proceed(chain.request());
            Log.w("Retrofit@Response", response.body().string());
            return response;
        }
    };

    //permet de logger les info de la requête
    private static HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create());


    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder
                .client(httpClient.build())
                .addConverterFactory(LoganSquareConverterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }
}
