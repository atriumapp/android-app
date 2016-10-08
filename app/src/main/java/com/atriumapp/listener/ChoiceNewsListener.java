package com.atriumapp.listener;

import android.content.Intent;
import android.view.View;

import com.atriumapp.activity.NewsActivity;
import com.atriumapp.model.News;

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
