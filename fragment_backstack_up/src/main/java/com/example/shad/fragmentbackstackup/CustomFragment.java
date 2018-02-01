package com.example.shad.fragmentbackstackup;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CustomFragment extends android.support.v4.app.Fragment {

   private static final String COLOR_KEY = "color";
   private static final String NUMBER_KEY = "number";

   private int mBackgroundColor;
   private String mNumber;

   static CustomFragment getInstance(final int color, final int number) {
      final CustomFragment fragment = new CustomFragment();
      final Bundle bundle = new Bundle();
      bundle.putInt(COLOR_KEY, color);
      bundle.putInt(NUMBER_KEY, number);
      fragment.setArguments(bundle);
      return fragment;
   }

   @Override
   public void onCreate(@Nullable final Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      final int defaultColor = Color.BLACK;
      mBackgroundColor = getArguments() != null ? getArguments().getInt(COLOR_KEY, defaultColor) : defaultColor;
      mNumber = String.valueOf(getArguments() != null ? getArguments().getInt(NUMBER_KEY, 1) : 1);
   }

   @Nullable
   @Override
   public View onCreateView(@NonNull final LayoutInflater inflater,
                            @Nullable final ViewGroup container,
                            @Nullable final Bundle savedInstanceState) {
      final View view = inflater.inflate(R.layout.fragment, container, false);;
      view.setBackgroundColor(mBackgroundColor);

      final TextView textView = view.findViewById(R.id.number);
      textView.setText(mNumber);

      return view;
   }
}
