package com.example.getgpslocation.fragment;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;

import com.example.getgpslocation.R;

import java.util.List;
import java.util.Vector;

/**
 * A simple {@link Fragment} subclass.
 */
public class Ligne2Tram extends android.support.v4.app.Fragment implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {

    private FragmentTabHost mTabHost9;
    View v9 ;

    private ViewPager viewPager9;
    private MyFragmentPagerAdapter myViewPagerAdapter88;

    public Ligne2Tram() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v9   = inflater.inflate(R.layout.fragment_ligne2_tram, container, false);
        viewPager9 = (ViewPager) v9.findViewById(R.id.pager9);

        // init tabhos
        this.initializeTabHost(savedInstanceState);

        // init ViewPager
        this.initializeViewPager();


        return v9;
    }

    // fake content for tabhost
    class FakeContent implements TabHost.TabContentFactory {
        private final Context mContext;

        public FakeContent(Context context) {
            mContext = context;
        }

        @Override
        public View createTabContent(String tag) {
            View v = new View(mContext);
            v.setMinimumHeight(0);
            v.setMinimumWidth(0);
            return v;
        }
    }

    private void initializeViewPager() {
        List<android.support.v4.app.Fragment> fragments = new Vector<android.support.v4.app.Fragment>();

        fragments.add(new Ligne22Tram());
        fragments.add(new Infotrafic2());


        this.myViewPagerAdapter88 = new MyFragmentPagerAdapter(
                getChildFragmentManager(), fragments);
        this.viewPager9 = (ViewPager) v9.findViewById(R.id.pager9);
        this.viewPager9.setAdapter(this.myViewPagerAdapter88);
        this.viewPager9.setOnPageChangeListener(this);

    }

    private void initializeTabHost(Bundle args) {

        mTabHost9 = (FragmentTabHost) v9.findViewById(android.R.id.tabhost);
        mTabHost9.setup(getActivity(), getChildFragmentManager(), R.id.tabcontent9);
        mTabHost9.addTab(mTabHost9.newTabSpec("abb5es").setIndicator("STATIONS"),Ligne22Tram.class, null);
        mTabHost9.addTab(mTabHost9.newTabSpec("abb5es1").setIndicator("INFO TRAFIC"),Infotrafic2.class, null);


        mTabHost9.setOnTabChangedListener(this);
    }



    public void onTabChanged(String tabId) {
        int pos = this.mTabHost9.getCurrentTab();
        this.viewPager9.setCurrentItem(pos);

        HorizontalScrollView hScrollView = (HorizontalScrollView)   v9.findViewById(R.id.hScrollView9);
        View tabView = mTabHost9.getCurrentTabView();
        int scrollPos = tabView.getLeft()
                - (hScrollView.getWidth() - tabView.getWidth()) / 2;
        hScrollView.smoothScrollTo(scrollPos, 0);

    }


    public void onPageScrollStateChanged(int arg0) {
    }


    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }


    public void onPageSelected(int position) {
        this.mTabHost9.setCurrentTab(position);
    }
}
