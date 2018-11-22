package com.example.getgpslocation.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.getgpslocation.adapter.SlidingMenuAdapter;
import com.example.getgpslocation.fragment.Fragment1;
import com.example.getgpslocation.fragment.Fragment2;
import com.example.getgpslocation.fragment.Fragment3;
import com.example.getgpslocation.fragment.Fragment4;
import com.example.getgpslocation.model.ItemSlideMenu;

import java.util.ArrayList;
import java.util.List;

import com.example.getgpslocation.R;
import com.example.getgpslocation.adapter.SlidingMenuAdapter;
import com.example.getgpslocation.model.ItemSlideMenu;

import java.util.ArrayList;
import java.util.List;


public class Train extends android.support.v4.app.Fragment {
    private List<ItemSlideMenu> listSliding1;
    private ArrayAdapter adapter1;
    String DD;
    private ListView listViewSliding1;
    public Train() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_train, container, false);
        listViewSliding1 = (ListView) rootView.findViewById(R.id.lv_sliding_menu1);
        String[] values = new String[] { "Oran", "Alger", "Tlemcen" };

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, list);
        listViewSliding1.setAdapter(adapter);


        listViewSliding1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Set title

                //item selected
                listViewSliding1.setItemChecked(position, true);
                //Replace fragment
                DD = (String) listViewSliding1.getItemAtPosition(position);

                replaceFragment(position);
                //Close menu

            }
        });
        return rootView;
    }

    private void replaceFragment(int pos) {
        android.support.v4.app.Fragment fragment = null;
        Bundle bundle = new Bundle();
        bundle.putString("Radio51", DD);


        fragment = new TrainHor();

        fragment.setArguments(bundle);


        if (null != fragment) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_content1, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }}