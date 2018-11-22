package com.example.getgpslocation.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

import com.example.getgpslocation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class heuread1 extends android.support.v4.app.Fragment {
    TimePicker timePicker4;
    Button confirmer15;
    String Nom,direction,etat,HC,heurear;


    public heuread1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_heuread1, container, false);
        if (getArguments() != null) {
            Nom = this.getArguments().getString("Nom");}
        if (getArguments() != null) {
            direction = this.getArguments().getString("direction");}
        if (getArguments() != null) {
            etat = this.getArguments().getString("etat");}
        if (getArguments() != null) {
            HC = this.getArguments().getString("HC");}
        if (getArguments() != null) {
            heurear = this.getArguments().getString("heurear");}


        timePicker4 = (TimePicker) rootView.findViewById(R.id.time3);
        timePicker4.clearFocus();
        confirmer15 = (Button) rootView.findViewById(R.id.confirmer15);
        final int hour = timePicker4.getHour();
        int min = timePicker4.getMinute();

        confirmer15.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                timePicker4.clearFocus();
                final int hour = timePicker4.getHour() ;
                final int min = timePicker4.getMinute() ;
                String h = String.valueOf(hour)+String.valueOf(":")+String.valueOf(min)+String.valueOf(":")+String.valueOf("00");
                android.support.v4.app.Fragment fragment = null;
                Bundle bundle = new Bundle();
                bundle.putString("Nom", Nom);
                bundle.putString("direction", direction);
                bundle.putString("etat",etat);
                bundle.putString("HA",h);
                bundle.putString("HC",HC);
                bundle.putString("heurear",heurear);
                fragment = new fragmenthb();
                fragment.setArguments(bundle);
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.user88, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return rootView ;
    }

}
