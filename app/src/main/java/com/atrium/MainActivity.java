package com.atrium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

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
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);
        layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        ClubService clubService = ServicesGenerator.createService(ClubService.class);

        Call<ListClubs> request = clubService.getClubs();

        request.enqueue(new Callback<ListClubs>() {
            @Override
            public void onResponse(Call<ListClubs> call, Response<ListClubs> response) {
                ClubsViewAdapter adapter = new ClubsViewAdapter(response.body(), MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ListClubs> call, Throwable t) {

            }
        });


    }
}
