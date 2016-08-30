package com.atrium.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.atrium.R;
import com.atrium.adapter.FragmentPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import cat.ereza.customactivityoncrash.CustomActivityOnCrash;

public class ClubDetailActivity extends AppCompatActivity {

    public static final String CLUB_SLUG = "clubSlug";
    @BindView(R.id.club_detail_sliding_tabs)
    TabLayout tabLayout;
    @BindView(R.id.club_detail_viewpager)
    ViewPager viewPager;
    private String clubNeeded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_detail);

        ButterKnife.bind(this);
        CustomActivityOnCrash.install(this);

        this.clubNeeded = getIntent().getStringExtra(this.CLUB_SLUG);

        this.viewPager.setCurrentItem(0);
        this.viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), ClubDetailActivity.this, clubNeeded));
        this.tabLayout.setupWithViewPager(this.viewPager);
    }
}
