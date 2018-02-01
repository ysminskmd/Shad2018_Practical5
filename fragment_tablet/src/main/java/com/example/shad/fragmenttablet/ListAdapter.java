package com.example.shad.fragmenttablet;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter {

    @NonNull
    private final ListFragment.ListItemClickListener mListItemClickListener;

    @NonNull
    private final List<Integer> mData;

    ListAdapter(@NonNull final ListFragment.ListItemClickListener listItemClickListener,
                @NonNull final List<Integer> data) {
        mListItemClickListener = listItemClickListener;
        mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        bindListView((ListHolder) holder, position);
    }

    private void bindListView(@NonNull final ListHolder holder, final int position) {
        final View rootView = holder.getView();
        final View image = holder.getImage();
        final TextView textView = holder.getTitle();

        image.setBackgroundColor(mData.get(position));

        final int color = mData.get(position);
        final String hex = Integer.toHexString(color & 0x00FFFFFF);
        holder.getTitle().setText(hex.toUpperCase());

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                mListItemClickListener.onListItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
