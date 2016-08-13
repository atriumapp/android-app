package com.atrium.event.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atrium.R;
import com.atrium.event.holder.EventsViewHolder;
import com.atrium.event.listener.ChoiceEventListener;
import com.atrium.event.pojo.Event;
import com.atrium.pojo.utils.PaginationResponse;
import com.squareup.picasso.Picasso;

/**
 * Created by romain on 09/08/2016.
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsViewHolder> {

    PaginationResponse<Event> events;
    private Context context;

    public EventsAdapter(PaginationResponse<Event> events, Context context) {
        this.events = events;
        this.context = context;
    }

    @Override
    public EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_grid, parent, false);
        return new EventsViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(EventsViewHolder holder, int position) {
        Event event = events.getResults().get(position);
        if(event.getPoster() != null){
            Picasso.with(context)
                    .load(event.getPoster())
                    .into(holder.getImage());
        }
        holder.getTitle().setText(event.getName());
        holder.getPlace().setText(event.getPlace().getName());

        holder.getContainer().setOnClickListener(new ChoiceEventListener(event));

    }

    public void setEvents(PaginationResponse<Event> events) {
        this.events = events;
    }

    @Override
    public int getItemCount() {
        if(events == null || events.getResults() == null){
            return 0;
        }else{
            return events.getResults().size();
        }
    }

    public void updateEventsPagination(PaginationResponse<Event> moreResult){
        events.setNext_page(moreResult.getNext_page());
        events.setPrevious_page(moreResult.getPrevious_page());
        int curSize = this.getItemCount();
        events.addResult(moreResult.getResults());
        this.notifyItemRangeChanged(curSize, events.getResults().size() - 1);
    }

}
