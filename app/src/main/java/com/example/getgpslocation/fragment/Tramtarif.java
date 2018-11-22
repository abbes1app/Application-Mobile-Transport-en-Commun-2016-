package com.example.getgpslocation.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.getgpslocation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tramtarif extends android.support.v4.app.Fragment{


    public Tramtarif() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_tramtarif, container, false);
    return rootview ;
    }

}
