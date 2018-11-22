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
public class fragment6 extends android.support.v4.app.Fragment implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {
    private FragmentTabHost mTabHost5;
    private ViewPager viewPager5;
    private MyFragmentPagerAdapter myViewPagerAdapter;
    View v2;

    public fragment6() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       v2 =  inflater.inflate(R.layout.fragment_fragment6, container, false);
        viewPager5 = (ViewPager) v2.findViewById(R.id.pager5);

        // init tabhos
        this.initializeTabHost(savedInstanceState);

        // init ViewPager
        this.initializeViewPager();


        return v2;
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

        fragments.add(new Tramtarif());
        fragments.add(new bustarif());
        fragments.add(new traintarif());


        this.myViewPagerAdapter = new MyFragmentPagerAdapter(
                getChildFragmentManager(), fragments);
        this.viewPager5 = (ViewPager) v2.findViewById(R.id.pager5);
        this.viewPager5.setAdapter(this.myViewPagerAdapter);
        this.viewPager5.setOnPageChangeListener(this);

    }

    private void initializeTabHost(Bundle args) {

        mTabHost5 = (FragmentTabHost) v2.findViewById(android.R.id.tabhost);
        mTabHost5.setup(getActivity(), getChildFragmentManager(), R.id.tabcontent5);
        mTabHost5.addTab(mTabHost5.newTabSpec("tram").setIndicator("", getResources().getDrawable(R.drawable.tram)),
                Tramtarif.class, null);
        mTabHost5.addTab(mTabHost5.newTabSpec("bus").setIndicator("", getResources().getDrawable(R.drawable.bus)),
                bustarif.class, null);
        mTabHost5.addTab(mTabHost5.newTabSpec("train").setIndicator("", getResources().getDrawable(R.drawable.train)),
                traintarif.class, null);
        mTabHost5.setOnTabChangedListener(this);
    }



    public void onTabChanged(String tabId) {
        int pos = this.mTabHost5.getCurrentTab();
        this.viewPager5.setCurrentItem(pos);

        HorizontalScrollView hScrollView = (HorizontalScrollView)   v2.findViewById(R.id.hScrollView5);
        View tabView = mTabHost5.getCurrentTabView();
        int scrollPos = tabView.getLeft()
                - (hScrollView.getWidth() - tabView.getWidth()) / 2;
        hScrollView.smoothScrollTo(scrollPos, 0);

    }


    public void onPageScrollStateChanged(int arg0) {
    }


    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }


    public void onPageSelected(int position) {
        this.mTabHost5.setCurrentTab(position);
    }
}



