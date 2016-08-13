package com.atrium.news.holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.atrium.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by romain on 10/08/2016.
 */
public class NewsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.news_grid_cardView)
    CardView container;

    @BindView(R.id.news_grid_title)
    TextView title;

    @BindView(R.id.news_grid_author)
    TextView author;

    public NewsViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getAuthor() {
        return author;
    }

    public CardView getContainer() {
        return container;
    }
}
