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
public class fragment5 extends android.support.v4.app.Fragment implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {
    private FragmentTabHost mTabHost3;
    private ViewPager viewPager3;
    private MyFragmentPagerAdapter myViewPagerAdapter3;
    View k;


    public fragment5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        k  = inflater.inflate(R.layout.fragment_fragment5, container, false);
        viewPager3 = (ViewPager) k.findViewById(R.id.pager1);

        // init tabhos
        this.initializeTabHost(savedInstanceState);

        // init ViewPager
        this.initializeViewPager();


        return k;
    }

    // fake content for tabhost
    class FakeContent implements TabHost.TabContentFactory {
        private final Context mContext1;

        public FakeContent(Context context) {
            mContext1 = context;
        }

        @Override
        public View createTabContent(String tag) {
            View k = new View(mContext1);
            k.setMinimumHeight(0);
            k.setMinimumWidth(0);
            return k;
        }
    }

    private void initializeViewPager() {
        List<android.support.v4.app.Fragment> fragments = new Vector<android.support.v4.app.Fragment>();

        fragments.add(new Stattram());
        fragments.add(new Statbus());



        this.myViewPagerAdapter3 = new MyFragmentPagerAdapter(getChildFragmentManager(), fragments);
        this.viewPager3 = (ViewPager) k.findViewById(R.id.pager1);
        this.viewPager3.setAdapter(this.myViewPagerAdapter3);
        this.viewPager3.setOnPageChangeListener(this);

    }

    private void initializeTabHost(Bundle args) {

        mTabHost3 = (FragmentTabHost) k.findViewById(android.R.id.tabhost);
        mTabHost3.setup(getActivity(), getChildFragmentManager(), R.id.tabcontent1);
     // mTabHost3.addTab(mTabHost3.newTabSpec("fragmentt").setIndicator("", getResources().getDrawable(R.drawable.tram)),Stattram.class, null);
      //  mTabHost3.addTab(mTabHost3.newTabSpec("fragmentctt").setIndicator("", getResources().getDrawable(R.drawable.bus)),
            //    Statbus.class, null);

        mTabHost3.addTab(mTabHost3.newTabSpec("abbes").setIndicator("FERRE"),Stattram.class, null);
        mTabHost3.addTab(mTabHost3.newTabSpec("abbes1").setIndicator("BUS"),Statbus.class, null);

        mTabHost3.setOnTabChangedListener(this);
    }



    public void onTabChanged(String tabId) {
        int pos = this.mTabHost3.getCurrentTab();
        this.viewPager3.setCurrentItem(pos);

        HorizontalScrollView hScrollView = (HorizontalScrollView)   k.findViewById(R.id.hScrollView1);
        View tabView = mTabHost3.getCurrentTabView();
        int scrollPos = tabView.getLeft()
                - (hScrollView.getWidth() - tabView.getWidth()) / 2;
        hScrollView.smoothScrollTo(scrollPos, 0);

    }


    public void onPageScrollStateChanged(int arg0) {
    }


    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }


    public void onPageSelected(int position) {
        this.mTabHost3.setCurrentTab(position);
    }
}



