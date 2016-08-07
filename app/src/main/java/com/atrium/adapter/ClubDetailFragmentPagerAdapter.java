package com.atrium.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.atrium.ClubDetailActivity;
import com.atrium.fragment.ClubDetailEventFragement;
import com.atrium.fragment.ClubDetailInformationFragment;
import com.atrium.fragment.ClubDetailNewsFragement;

/**
 * Created by romain on 07/08/2016.
 */
public class ClubDetailFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Information", "Evénement", "News" };
    private Context context;
    private String clubId;

    public ClubDetailFragmentPagerAdapter(FragmentManager fm, Context context, String clubId) {
        super(fm);
        this.context = context;
        this.clubId = clubId;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        args.putString(ClubDetailActivity.CLUB_SLUG, clubId);
        switch (position){
            case 0:
                return ClubDetailInformationFragment.newInstance(args);
            case 1:
                return ClubDetailEventFragement.newInstance(args);
            case 2:
                return ClubDetailNewsFragement.newInstance(args);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
