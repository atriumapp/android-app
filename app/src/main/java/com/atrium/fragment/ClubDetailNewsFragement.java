package com.atrium.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.atrium.ClubDetailActivity;
import com.atrium.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClubDetailNewsFragement extends Fragment {


    private String clubId;
    private Unbinder unbinder;

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
        Bundle args = getArguments();
        this.clubId = args.getString(ClubDetailActivity.CLUB_SLUG);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //unbinder.unbind();
    }
}
