package com.atrium.event.listener;

import android.content.Intent;
import android.view.View;

import com.atrium.EventActivity;
import com.atrium.event.pojo.Event;

/**
 * Created by romain on 13/08/2016.
 */
public class ChoiceEventListener implements View.OnClickListener {

    private Event event;

    public ChoiceEventListener(Event event) {
        this.event = event;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), EventActivity.class);
        intent.putExtra(EventActivity.EVENT_KEY, event.getId());
        view.getContext().startActivity(intent);
    }
}
