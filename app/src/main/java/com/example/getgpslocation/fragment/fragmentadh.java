package com.example.getgpslocation.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.getgpslocation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentadh extends android.support.v4.app.Fragment {
Button htram , hbus , htrain ;

    public fragmentadh() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View c= inflater.inflate(R.layout.fragment_fragmentadh, container, false);
        htram = (Button) c.findViewById(R.id.htram);
        hbus = (Button) c.findViewById(R.id.hbus);
        htrain = (Button) c.findViewById(R.id.htrain);


        htram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.Fragment fragment = null;
                fragment = new tramheure();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.admin12,fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });



        htrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.Fragment fragment = null;
                fragment = new trainheure();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.admin12,fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });


        return c;


    }

}
