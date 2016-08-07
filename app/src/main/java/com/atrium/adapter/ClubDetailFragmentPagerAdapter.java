package com.atrium.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

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

    public ClubDetailFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return ClubDetailInformationFragment.newInstance();
            case 1:
                return ClubDetailEventFragement.newInstance();
            case 2:
                return ClubDetailNewsFragement.newInstance();
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
