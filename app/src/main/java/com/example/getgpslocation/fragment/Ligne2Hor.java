package com.example.getgpslocation.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.getgpslocation.R;

import org.json.JSONObject;

import java.util.ArrayList;


public class Ligne2Hor extends android.support.v4.app.Fragment {
    RadioGroup Radiogr5 ;
    RadioButton Cascade15 , Sididji5,radioButton5;
    TextView abbes25 ;
    String Radio5,argo5 ;
    private CustomAdapter customAdapter5 ;
    JSONObject jresponse995;
    private ProgressDialog pDialog5;
    public Ligne2Hor() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       final View rootView = inflater.inflate(R.layout.fragment_ligne2_hor, container, false);
       final ListView listview1 = (ListView) rootView.findViewById(R.id.Sligne2);
        Radiogr5 = (RadioGroup) rootView.findViewById(R.id.Radiogr1);
        abbes25 =(TextView) rootView.findViewById(R.id.abbes21);
        Cascade15 = (RadioButton) rootView.findViewById(R.id.Cascade2);
        Sididji5 =(RadioButton) rootView.findViewById(R.id.aout2);
        int selectedId = Radiogr5.getCheckedRadioButtonId();
        radioButton5 = (RadioButton) rootView.findViewById(selectedId);
        Radio5 = radioButton5.getText().toString();
        Cascade15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Radio5=  Cascade15.getText().toString();
            }
        });
        Sididji5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Radio5=  Sididji5.getText().toString();
            }
        });
        String[] values1 = new String[] {"Cascade2","Gare Routiere Est","Le Rocher","Benhamouda","Sidi Djilal","Wiaam"
                ,"Azouz","A.Boumediene","Sbyka","Maternité","Sidi Yacine","Petit Vichy","Quatres Horloges","Jardin"
                ,"Gare Routiere Sud","Rectorat","Institue Science Medicals","Bd Amara","Cite 20 Aout"};

        ArrayList<String> list1 = new ArrayList<String>();
        for (int i = 0; i < values1.length; ++i) {
            list1.add(values1[i]);
        }
        ArrayAdapter adapter1 = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, list1);
        listview1.setAdapter(adapter1);


        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                listview1.setItemChecked(position, true);
                argo5 = (String) listview1.getItemAtPosition(position);
                if(argo5.equals(Radio5)){
                    Toast.makeText(getActivity(), "Veillez Choisir la bonne direction",
                            Toast.LENGTH_LONG).show();
                }
                else {  //Replace fragment
                    replaceFragment(position);
                }
            }
        });


        return rootView;
    }


    private void replaceFragment(int pos) {
        android.support.v4.app.Fragment fragment = null;
        Bundle bundle =new Bundle();
        bundle.putString("Radio",Radio5);
        bundle.putString("list",argo5);

        fragment = new TramHor1();

        fragment.setArguments(bundle);





        if(null!=fragment) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_conten,fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}