package com.atrium.listener;

import android.content.Intent;
import android.view.View;

import com.atrium.activity.EventActivity;
import com.atrium.model.Event;

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
