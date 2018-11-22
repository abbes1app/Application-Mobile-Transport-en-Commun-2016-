package com.example.getgpslocation.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.getgpslocation.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Stattram extends android.support.v4.app.Fragment {
    private ListView listview79;
String D5 ;
    public Stattram() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView =inflater.inflate(R.layout.fragment_stattram, container, false);
         listview79 = (ListView) rootView.findViewById(R.id.lv_sli);

        String[] values = new String[] {"Gare Routiere Est","Le Rocher","Benhamouda","Cite AAdl Benhamouda","Gare routiere nord"
                ,"Gare feroviere","Campus","Mexique","Faculte de Droit","Sidi Djilali","Gare Routiere Est","Le Rocher","Benhamouda","Sidi Djilal","Wiaam"
                ,"Azouz","A.Boumediene","Sbyka","Maternité","Sidi Yacine","Petit Vichy","Quatres Horloges","Jardin"
                ,"Gare Routiere Sud","Rectorat","Institue Science Medicals","Bd Amara" };

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, list);
        listview79.setAdapter(adapter);

        listview79.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Set title

                //item selected
                listview79.setItemChecked(position, true);
                //Replace fragment
                D5 = (String) listview79.getItemAtPosition(position);

                replaceFragment(position);
                //Close menu

            }
        });
        return rootView;
    }
    private void replaceFragment(int pos) {
        android.support.v4.app.Fragment fragment = null;
        Bundle bundle = new Bundle();
        bundle.putString("Stat1", D5);


        fragment = new Fragment4();

        fragment.setArguments(bundle);


        if (null != fragment) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_content53, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }}