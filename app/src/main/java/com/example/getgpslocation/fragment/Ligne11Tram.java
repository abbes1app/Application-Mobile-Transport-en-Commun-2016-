package com.example.getgpslocation.fragment;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.getgpslocation.R;
import com.example.getgpslocation.model.ItemSlideMenu;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class Ligne11Tram extends android.support.v4.app.Fragment {
    private DecimalFormat df;
    private TouchImageView T1;
    private List<ItemSlideMenu> list79;

private  CustomAdapter adapter79 ,customAdapter1;
    private ListView listview79;
    String tEXT9;
    public Ligne11Tram() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ligne11_tram, container, false);
        df = new DecimalFormat("#.##");

        T1 = (TouchImageView) rootView.findViewById(R.id.T1);
        final ListView   listview99 = (ListView) rootView.findViewById(R.id.lv_sliding_1);
        listview79 = (ListView) rootView.findViewById(R.id.lv_sliding_menu5);
        String[] values1 = new String[] {"Cascade1","Gare Routiere Est","Le Rocher","Benhamouda","Cite AAdl Benhamouda","Gare routiere nord"
                ,"Gare feroviere","Campus","Mexique","Faculte de Droit","Sidi Djilali" };

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values1.length; ++i) {
            list.add(values1[i]);
        }
        final ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, list);
        listview99.setAdapter(adapter);

        list79 = new ArrayList<>();
        list79.add(new ItemSlideMenu(R.drawable.t,R.drawable.circle1,CustomAdapter.ligne));
        adapter79 = new CustomAdapter(getActivity(),list79);
        listview79.setAdapter(adapter79);






        listview99.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Set title

                //item selected
                listview99.setItemChecked(position, true);
                //Replace fragment
                tEXT9 = (String) listview99.getItemAtPosition(position);

                replaceFragment(position);
                //Close menu

            }
        });
        return rootView;
    }
    private void replaceFragment(int pos) {
        android.support.v4.app.Fragment fragment = null;
        Bundle bundle = new Bundle();
        bundle.putString("Stat1", tEXT9);


        fragment = new Fragment4();

        fragment.setArguments(bundle);


        if (null != fragment) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_content61, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }}