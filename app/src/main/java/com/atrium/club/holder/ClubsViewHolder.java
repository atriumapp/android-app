package com.atrium.club.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.atrium.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by A613792 on 26/07/2016.
 */
public class ClubsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.clubs_card_view)
    private View container;

    @BindView(R.id.clubs_image_view)
    private ImageView image;

    @BindView(R.id.clubs_name_view)
    private TextView name;

    public ClubsViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(itemView);
    }

    public View getContainer() {
        return container;
    }

    public ImageView getImage() {
        return image;
    }

    public TextView getName() {
        return name;
    }
}
