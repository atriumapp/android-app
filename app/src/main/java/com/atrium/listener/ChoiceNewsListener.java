package com.atrium.listener;

import android.content.Intent;
import android.view.View;

import com.atrium.activity.NewsActivity;
import com.atrium.model.News;

/**
 * Created by romain on 13/08/2016.
 */
public class ChoiceNewsListener implements View.OnClickListener {

    private News news;

    public ChoiceNewsListener(News news) {
        this.news = news;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), NewsActivity.class);
        intent.putExtra(NewsActivity.NEWS_KEY, news.getId());
        view.getContext().startActivity(intent);
    }
}
