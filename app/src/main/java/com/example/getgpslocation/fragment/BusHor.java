package com.example.getgpslocation.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.getgpslocation.R;
import com.example.getgpslocation.adapter.SlidingMenuAdapter;
import com.example.getgpslocation.model.ItemSlideMenu;

import java.util.ArrayList;
import java.util.List;


public class BusHor extends android.support.v4.app.Fragment {
    private List<ItemSlideMenu> listSliding83;
    String arg88 ;
    private SlidingMenuAdapter adapter83;
    private ListView listViewSliding83;
    public BusHor() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final  View rootView = inflater.inflate(R.layout.fragment_bus_hor, container, false);
        listViewSliding83 = (ListView) rootView.findViewById(R.id.lv_sliding_menu7);
        listSliding83 = new ArrayList<>();
        listSliding83.add(new ItemSlideMenu(R.drawable.ligne13,"Ligne 13" , CustomAdapter.TYPE_EVEN1));
        listSliding83.add(new ItemSlideMenu(R.drawable.ligne14,"Ligne 14" , CustomAdapter.TYPE_EVEN1));
        listSliding83.add(new ItemSlideMenu(R.drawable.ligne15,"Ligne 15" , CustomAdapter.TYPE_EVEN1));
        listSliding83.add(new ItemSlideMenu(R.drawable.ligne16,"Ligne 16" , CustomAdapter.TYPE_EVEN1));
        listSliding83.add(new ItemSlideMenu(R.drawable.ligne17,"Ligne 17" , CustomAdapter.TYPE_EVEN1));


        CustomAdapter customAdapter = new CustomAdapter(getActivity(),listSliding83);
        listViewSliding83.setAdapter(customAdapter);
        return rootView;
    }
}