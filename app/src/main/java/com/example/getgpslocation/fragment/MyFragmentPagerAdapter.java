package com.example.getgpslocation.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    List<android.support.v4.app.Fragment> fragments;

    public MyFragmentPagerAdapter(FragmentManager fm, List<android.support.v4.app.Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }



    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {

        return fragments.size();
    }

}
