package com.atrium.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.atrium.MyApplication;
import com.atrium.R;
import com.atrium.model.Event;
import com.atrium.service.EventService;
import com.squareup.picasso.Picasso;

import org.sufficientlysecure.htmltextview.HtmlRemoteImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventActivity extends AppCompatActivity {

    public static String EVENT_KEY = "EVENT";
    private static String TAG = EventActivity.class.getName();

    private String eventId;
    private EventService eventService;

    @BindView(R.id.iv_event_image)
    ImageView imageView;

    @BindView(R.id.tv_event_title)
    TextView title;

    @BindView(R.id.tv_event_time)
    TextView time;

    @BindView(R.id.tv_event_descriptoion)
    HtmlTextView desciption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);

        eventService = ((MyApplication) getApplication()).getEventComponent().eventService();

        eventId = getIntent().getExtras().getString(EVENT_KEY);

        Call<Event> request = eventService.findEventById(eventId);

        request.enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {
                Event event = response.body();
                if(event.getPoster() != null){
                    Picasso.with(getApplicationContext())
                            .load(event.getPoster())
                            .into(imageView);
                }
                title.setText(event.getName());
                time.setText(event.getStart_date());
                desciption.setHtml(event.getDescription(), new HtmlRemoteImageGetter(desciption));
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {
                Log.e(TAG, "Get event by id fail", t);
            }
        });

    }
}
