package com.example.getgpslocation.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.getgpslocation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment7 extends android.support.v4.app.Fragment {


    public fragment7() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final    View rootView = inflater.inflate(R.layout.fragment_fragment7, container, false);


                ExtendViewPager mViewPager = (ExtendViewPager) rootView.findViewById(R.id.view_pager5);
                mViewPager.setAdapter(new TouchImageAdapter());

        return  rootView ;

    }

            static class TouchImageAdapter extends PagerAdapter {

                private static int[] images = {
                        R.drawable.a1,
                        R.drawable.a2,
                        R.drawable.a3,
                        R.drawable.a4,
                        };

                @Override
                public int getCount() {
                    return images.length;
                }

                @Override
                public View instantiateItem(ViewGroup container, int position) {
                    TouchImageView img = new TouchImageView(container.getContext());
                    img.setImageResource(images[position]);
                    container.addView(img, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                    return img;
                }

                @Override
                public void destroyItem(ViewGroup container, int position, Object object) {
                    container.removeView((View) object);
                }

                @Override
                public boolean isViewFromObject(View view, Object object) {
                    return view == object;
                }

            }
        }




