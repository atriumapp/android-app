package com.atrium.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atrium.ClubDetailActivity;
import com.atrium.MyApplication;
import com.atrium.R;
import com.atrium.listener.EndlessRecyclerViewScrollListener;
import com.atrium.news.adapter.NewsAdapter;
import com.atrium.news.pojo.News;
import com.atrium.news.service.NewsService;
import com.atrium.pojo.utils.PaginationResponse;

import java.util.LinkedHashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClubDetailNewsFragement extends Fragment {

    private static final String TAG = "NewsFragment";

    private String clubId;

    @BindView(R.id.news_recycler_view)
    RecyclerView recyclerView;

    PaginationResponse<News> news;
    NewsAdapter newsAdapter;

    NewsService newsService;

    public ClubDetailNewsFragement() {
        // Required empty public constructor
    }

    public static ClubDetailNewsFragement newInstance(Bundle bundle) {
        ClubDetailNewsFragement fragment = new ClubDetailNewsFragement();
        fragment.setArguments(bundle);
        return fragment;
}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_club_detail_news_fragement, container, false);
        ButterKnife.bind(this, view);

        this.newsService = ((MyApplication) getActivity().getApplication()).getNewsComponent().newsService();

        recyclerView.setHasFixedSize(true);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        this.newsAdapter = new NewsAdapter(news, getContext());
        recyclerView.setAdapter(newsAdapter);
        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                if(news.getPages() == 1 || page > news.getPages()){
                    return;
                }
                LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
                options.put("club", clubId);
                options.put("page", String.valueOf(page));
                final Call<PaginationResponse<News>> requestMore = newsService.findNewsByClub(options);

                requestMore.enqueue(new Callback<PaginationResponse<News>>() {
                    @Override
                    public void onResponse(Call<PaginationResponse<News>> call, Response<PaginationResponse<News>> response) {
                        newsAdapter.updateNewsPagination(response.body());
                    }

                    @Override
                    public void onFailure(Call<PaginationResponse<News>> call, Throwable t) {
                        Log.e(TAG, "Request more fail", t);
                    }
                });
            }
        });

        Bundle args = getArguments();
        this.clubId = args.getString(ClubDetailActivity.CLUB_SLUG);

        LinkedHashMap<String, String> options = new LinkedHashMap<>();
        options.put("club", this.clubId);

        Call<PaginationResponse<News>> request = newsService.findNewsByClub(options);

        request.enqueue(new Callback<PaginationResponse<News>>() {
            @Override
            public void onResponse(Call<PaginationResponse<News>> call, Response<PaginationResponse<News>> response) {
                news = response.body();
                newsAdapter.setNews(news);
                newsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PaginationResponse<News>> call, Throwable t) {
                Log.e(TAG, "Request fail", t);
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
