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
import com.example.getgpslocation.model.ItemSlideMenu;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Ligne22Tram extends android.support.v4.app.Fragment {
    private DecimalFormat df;
    private TouchImageView T2;
    private List<ItemSlideMenu> list00;

    private  CustomAdapter adapter00 ,customAdapter00;
    private ListView listview00 ;
    String tEXT00;

    public Ligne22Tram() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_ligne22_tram, container, false);
        df = new DecimalFormat("#.##");

        T2 = (TouchImageView) rootView.findViewById(R.id.T2);
        final ListView listview01 = (ListView) rootView.findViewById(R.id.lv_sliding_00);
        listview00 = (ListView) rootView.findViewById(R.id.lv_sliding_menu00);
        String[] values1 = new String[] {"Cascade2","Gare Routiere Est","Le Rocher","Benhamouda","Sidi Djilal","Wiaam"
                ,"Azouz","A.Boumediene","Sbyka","Maternité","Sidi Yacine","Petit Vichy","Quatres Horloges","Jardin"
                ,"Gare Routiere Sud","Rectorat","Institue Science Medicals","Bd Amara","Cite 20 Aout" };

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values1.length; ++i) {
            list.add(values1[i]);
        }
        final ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, list);
        listview01.setAdapter(adapter);

        list00 = new ArrayList<>();
        list00.add(new ItemSlideMenu(R.drawable.t,R.drawable.circled2,CustomAdapter.ligne));
        adapter00 = new CustomAdapter(getActivity(),list00);
        listview00.setAdapter(adapter00);






        listview01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Set title

                //item selected
                listview01.setItemChecked(position, true);
                //Replace fragment
                tEXT00 = (String) listview01.getItemAtPosition(position);

                replaceFragment(position);
                //Close menu

            }
        });
        return rootView;
    }
    private void replaceFragment(int pos) {
        android.support.v4.app.Fragment fragment = null;
        Bundle bundle = new Bundle();
        bundle.putString("Stat1", tEXT00);


        fragment = new Fragment4();

        fragment.setArguments(bundle);


        if (null != fragment) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_content91, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }}