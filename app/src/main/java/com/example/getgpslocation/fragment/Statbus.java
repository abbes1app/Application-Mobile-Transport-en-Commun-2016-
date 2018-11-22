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
public class Statbus extends android.support.v4.app.Fragment {
    private ListView listview49;
    String D15 ;

    public Statbus() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_statbus, container, false);
        listview49 = (ListView) rootView.findViewById(R.id.lv_slib);
        String[] values = new String[] {"ITMA"
                ,"agence","maternité","faculté medecine","Boulevard Larbi Tebessi","Coupole","Fac central","Stade 24 fevrier","CHU","Makam","Rue Mohamed khemisti","Campus","rocher","Fac d’informatique","Faculté genie civil","Rue amarna"
                ,"Boulevard Aissat Idir" };
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, list);
        listview49.setAdapter(adapter);

        listview49.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Set title

                //item selected
                listview49.setItemChecked(position, true);
                //Replace fragment
                D15 = (String) listview49.getItemAtPosition(position);

                replaceFragment(position);
                //Close menu

            }
        });
        return rootView;
    }
    private void replaceFragment(int pos) {
        android.support.v4.app.Fragment fragment = null;
        Bundle bundle = new Bundle();
        bundle.putString("Stat1", D15);


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