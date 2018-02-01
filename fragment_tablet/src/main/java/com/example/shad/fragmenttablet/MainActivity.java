package com.example.shad.fragmenttablet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements ListFragment.ListItemClickListener {

    private int mFragmentNumber;

    private ArrayList<Integer> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            mData = generateData();

            final Fragment fragment = ListFragment.newInstance(mData);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }

        //rotate
    }

    @Override
    public void onListItemClick(final int position) {
        final Bundle extras = new Bundle();
        final int color = mData.get(position);
        extras.putInt(DetailsFragment.COLOR_KEY, color);
        extras.putInt(DetailsFragment.POSITION_KEY, position + 1);

        final View detailsFragment = findViewById(R.id.fragment_details_container);
        if (detailsFragment == null) {
            final Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtras(extras);

            startActivity(intent);
        } else {
            final Fragment fragment = DetailsFragment.newInstance(extras);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_details_container, fragment).commit();
            //detailsFragment.updateContent(color, position);
        }
    }

    @NonNull
    private ArrayList<Integer> generateData() {
        final ArrayList<Integer> colors = new ArrayList<>();
        final Random rnd = new Random();
        for (int i = 0; i < 1000; i++) {
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            colors.add(color);
        }

        return colors;
    }
}
