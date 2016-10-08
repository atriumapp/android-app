package com.atriumapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.atriumapp.activity.ClubDetailActivity;
import com.atriumapp.fragment.ClubEventsFragement;
import com.atriumapp.fragment.ClubInformationFragment;
import com.atriumapp.fragment.ClubNewsFragement;

/**
 * Created by romain on 07/08/2016.
 */
public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Information", "Evénement", "News" };
    private Context context;
    private String clubId;

    public FragmentPagerAdapter(FragmentManager fm, Context context, String clubId) {
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
                return ClubInformationFragment.newInstance(args);
            case 1:
                return ClubEventsFragement.newInstance(args);
            case 2:
                return ClubNewsFragement.newInstance(args);
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
