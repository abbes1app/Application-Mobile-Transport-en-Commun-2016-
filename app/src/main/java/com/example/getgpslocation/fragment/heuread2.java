package com.example.getgpslocation.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

import com.example.getgpslocation.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class heuread2 extends android.support.v4.app.Fragment {
    TimePicker timePicker5;
    Button confirmer18;
    String Nom,direction,etat,HC,HA;


    public heuread2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        final String datenow = dateFormat.format(date);
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.fragment_heuread2, container, false);
        if (getArguments() != null) {
            Nom = this.getArguments().getString("Nom");}
        if (getArguments() != null) {
            direction = this.getArguments().getString("direction");}
        if (getArguments() != null) {
            etat = this.getArguments().getString("etat");}
        if (getArguments() != null) {
            HC = this.getArguments().getString("HC");}
        if (getArguments() != null) {
            HA = this.getArguments().getString("HA");}


        timePicker5 = (TimePicker) rootView.findViewById(R.id.time5);
        timePicker5.clearFocus();
        confirmer18 = (Button) rootView.findViewById(R.id.confirmer18);
        final int hour = timePicker5.getHour();
        int min = timePicker5.getMinute();

        confirmer18.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                timePicker5.clearFocus();
                final int hour = timePicker5.getHour() ;
                final int min = timePicker5.getMinute() ;
                String h = String.valueOf(hour)+String.valueOf(":")+String.valueOf(min)+String.valueOf(":")+String.valueOf("00");
                android.support.v4.app.Fragment fragment = null;
                Bundle bundle = new Bundle();
                bundle.putString("Nom", Nom);
                bundle.putString("direction", direction);
                bundle.putString("etat",etat);
                bundle.putString("HA",HA);
                bundle.putString("HC",HC);
                bundle.putString("heurear",h);
                fragment = new fragmenthb();
                fragment.setArguments(bundle);
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.user48, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return rootView ;
    }

}
