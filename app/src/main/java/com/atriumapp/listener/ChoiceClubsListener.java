package com.atriumapp.listener;

import android.content.Intent;
import android.view.View;

import com.atriumapp.activity.ClubDetailActivity;
import com.atriumapp.model.Club;

/**
 * Created by A613792 on 26/07/2016.
 */
public class ChoiceClubsListener implements View.OnClickListener {

    Club club;

    public ChoiceClubsListener(Club club) {
        this.club = club;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), ClubDetailActivity.class);
        intent.putExtra(ClubDetailActivity.CLUB_SLUG, club.getSlug());
        view.getContext().startActivity(intent);
    }
}
