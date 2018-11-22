package com.example.getgpslocation.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.getgpslocation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentahtr extends android.support.v4.app.Fragment {

    private TimePicker timePicker1;
    Button confirmer12;
String Nom,direction,etat,HA;

    public fragmentahtr() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View rootView = inflater.inflate(R.layout.fragment_fragmentahtr, container, false);
        if (getArguments() != null) {
            Nom = this.getArguments().getString("Nom");}
        if (getArguments() != null) {
            direction = this.getArguments().getString("direction");}
        if (getArguments() != null) {
            etat = this.getArguments().getString("etat");}
        if (getArguments() != null) {
            HA = this.getArguments().getString("HA");}


        timePicker1 = (TimePicker) rootView.findViewById(R.id.time);
        timePicker1.clearFocus();
        confirmer12 = (Button) rootView.findViewById(R.id.confirmer12);
        final int hour = timePicker1.getHour();
        int min = timePicker1.getMinute();

        confirmer12.setOnClickListener(new View.OnClickListener() {



    @Override
    public void onClick(View v) {
        timePicker1.clearFocus();
        final int hour = timePicker1.getHour() ;
        final int min = timePicker1.getMinute() ;
        String h = String.valueOf(hour)+String.valueOf(":")+String.valueOf(min)+String.valueOf(":")+String.valueOf("00");
        android.support.v4.app.Fragment fragment = null;
        Bundle bundle = new Bundle();
        bundle.putString("Nom", Nom);
        bundle.putString("direction", direction);
        bundle.putString("etat",etat);
        bundle.putString("HA",HA);
        bundle.putString("HC",h);
        fragment = new fragmentht();
        fragment.setArguments(bundle);
        android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.user9, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
});

    return rootView ;
    }

}
