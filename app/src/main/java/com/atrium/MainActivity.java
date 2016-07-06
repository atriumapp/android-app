package com.atrium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.atrium.Generator.ServicesGenerator;
import com.atrium.club.pojo.Club;
import com.atrium.club.service.ClubService;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClubService clubService = ServicesGenerator.createService(ClubService.class);

        Call<List<Club>> call = clubService.getClubs();

        call.enqueue(new Callback<List<Club>>() {
            @Override
            public void onResponse(Call<List<Club>> call, Response<List<Club>> response) {
                if(response.isSuccessful()){
                    List<Club> clubs = response.body();
                }else{
                    Log.d("Error Response", response.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Club>> call, Throwable t) {
                Log.e("Failure", call.toString(), t);
            }
        });

    }
}
