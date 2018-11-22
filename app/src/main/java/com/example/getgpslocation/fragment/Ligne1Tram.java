package com.example.getgpslocation.fragment;

import android.content.Context;
import android.net.Uri;
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


public class Ligne1Tram extends android.support.v4.app.Fragment implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {

private FragmentTabHost mTabHost;
    View v8 ;

    private ViewPager viewPager8;
    private MyFragmentPagerAdapter myViewPagerAdapter77;
    public Ligne1Tram() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v8   = inflater.inflate(R.layout.fragment_ligne1_tram, container, false);
        viewPager8 = (ViewPager) v8.findViewById(R.id.pager8);

        // init tabhos
        this.initializeTabHost(savedInstanceState);

        // init ViewPager
        this.initializeViewPager();


        return v8;
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

        fragments.add(new Ligne11Tram());
        fragments.add(new Infotrafictram());


        this.myViewPagerAdapter77 = new MyFragmentPagerAdapter(
                getChildFragmentManager(), fragments);
        this.viewPager8 = (ViewPager) v8.findViewById(R.id.pager8);
        this.viewPager8.setAdapter(this.myViewPagerAdapter77);
        this.viewPager8.setOnPageChangeListener(this);

    }

    private void initializeTabHost(Bundle args) {

        mTabHost = (FragmentTabHost) v8.findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.tabcontent8);
        mTabHost.addTab(mTabHost.newTabSpec("abb5es").setIndicator("STATIONS"),Ligne11Tram.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("abb5es1").setIndicator("INFO TRAFIC"),Infotrafictram.class, null);


        mTabHost.setOnTabChangedListener(this);
    }



    public void onTabChanged(String tabId) {
        int pos = this.mTabHost.getCurrentTab();
        this.viewPager8.setCurrentItem(pos);

        HorizontalScrollView hScrollView = (HorizontalScrollView)   v8.findViewById(R.id.hScrollView8);
        View tabView = mTabHost.getCurrentTabView();
        int scrollPos = tabView.getLeft()
                - (hScrollView.getWidth() - tabView.getWidth()) / 2;
        hScrollView.smoothScrollTo(scrollPos, 0);

    }


    public void onPageScrollStateChanged(int arg0) {
    }


    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }


    public void onPageSelected(int position) {
        this.mTabHost.setCurrentTab(position);
    }
}
