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
public class trainheure extends android.support.v4.app.Fragment {

    Button ajoutheuret,modifheuret,supheuret;
    public trainheure() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View c = inflater.inflate(R.layout.fragment_trainheure, container, false);
        ajoutheuret = (Button) c.findViewById(R.id.ajoutheuret);
        modifheuret = (Button) c.findViewById(R.id.modifheuret);
        supheuret = (Button) c.findViewById(R.id.supheuret);

        ajoutheuret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.Fragment fragment = null;
                fragment = new fragmenthb();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.admin00, fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        return c;
    }
}