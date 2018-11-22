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
public class fragmentahtr1 extends android.support.v4.app.Fragment {
    private TimePicker timePicker2;
    Button confirmer14;
    String Nom,direction,etat,HA,heurear;

    public fragmentahtr1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragmentahtr1, container, false);
        if (getArguments() != null) {
            Nom = this.getArguments().getString("Nom");}
        if (getArguments() != null) {
            direction = this.getArguments().getString("direction");}
        if (getArguments() != null) {
            etat = this.getArguments().getString("etat");}
        if (getArguments() != null) {
            HA = this.getArguments().getString("HA");}
        if (getArguments() != null) {
            heurear = this.getArguments().getString("heurear");}


        timePicker2 = (TimePicker) rootView.findViewById(R.id.time2);
        timePicker2.clearFocus();
        confirmer14 = (Button) rootView.findViewById(R.id.confirmer14);
        final int hour = timePicker2.getHour();
        int min = timePicker2.getMinute();
        confirmer14.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                timePicker2.clearFocus();
                final int hour = timePicker2.getHour() ;
                final int min = timePicker2.getMinute() ;
                String h = String.valueOf(hour)+String.valueOf(":")+String.valueOf(min)+String.valueOf(":")+String.valueOf("00");
                android.support.v4.app.Fragment fragment = null;
                Bundle bundle = new Bundle();
                bundle.putString("Nom", Nom);
                bundle.putString("direction", direction);
                bundle.putString("etat",etat);
                bundle.putString("HA",HA);
                bundle.putString("HC",h);
                bundle.putString("heurear",heurear);
                fragment = new fragmenthb();
                fragment.setArguments(bundle);
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.user49, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return rootView ;
    }

}
