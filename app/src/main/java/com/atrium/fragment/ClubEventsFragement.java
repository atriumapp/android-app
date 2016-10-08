package com.atrium.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atrium.activity.ClubDetailActivity;
import com.atrium.MyApplication;
import com.atrium.R;
import com.atrium.adapter.EventsAdapter;
import com.atrium.callback.CallbackResponse;
import com.atrium.fabric.event.RequestFailEvent;
import com.atrium.model.Event;
import com.atrium.service.EventService;
import com.atrium.listener.EndlessRecyclerViewScrollListener;
import com.atrium.model.PaginationResponse;

import java.util.LinkedHashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClubEventsFragement extends Fragment {

    private static final String TAG = "EventsFragment";

    private String clubId;

    @BindView(R.id.events_recycler_view)
    RecyclerView recyclerView;

    PaginationResponse<Event> events;
    EventsAdapter adapter;

    EventService eventService;

    public static ClubEventsFragement newInstance(Bundle bundle) {
        ClubEventsFragement fragment = new ClubEventsFragement();
        fragment.setArguments(bundle);
        return fragment;
    }

    public ClubEventsFragement() {
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
        View view = inflater.inflate(R.layout.club_event_fragement, container, false);
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

                requestMore.enqueue(new CallbackResponse<PaginationResponse<Event>>() {
                    @Override
                    public void onResponse(Call<PaginationResponse<Event>> call, Response<PaginationResponse<Event>> response) {
                        if(response.isSuccessful()){
                            PaginationResponse<Event> moreResult = response.body();
                            adapter.updateEventsPagination(moreResult);
                        }else {
                            RequestFailEvent.sendEvent(call, response);
                        }
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
