package com.atrium.event.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.atrium.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by romain on 10/08/2016.
 */
public class EventsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.events_grid_cardView)
    View container;

    @BindView(R.id.events_grid_image)
    ImageView image;

    @BindView(R.id.events_grid_title)
    TextView title;

    @BindView(R.id.events_grid_place)
    TextView place;

    public EventsViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public View getContainer() {
        return container;
    }

    public ImageView getImage() {
        return image;
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getPlace() {
        return place;
    }
}
