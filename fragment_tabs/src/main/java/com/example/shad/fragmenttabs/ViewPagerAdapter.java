package com.example.shad.fragmenttabs;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */

//FragmentStatePagerAdapter
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    @NonNull
    private final List<Integer> mData;

    ViewPagerAdapter(@NonNull final FragmentManager fm,
                     @NonNull final List<Integer> data) {
        super(fm);
        mData = data;

        //add logs for fragment lifecycle
    }

    @Override
    public Fragment getItem(int position) {
        final int color = mData.get(position);
        return DetailsFragment.newInstance(color, position + 1);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public CharSequence getPageTitle(final int position) {
        final int color = mData.get(position);
        final String hex = Integer.toHexString(color & 0x00FFFFFF);
        return "#" + hex.toUpperCase();
    }
}
