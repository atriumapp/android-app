package com.atrium.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atrium.ClubDetailActivity;
import com.atrium.MyApplication;
import com.atrium.R;
import com.atrium.event.adapter.EventsAdapter;
import com.atrium.event.pojo.Event;
import com.atrium.event.service.EventService;
import com.atrium.listener.EndlessRecyclerViewScrollListener;
import com.atrium.pojo.utils.PaginationResponse;

import java.util.LinkedHashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClubDetailEventsFragement extends Fragment {

    private static final String TAG = "EventsFragment";

    private String clubId;

    @BindView(R.id.events_recycler_view)
    RecyclerView recyclerView;

    PaginationResponse<Event> events;
    EventsAdapter adapter;

    EventService eventService;

    public static ClubDetailEventsFragement newInstance(Bundle bundle) {
        ClubDetailEventsFragement fragment = new ClubDetailEventsFragement();
        fragment.setArguments(bundle);
        return fragment;
    }

    public ClubDetailEventsFragement() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_club_detail_event_fragement, container, false);
        ButterKnife.bind(this, view);

        eventService = ((MyApplication) getActivity().getApplication()).getEventComponent().eventService();

        recyclerView.setHasFixedSize(true);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new EventsAdapter(events, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                if(events.getPages() == 1 || page > events.getPages()){
                    return;
                }
                LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
                options.put("club", clubId);
                options.put("page", String.valueOf(page));
                final Call<PaginationResponse<Event>> requestMore = eventService.findEventByClub(options);

                requestMore.enqueue(new Callback<PaginationResponse<Event>>() {
                    @Override
                    public void onResponse(Call<PaginationResponse<Event>> call, Response<PaginationResponse<Event>> response) {
                        PaginationResponse<Event> moreResult = response.body();
                        adapter.updateEventsPagination(moreResult);
                    }

                    @Override
                    public void onFailure(Call<PaginationResponse<Event>> call, Throwable t) {
                        Log.e(TAG, "Request more fail", t);
                    }
                });
            }
        });

        Bundle args = getArguments();
        this.clubId = args.getString(ClubDetailActivity.CLUB_SLUG);

        LinkedHashMap<String, String> options = new LinkedHashMap<>();
        options.put("club", this.clubId);

        final Call<PaginationResponse<Event>> request = eventService.findEventByClub(options);


        request.enqueue(new Callback<PaginationResponse<Event>>() {
            @Override
            public void onResponse(Call<PaginationResponse<Event>> call, Response<PaginationResponse<Event>> response) {
                events = response.body();
                adapter.setEvents(events);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PaginationResponse<Event>> call, Throwable t) {
                Log.e(TAG, "Request fail", t);
            }
        });



        return view;
    }
}
