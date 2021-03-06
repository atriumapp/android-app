package com.atriumapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.atriumapp.MyApplication;
import com.atriumapp.R;
import com.atriumapp.model.Event;
import com.atriumapp.service.EventService;
import com.squareup.picasso.Picasso;

import org.sufficientlysecure.htmltextview.HtmlRemoteImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventActivity extends AppCompatActivity {

    public static String EVENT_KEY = "EVENT";
    private static String TAG = EventActivity.class.getName();
    @BindView(R.id.iv_event_image)
    ImageView imageView;
    @BindView(R.id.tv_event_title)
    TextView title;
    @BindView(R.id.tv_event_time)
    TextView time;
    @BindView(R.id.tv_event_descriptoion)
    HtmlTextView desciption;
    private String eventId;
    private EventService eventService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ButterKnife.bind(this);
        CustomActivityOnCrash.install(this);

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
