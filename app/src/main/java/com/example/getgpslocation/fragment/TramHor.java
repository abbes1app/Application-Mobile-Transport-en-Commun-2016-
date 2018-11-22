package com.example.getgpslocation.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.getgpslocation.R;
import com.example.getgpslocation.adapter.SlidingMenuAdapter;
import com.example.getgpslocation.model.ItemSlideMenu;

import java.util.ArrayList;
import java.util.List;


public class TramHor extends android.support.v4.app.Fragment {
    private List<ItemSlideMenu> listSliding2;
    private SlidingMenuAdapter adapter2;
    private ListView listViewSliding2;
    public TramHor() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tram_hor, container, false);
        listViewSliding2 = (ListView) rootView.findViewById(R.id.lv_sliding_menu2);

        listSliding2 = new ArrayList<>();
        //Add item for sliding list
        listSliding2.add(new ItemSlideMenu(R.drawable.circle1,"Cascade1","Sidi Djilai"));
        listSliding2.add(new ItemSlideMenu(R.drawable.circled2,"Cascade2","Cite 20 Aout"));


        adapter2 = new SlidingMenuAdapter(getActivity(), listSliding2);
        listViewSliding2.setAdapter(adapter2);



        listViewSliding2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Set title

                //item selected
                listViewSliding2.setItemChecked(position, true);
                //Replace fragment
                replaceFragment(position);
                //Close menu

            }
        });
        return rootView;
    }

    private void replaceFragment(int pos) {
        android.support.v4.app.Fragment fragment = null;
        switch (pos) {
            case 0:
                fragment = new Ligne1Hor();
                break;
            case 1:
                fragment = new Ligne2Hor();
                break;
        }

        if(null!=fragment) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_content1,fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }


}