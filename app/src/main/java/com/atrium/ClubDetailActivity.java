package com.atrium;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.atrium.adapter.ClubDetailFragmentPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClubDetailActivity extends AppCompatActivity {

    @BindView(R.id.club_detail_sliding_tabs)
    TabLayout tabLayout;

    @BindView(R.id.club_detail_viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_detail);

        ButterKnife.bind(this);

        viewPager.setCurrentItem(0);
        viewPager.setAdapter(new ClubDetailFragmentPagerAdapter(getSupportFragmentManager(), ClubDetailActivity.this));
        tabLayout.setupWithViewPager(viewPager);
    }
}
