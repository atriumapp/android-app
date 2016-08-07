package com.atrium.club.listener;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.atrium.ClubDetailActivity;
import com.atrium.club.pojo.Club;

/**
 * Created by A613792 on 26/07/2016.
 */
public class ClubsOnClickListener implements View.OnClickListener {

    Club club;

    public ClubsOnClickListener(Club club) {
        this.club = club;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Club cliked " + club.getName(), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(view.getContext(), ClubDetailActivity.class);
        view.getContext().startActivity(intent);
    }
}
