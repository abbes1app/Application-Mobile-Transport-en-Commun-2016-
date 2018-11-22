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
public class tramheure extends android.support.v4.app.Fragment {
Button ajoutheure,modifheure,supheure;

    public tramheure() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View c = inflater.inflate(R.layout.fragment_tramheure, container, false);
        // Inflate the layout for this fragment
        ajoutheure = (Button) c.findViewById(R.id.ajoutheure);
        modifheure = (Button) c.findViewById(R.id.modifheure);
        supheure = (Button) c.findViewById(R.id.supheure);

        ajoutheure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.Fragment fragment = null;
                fragment = new fragmentht();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.admin22,fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        modifheure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.support.v4.app.Fragment fragment = null;
                fragment = new fragmenthtf();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.admin22,fragment);
                transaction.addToBackStack(null);
                transaction.commit();



            }
        });
        return c;
    }

}
