package com.atrium;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.atrium.news.pojo.News;
import com.atrium.news.service.NewsService;

import org.sufficientlysecure.htmltextview.HtmlRemoteImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {

    public static String NEWS_KEY = "NEWS";
    private static String TAG = NewsActivity.class.getName();

    private String newsId;
    private NewsService newsService;

    @BindView(R.id.tv_news_title)
    TextView title;

    @BindView(R.id.tv_news_author)
    TextView author;

    @BindView(R.id.tv_news_content)
    HtmlTextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ButterKnife.bind(this);
        newsService = ((MyApplication) getApplication()).getNewsComponent().newsService();

        newsId = getIntent().getExtras().getString(NEWS_KEY);

        Call<News> request = newsService.findNewsById(newsId);

        request.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                News news = response.body();
                title.setText(news.getHeadline());
                author.setText("Ecrit par " + news.getAuthor().getName());
                content.setHtml(news.getContent(), new HtmlRemoteImageGetter(content));
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.e(TAG, "Request news by id fail", t);
            }
        });
    }
}
