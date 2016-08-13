package com.atrium.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atrium.R;
import com.atrium.holder.ClubsViewHolder;
import com.atrium.listener.ClubsOnClickListener;
import com.atrium.model.Club;
import com.atrium.model.ListClubs;
import com.squareup.picasso.Picasso;

/**
 * Created by A613792 on 26/07/2016.
 */
public class ClubsViewAdapter extends RecyclerView.Adapter<ClubsViewHolder> {

    private ListClubs clubs;
    private Context context;

    public ClubsViewAdapter(ListClubs clubs, Context context) {
        this.clubs = clubs;
        this.context = context;
    }

    @Override
    public ClubsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.clubs_grid, parent, false);
        return new ClubsViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(ClubsViewHolder holder, int position) {
        Club club = clubs.get(position);
        if(club.getLogo() != null){
            Picasso.with(context)
                    .load(club.getLogo())
                    .resizeDimen(R.dimen.clubs_image_view_width, R.dimen.clubs_images_view_height)
                    .into(holder.getImage());
        }
        holder.getName().setText(club.getName());

        holder.getContainer().setOnClickListener(new ClubsOnClickListener(clubs.get(position)));
    }

    @Override
    public int getItemCount() {
        return clubs.size();
    }

    public void setClubs(ListClubs clubs) {
        this.clubs = clubs;
    }
}
