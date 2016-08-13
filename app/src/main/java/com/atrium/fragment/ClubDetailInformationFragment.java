package com.atrium.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.atrium.activity.ClubDetailActivity;
import com.atrium.MyApplication;
import com.atrium.R;
import com.atrium.model.ClubDetail;
import com.atrium.service.ClubService;
import com.squareup.picasso.Picasso;

import org.sufficientlysecure.htmltextview.HtmlRemoteImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClubDetailInformationFragment extends Fragment {


    private Unbinder unbinder;
    private String clubId;

    private ClubService clubService;

    @BindView(R.id.club_detail_information_imageView)
    ImageView imageView;

    @BindView(R.id.club_detail_information_textView)
    HtmlTextView textView;

    public ClubDetailInformationFragment() {
        // Required empty public constructor
    }

    public static ClubDetailInformationFragment newInstance(Bundle bundle) {
        ClubDetailInformationFragment fragment = new ClubDetailInformationFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_club_detail_information, container, false);
        ButterKnife.bind(this, view);

        Bundle args = getArguments();
        this.clubId = args.getString(ClubDetailActivity.CLUB_SLUG);

        this.clubService = ((MyApplication) getActivity().getApplication()).getClubComponent().clubService();

        final Call<ClubDetail> club = this.clubService.getClub(this.clubId);

        club.enqueue(new Callback<ClubDetail>() {
            @Override
            public void onResponse(Call<ClubDetail> call, Response<ClubDetail> response) {
                ClubDetail detail = response.body();
                Picasso.with(getContext())
                        .load(detail.getLogo())
                        .resizeDimen(R.dimen.club_detail_information_image, R.dimen.club_detail_information_image)
                        .into(imageView);
                textView.setHtml(detail.getDescription(), new HtmlRemoteImageGetter(textView));
            }

            @Override
            public void onFailure(Call<ClubDetail> call, Throwable t) {

            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
    }
}
