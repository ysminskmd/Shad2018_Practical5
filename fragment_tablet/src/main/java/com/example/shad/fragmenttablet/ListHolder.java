package com.example.shad.fragmenttablet;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class ListHolder extends RecyclerView.ViewHolder {

    private final View mView;
    private final View mImage;
    private final TextView mTitle;

    ListHolder(final View view) {
        super(view);
        mView = view;
        mImage = view.findViewById(R.id.image);
        mTitle = view.findViewById(R.id.title);
    }

    View getView() {
        return mView;
    }

    View getImage() {
        return mImage;
    }

    TextView getTitle() {
        return mTitle;
    }
}
