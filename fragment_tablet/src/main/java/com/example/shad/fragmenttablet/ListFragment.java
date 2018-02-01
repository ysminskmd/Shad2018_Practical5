package com.example.shad.fragmenttablet;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.support.v7.widget.RecyclerView.HORIZONTAL;

public class ListFragment extends android.support.v4.app.Fragment {

   interface ListItemClickListener {
      void onListItemClick(final int position);
   }

   private static final String DATA_KEY = "data";

   public static ListFragment newInstance(final ArrayList<Integer> data) {
      Bundle args = new Bundle();
      args.putIntegerArrayList(DATA_KEY, data);

      ListFragment fragment = new ListFragment();
      fragment.setArguments(args);
      return fragment;
   }

   private ListItemClickListener mListItemClickListener;

   private List<Integer> mData;

   @Override
   public void onAttach(final Context context) {
      super.onAttach(context);
      try {
         mListItemClickListener = (ListItemClickListener) getActivity();
      } catch (final ClassCastException ignored) {}
   }

   @Override
   public void onCreate(@Nullable final Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      mData = getArguments() != null ? getArguments().getIntegerArrayList(DATA_KEY) : Collections.<Integer>emptyList();
   }

   @Nullable
   @Override
   public View onCreateView(@NonNull final LayoutInflater inflater,
                            @Nullable final ViewGroup container,
                            @Nullable final Bundle savedInstanceState) {
      final View rootView = inflater.inflate(R.layout.fragment_list, container, false);

      final RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
      final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
      final DividerItemDecoration dividerItemDecoration =
              new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
      recyclerView.addItemDecoration(dividerItemDecoration);
      recyclerView.setHasFixedSize(true);
      recyclerView.setLayoutManager(layoutManager);

      final ListAdapter listAdapter = new ListAdapter(mListItemClickListener, mData);
      recyclerView.setAdapter(listAdapter);

      return rootView;
   }
}
