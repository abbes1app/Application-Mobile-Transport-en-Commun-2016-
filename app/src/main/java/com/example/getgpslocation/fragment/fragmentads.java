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
public class fragmentads extends android.support.v4.app.Fragment {
Button Ajouter,Modifier,Supprimer;

    public fragmentads() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View a= inflater.inflate(R.layout.fragment_fragmentads, container, false);

        Ajouter = (Button) a.findViewById(R.id.ajouterstat);
        Modifier = (Button) a.findViewById(R.id.modifierstat);
        Supprimer = (Button) a.findViewById(R.id.supprimerstat);

        Ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.support.v4.app.Fragment fragment = null;
                fragment = new Ajouterads();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.rstat,fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        Supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.support.v4.app.Fragment fragment = null;
                fragment = new Supprimerads();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.rstat,fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        Modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.support.v4.app.Fragment fragment = null;
                fragment = new Modif1();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.rstat,fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });



    return a;
    }

}
