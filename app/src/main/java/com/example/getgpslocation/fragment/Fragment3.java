package com.example.getgpslocation.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.getgpslocation.MainActivity;
import com.example.getgpslocation.R;
import com.example.getgpslocation.adapter.SlidingMenuAdapter;
import com.example.getgpslocation.model.ItemSlideMenu;

import java.util.ArrayList;
import java.util.List;


public class Fragment3 extends android.support.v4.app.Fragment {
    private List<ItemSlideMenu> listSliding3;
String arg88 ;
    EditText recherche;
    private SlidingMenuAdapter adapter3;
    CustomAdapter customAdapter;
    private ListView listViewSliding3;
    public Fragment3() {
}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment3, container, false);
recherche = (EditText) rootView.findViewById(R.id.recherche);
        recherche.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                //MainActivity.this.adapter.getFilter().filter(cs);


            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

        listViewSliding3 = (ListView) rootView.findViewById(R.id.lv_sliding_menu3);
        listSliding3 = new ArrayList<>();
        //Add item for sliding list
      /*  listSliding3.add(new ItemSlideMenu("TRAM " , CustomAdapter.TYPE_ODD));
        listSliding3.add(new ItemSlideMenu(R.drawable.circle1,"Cascade1","Sidi Djilai",CustomAdapter.item ));
        listSliding3.add(new ItemSlideMenu(R.drawable.circled2,"Cascade2","Cite 20 Aout",CustomAdapter.item ));
        */listSliding3.add(new ItemSlideMenu("Endroit " , CustomAdapter.TYPE_ODD));
        listSliding3.add(new ItemSlideMenu(R.drawable.theatre_mask_100,"Theatre" , CustomAdapter.TYPE_EVEN1));
        listSliding3.add(new ItemSlideMenu(R.drawable.bar_100,"Bar" , CustomAdapter.TYPE_EVEN1));
        listSliding3.add(new ItemSlideMenu(R.drawable.restaurant_100,"Resto" , CustomAdapter.TYPE_EVEN1));
        listSliding3.add(new ItemSlideMenu(R.drawable.boite,"Boite" , CustomAdapter.TYPE_EVEN1));
        listSliding3.add(new ItemSlideMenu(R.drawable.museum_100,"Musée" , CustomAdapter.TYPE_EVEN1));


        customAdapter = new CustomAdapter(getActivity(),listSliding3);
        listViewSliding3.setAdapter(customAdapter);

        listViewSliding3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Set title

                //item selected
                listViewSliding3.setItemChecked(position, true);

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
            case 1:

                fragment = new Ligne1Tram();
                break;
            case 2:
                fragment = new Ligne2Tram();
                break;
        }

        if(null!=fragment) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_content2,fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
    }
