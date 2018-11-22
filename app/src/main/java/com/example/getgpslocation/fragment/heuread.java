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
public class heuread extends android.support.v4.app.Fragment {

    TimePicker timePicker2;
    Button confirmer13;
    String Nom,direction,etat,HC;
    public heuread() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_heuread, container, false);
        if (getArguments() != null) {
            Nom = this.getArguments().getString("Nom");}
        if (getArguments() != null) {
            direction = this.getArguments().getString("direction");}
        if (getArguments() != null) {
            etat = this.getArguments().getString("etat");}
        if (getArguments() != null) {
            HC = this.getArguments().getString("HC");}


        timePicker2 = (TimePicker) rootView.findViewById(R.id.time1);
        timePicker2.clearFocus();
        confirmer13 = (Button) rootView.findViewById(R.id.confirmer13);
        final int hour = timePicker2.getHour();
        int min = timePicker2.getMinute();

        confirmer13.setOnClickListener(new View.OnClickListener() {



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
                bundle.putString("HA",h);
                bundle.putString("HC",HC);
                fragment = new fragmentht();
                fragment.setArguments(bundle);
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.user5, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return rootView ;
    }

}
