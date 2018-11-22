package com.example.getgpslocation.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import com.example.getgpslocation.R;
import com.example.getgpslocation.fragment.MyFragmentPagerAdapter ;
import android.support.v4.app.FragmentManager ;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;

import java.util.List;
import java.util.Vector;


public class Fragment2 extends android.support.v4.app.Fragment implements OnTabChangeListener, OnPageChangeListener {
    private FragmentTabHost mTabHost;
    private ViewPager viewPager;
    private MyFragmentPagerAdapter myViewPagerAdapter;
    View v;

    public Fragment2() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment2, container, false);
        viewPager = (ViewPager) v.findViewById(R.id.pager);

        // init tabhos
        this.initializeTabHost(savedInstanceState);

        // init ViewPager
        this.initializeViewPager();


        return v;
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

        fragments.add(new TramHor());
        fragments.add(new BusHor());
        fragments.add(new Train());


        this.myViewPagerAdapter = new MyFragmentPagerAdapter(
                getChildFragmentManager(), fragments);
        this.viewPager = (ViewPager) v.findViewById(R.id.pager);
        this.viewPager.setAdapter(this.myViewPagerAdapter);
        this.viewPager.setOnPageChangeListener(this);

    }

    private void initializeTabHost(Bundle args) {

        mTabHost = (FragmentTabHost) v.findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.tabcontent);
        mTabHost.addTab(mTabHost.newTabSpec("fragmentb").setIndicator("", getResources().getDrawable(R.drawable.tram)),
                TramHor.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("fragmentc").setIndicator("", getResources().getDrawable(R.drawable.bus)),
                BusHor.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("fragmentd").setIndicator("", getResources().getDrawable(R.drawable.train)),
                Train.class, null);
        mTabHost.setOnTabChangedListener(this);
    }



    public void onTabChanged(String tabId) {
        int pos = this.mTabHost.getCurrentTab();
        this.viewPager.setCurrentItem(pos);

        HorizontalScrollView hScrollView = (HorizontalScrollView)   v.findViewById(R.id.hScrollView);
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



