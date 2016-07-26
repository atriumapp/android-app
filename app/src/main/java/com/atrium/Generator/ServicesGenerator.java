package com.atrium.generator;

import android.util.Log;

import com.github.aurae.retrofit2.LoganSquareConverterFactory;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by romain on 05/07/2016.
 */
public class ServicesGenerator {
    public static final String URL = "http://isen.atrium-app.com/";

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

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(URL);


    public static <S> S createService(Class<S> serviceClass) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("Accept", "application/json")
                        .build();

                return chain.proceed(request);
            }
        });
        httpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        Retrofit retrofit = builder
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }
}
