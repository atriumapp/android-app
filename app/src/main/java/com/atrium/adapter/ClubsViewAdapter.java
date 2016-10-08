package com.atrium.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atrium.R;
import com.atrium.holder.ClubsViewHolder;
import com.atrium.listener.ChoiceClubsListener;
import com.atrium.model.Club;
import com.atrium.model.ListClubs;
import com.squareup.picasso.Callback;
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
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.clubs_item, parent, false);
        return new ClubsViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(final ClubsViewHolder holder, int position) {
        Club club = clubs.get(position);
        if(club.getLogo() != null){
            Picasso.with(context)
                    .load(club.getLogo())
                    .resizeDimen(R.dimen.clubs_image_view_width, R.dimen.clubs_images_view_height)
                    .into(holder.getImage(), new Callback.EmptyCallback(){
                        @Override
                        public void onError() {
                            holder.getImage().setImageResource(R.mipmap.image_default);
                        }
                    });
        }else{
            holder.getImage().setImageResource(R.drawable.default_club_image);
        }
        holder.getName().setText(club.getName());

        holder.getContainer().setOnClickListener(new ChoiceClubsListener(clubs.get(position)));
    }

    @Override
    public int getItemCount() {
        if (clubs != null) {
            return clubs.size();
        } else {
            return 0;
        }
    }

    public void setClubs(ListClubs clubs) {
        this.clubs = clubs;
    }
}
