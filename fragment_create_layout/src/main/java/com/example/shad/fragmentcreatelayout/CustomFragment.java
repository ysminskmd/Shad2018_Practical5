package com.example.shad.fragmentcreatelayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CustomFragment extends Fragment {

   @Nullable
   @Override
   public View onCreateView(@NonNull final LayoutInflater inflater,
                            @Nullable final ViewGroup container,
                            @Nullable final Bundle savedInstanceState) {
      return inflater.inflate(R.layout.fragment, container, false);
   }
}
