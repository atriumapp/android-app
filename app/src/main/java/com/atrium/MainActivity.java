package com.atrium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.atrium.event.pojo.Event;
import com.atrium.event.service.EventService;
import com.atrium.generator.ServicesGenerator;
import com.atrium.club.pojo.Club;
import com.atrium.club.service.ClubService;
import com.atrium.pojo.utils.PaginationResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventService eventService = ServicesGenerator.createService(EventService.class);

        Map<String, String> options = new HashMap<String, String>();
        options.put("club", "bda");

        Call<PaginationResponse<Event>> request = eventService.findEventByClub(options);

        request.enqueue(new Callback<PaginationResponse<Event>>() {
            @Override
            public void onResponse(Call<PaginationResponse<Event>> call, Response<PaginationResponse<Event>> response) {
                List<Event> test = response.body().getResults();
            }

            @Override
            public void onFailure(Call<PaginationResponse<Event>> call, Throwable t) {
                Log.e("Error request", "Error dureing request", t);
            }
        });

    }
}
