package com.example.shad.fragmenttablet;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends android.support.v4.app.Fragment {

   static final String COLOR_KEY = "color";
   static final String POSITION_KEY = "position";

   private int mBackgroundColor;
   private String mPosition;

   public static Fragment newInstance(@Nullable final Bundle extras) {
      DetailsFragment fragment = new DetailsFragment();
      fragment.setArguments(extras);

      return fragment;
   }

   @Override
   public void onCreate(@Nullable final Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      final int defaultColor = Color.BLACK;
      mBackgroundColor = getArguments() != null ? getArguments().getInt(COLOR_KEY, defaultColor) : defaultColor;
      mPosition = String.valueOf(getArguments() != null ? getArguments().getInt(POSITION_KEY, 1) : 1);
   }

   @Nullable
   @Override
   public View onCreateView(@NonNull final LayoutInflater inflater,
                            @Nullable final ViewGroup container,
                            @Nullable final Bundle savedInstanceState) {
      final View view = inflater.inflate(R.layout.fragment_content, container, false);;
      view.setBackgroundColor(mBackgroundColor);

      final TextView textView = view.findViewById(R.id.number);
      textView.setText(mPosition);

      return view;
   }
}
