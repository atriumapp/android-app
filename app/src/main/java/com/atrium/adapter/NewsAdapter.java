package com.atrium.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atrium.R;
import com.atrium.holder.NewsViewHolder;
import com.atrium.listener.ChoiceNewsListener;
import com.atrium.model.News;
import com.atrium.model.PaginationResponse;

/**
 * Created by romain on 10/08/2016.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private PaginationResponse<News> news;
    private Context context;

    public NewsAdapter(PaginationResponse<News> news, Context context) {
        this.news = news;
        this.context = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        News currentNews = news.getResults().get(position);
        holder.getTitle().setText(currentNews.getHeadline());
        holder.getAuthor().setText(currentNews.getAuthor().getName());
        holder.getContainer().setOnClickListener(new ChoiceNewsListener(currentNews));
    }

    @Override
    public int getItemCount() {
        if(news == null || news.getResults() == null){
            return 0;
        }else{
            return news.getResults().size();
        }
    }

    public void setNews(PaginationResponse<News> news) {
        this.news = news;
    }

    public void updateNewsPagination(PaginationResponse<News> moreResult){
        news.setNext_page(moreResult.getNext_page());
        news.setPrevious_page(moreResult.getPrevious_page());
        int curSize = this.getItemCount();
        news.addResult(moreResult.getResults());
        this.notifyItemRangeChanged(curSize, news.getResults().size() - 1);
    }
}
