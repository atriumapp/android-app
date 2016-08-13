package com.atrium.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.atrium.R;
import com.atrium.adapter.ClubDetailFragmentPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClubDetailActivity extends AppCompatActivity {

    public static final String CLUB_SLUG = "clubSlug";
    private String clubNeeded;

    @BindView(R.id.club_detail_sliding_tabs)
    TabLayout tabLayout;

    @BindView(R.id.club_detail_viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_detail);

        ButterKnife.bind(this);

        this.clubNeeded = getIntent().getStringExtra(this.CLUB_SLUG);

        this.viewPager.setCurrentItem(0);
        this.viewPager.setAdapter(new ClubDetailFragmentPagerAdapter(getSupportFragmentManager(), ClubDetailActivity.this, clubNeeded));
        this.tabLayout.setupWithViewPager(this.viewPager);
    }
}
