package com.chyrta.onboarder;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnboarderFragment extends Fragment {

    private static final String ONBOARDER_PAGE_TITLE = "onboarder_page_title";
    private static final String ONBOARDER_PAGE_TITLE_RES_ID = "onboarder_page_title_res_id";
    private static final String ONBOARDER_PAGE_TITLE_COLOR = "onboarder_page_title_color";
    private static final String ONBOARDER_PAGE_TITLE_TEXT_SIZE = "onboarder_page_title_text_size";
    private static final String ONBOARDER_PAGE_DESCRIPTION = "onboarder_page_description";
    private static final String ONBOARDER_PAGE_DESCRIPTION_RES_ID = "onboarder_page_description_res_id";
    private static final String ONBOARDER_PAGE_DESCRIPTION_COLOR = "onborader_page_description_color";
    private static final String ONBOARDER_PAGE_DESCRIPTION_TEXT_SIZE = "onboarder_page_description_text_size";
    private static final String ONBOARDER_PAGE_IMAGE_RES_ID = "onboarder_page_iamge_res_id";
    private static final String ONBOARDER_PAGE_IMAGE_SCALE_TYPE = "onboarder_page_iamge_scale_type";

    private String onboarderTitle;
    private String onboarderDescription;
    private float onboarderTitleTextSize;
    private float onboarderDescriptionTextSize;
    private ImageView.ScaleType onboarderImageScaleType;

    @StringRes private int onboarderTitleResId;
    @ColorRes private int onboarderTitleColor;
    @StringRes private int onboarderDescriptionResId;
    @ColorRes private int onboarderDescriptionColor;

    private int[] onboarderImageResIds;

    private View onboarderView;
    private ViewGroup ivOnboarderImages;
    private TextView tvOnboarderTitle;
    private TextView tvOnboarderDescription;

    public OnboarderFragment() {
    }

    public static OnboarderFragment newInstance(OnboarderPage page) {
        Bundle args = new Bundle();
        args.putString(ONBOARDER_PAGE_TITLE, page.getTitle());
        args.putString(ONBOARDER_PAGE_DESCRIPTION, page.getDescription());
        args.putInt(ONBOARDER_PAGE_TITLE_RES_ID, page.getTitleResourceId());
        args.putInt(ONBOARDER_PAGE_DESCRIPTION_RES_ID, page.getDescriptionResourceId());
        args.putInt(ONBOARDER_PAGE_TITLE_COLOR, page.getTitleColor());
        args.putInt(ONBOARDER_PAGE_DESCRIPTION_COLOR, page.getDescriptionColor());
        args.putIntArray(ONBOARDER_PAGE_IMAGE_RES_ID, page.getImageResourceIds());
        args.putFloat(ONBOARDER_PAGE_TITLE_TEXT_SIZE, page.getTitleTextSize());
        args.putFloat(ONBOARDER_PAGE_DESCRIPTION_TEXT_SIZE, page.getDescriptionTextSize());
        args.putSerializable(ONBOARDER_PAGE_IMAGE_SCALE_TYPE, page.getScaleType());
        OnboarderFragment fragment = new OnboarderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle bundle = getArguments();

        onboarderTitle = bundle.getString(ONBOARDER_PAGE_TITLE, null);
        onboarderTitleResId = bundle.getInt(ONBOARDER_PAGE_TITLE_RES_ID, 0);
        onboarderTitleColor = bundle.getInt(ONBOARDER_PAGE_TITLE_COLOR, 0);
        onboarderTitleTextSize = bundle.getFloat(ONBOARDER_PAGE_TITLE_TEXT_SIZE, 0f);
        onboarderDescription = bundle.getString(ONBOARDER_PAGE_DESCRIPTION, null);
        onboarderDescriptionResId = bundle.getInt(ONBOARDER_PAGE_DESCRIPTION_RES_ID, 0);
        onboarderDescriptionColor = bundle.getInt(ONBOARDER_PAGE_DESCRIPTION_COLOR, 0);
        onboarderDescriptionTextSize = bundle.getFloat(ONBOARDER_PAGE_DESCRIPTION_TEXT_SIZE, 0f);
        onboarderImageResIds = bundle.getIntArray(ONBOARDER_PAGE_IMAGE_RES_ID);
        onboarderImageScaleType = (ImageView.ScaleType) bundle.getSerializable(ONBOARDER_PAGE_IMAGE_SCALE_TYPE);

        onboarderView = inflater.inflate(R.layout.fragment_onboarder, container, false);
        ivOnboarderImages = (ViewGroup) onboarderView.findViewById(R.id.iv_onboarder_images);
        tvOnboarderTitle = (TextView) onboarderView.findViewById(R.id.tv_onboarder_title);
        tvOnboarderDescription = (TextView) onboarderView.findViewById(R.id.tv_onboarder_description);


        if (onboarderTitle != null) {
            tvOnboarderTitle.setText(onboarderTitle);
        }

        if (onboarderTitleResId != 0) {
            tvOnboarderTitle.setText(getResources().getString(onboarderTitleResId));
        }

        if (onboarderDescription != null) {
            tvOnboarderDescription.setText(onboarderDescription);
        }

        if (onboarderDescriptionResId != 0) {
            tvOnboarderDescription.setText(getResources().getString(onboarderDescriptionResId));
        }

        if (onboarderTitleColor != 0) {
            tvOnboarderTitle.setTextColor(ContextCompat.getColor(getActivity(), onboarderTitleColor));
        }

        if (onboarderDescriptionColor != 0) {
            tvOnboarderDescription.setTextColor(ContextCompat.getColor(getActivity(), onboarderDescriptionColor));
        }

        if (onboarderTitleTextSize != 0f) {
            tvOnboarderTitle.setTextSize(onboarderTitleTextSize);
        }

        if (onboarderDescriptionTextSize != 0f) {
            tvOnboarderDescription.setTextSize(onboarderDescriptionTextSize);
        }

        if (onboarderImageResIds != null) {
            for(int onboarderImageResId : onboarderImageResIds) {
                ImageView imageView = new ImageView(getActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                );
                layoutParams.gravity = Gravity.CENTER;
                imageView.setLayoutParams(layoutParams);
                imageView.setAdjustViewBounds(true);
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), onboarderImageResId));
                ivOnboarderImages.addView(imageView);
            }
        }

        return onboarderView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
