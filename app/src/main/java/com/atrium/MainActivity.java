package com.atrium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.atrium.club.adapter.ClubsViewAdapter;
import com.atrium.club.pojo.ListClubs;
import com.atrium.club.service.ClubService;
import com.atrium.generator.ServicesGenerator;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private StaggeredGridLayoutManager layoutManager;

    @BindView(R.id.main_recycler_view)
    RecyclerView recyclerView;

    private ListClubs clubs = new ListClubs();
    private ClubsViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);
        layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ClubsViewAdapter(clubs, MainActivity.this);
        recyclerView.setAdapter(adapter);

        ClubService clubService = ServicesGenerator.createService(ClubService.class);

        final Call<ListClubs> request = clubService.getClubs();

        request.enqueue(new Callback<ListClubs>() {
            @Override
            public void onResponse(Call<ListClubs> call, Response<ListClubs> response) {
                //Log.d("response", response.message());
                recyclerView.setAdapter(new ClubsViewAdapter(response.body(), MainActivity.this));
            }

            @Override
            public void onFailure(Call<ListClubs> call, Throwable t) {
                String test = call.request().header("Accept");
                Log.d("response", test, t);
            }
        });


    }
}
