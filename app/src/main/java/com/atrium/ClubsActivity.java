package com.atrium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.atrium.club.adapter.ClubsViewAdapter;
import com.atrium.club.module.ClubModule;
import com.atrium.club.pojo.ListClubs;
import com.atrium.club.service.ClubService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ClubsActivity extends AppCompatActivity {

    private static final String TAG = "ClubsActivity";

    private StaggeredGridLayoutManager layoutManager;

    @BindView(R.id.main_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ListClubs clubs = new ListClubs();
    private ClubsViewAdapter adapter;

    @Inject
    ClubService clubApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);
        ButterKnife.bind(this);

        ((MyApplication) getApplication()).getClubComponent().inject(this);

        this.toolbar.setTitle(this.getString(R.string.main_toobar_title));
        setSupportActionBar(this.toolbar);

        this.recyclerView.setHasFixedSize(true);
        this.layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.adapter = new ClubsViewAdapter(this.clubs, ClubsActivity.this);
        this.recyclerView.setAdapter(this.adapter);


        final Call<ListClubs> request = clubApi.getClubs();

        request.enqueue(new Callback<ListClubs>() {
            @Override
            public void onResponse(Call<ListClubs> call, Response<ListClubs> response) {
                recyclerView.setAdapter(new ClubsViewAdapter(response.body(), ClubsActivity.this));
            }

            @Override
            public void onFailure(Call<ListClubs> call, Throwable t) {
                Log.e(TAG, "Request fail", t);
            }
        });


    }
}