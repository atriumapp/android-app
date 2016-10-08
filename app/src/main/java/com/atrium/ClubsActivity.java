package com.atrium;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import com.atrium.adapter.ClubsViewAdapter;
import com.atrium.callback.CallbackResponse;
import com.atrium.fabric.event.RequestFailEvent;
import com.atrium.model.ListClubs;
import com.atrium.service.ClubService;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Response;


public class ClubsActivity extends AppCompatActivity {

    private static final String TAG = "ClubsActivity";
    @BindView(R.id.main_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ClubService clubApi;
    private StaggeredGridLayoutManager layoutManager;
    private ListClubs clubs = new ListClubs();
    private ClubsViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);
        ButterKnife.bind(this);


        clubApi = ((MyApplication) getApplication()).getClubComponent().clubService();

        this.toolbar.setTitle(this.getString(R.string.main_toobar_title));
        setSupportActionBar(this.toolbar);

        this.recyclerView.setHasFixedSize(true);
        this.layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.adapter = new ClubsViewAdapter(this.clubs, ClubsActivity.this);
        this.recyclerView.setAdapter(this.adapter);


        final Call<ListClubs> request = clubApi.getClubs();

        request.enqueue(new CallbackResponse<ListClubs>() {
            @Override
            public void onResponse(Call<ListClubs> call, Response<ListClubs> response) {
                if(response.isSuccessful()){
                    recyclerView.setAdapter(new ClubsViewAdapter(response.body(), ClubsActivity.this));
                }else {
                    RequestFailEvent.sendEvent(call, response);
                }

            }
        });
    }

}
