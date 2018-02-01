package com.example.shad.fragmentbackstackup;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int mFragmentNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                configureDisplayUpButton();
            }
        });

        if (savedInstanceState == null) {
            final Fragment fragment = createFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        popBackStack();
        return true;
    }

    private void configureDisplayUpButton() {
        final boolean canDisplay = getSupportFragmentManager().getBackStackEntryCount() > 0;
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(canDisplay);
        }
    }

    public void clickHome(View view) {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack(fm.getBackStackEntryAt(0).getId(),
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    public void clickNext(View view) {
        addFragment();
    }

    public void clickPopTop(View view) {
        popBackStack();
    }

    private void popBackStack() {
        getSupportFragmentManager().popBackStack();
    }

    private void addFragment() {
        final Fragment fragment = createFragment();
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private Fragment createFragment() {
        final int color = generateColor();
        return CustomFragment.getInstance(color, ++mFragmentNumber);
    }

    private int generateColor() {
        final Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
