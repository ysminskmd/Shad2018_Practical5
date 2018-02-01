package com.example.shad.fragmenttabs;
/*
 * This file is a part of the Yandex Advertising Network
 *
 * Version for Android (C) 2018 YANDEX
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at https://legal.yandex.com/partner_ch/
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailsFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_COLOR = "color";

    public DetailsFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static DetailsFragment newInstance(final int color, int sectionNumber) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLOR, color);
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_content, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.number);

        final int position = getArguments().getInt(ARG_SECTION_NUMBER);
        textView.setText(String.valueOf(position));

        final int defaultColor = getResources().getColor(R.color.colorAccent);
        final int color = getArguments() != null
                ? getArguments().getInt(ARG_COLOR, defaultColor)
                : defaultColor;
        rootView.setBackgroundColor(color);

        return rootView;
    }
}
