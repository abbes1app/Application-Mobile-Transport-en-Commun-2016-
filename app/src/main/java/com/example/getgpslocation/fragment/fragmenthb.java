package com.example.getgpslocation.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.getgpslocation.R;
import com.example.getgpslocation.app.AppConfig;
import com.example.getgpslocation.app.AppController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmenthb extends android.support.v4.app.Fragment {

    EditText nomst11,dir11,etatt11,HC11,HA11,heurear;
    CheckBox checkHC11, checkHA11,checkHr ;
    Button Ajouter11;
    public fragmenthb() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_fragmenthb, container, false);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        final String datenow = dateFormat.format(date);
        nomst11 = (EditText) rootView.findViewById(R.id.nomst11);
        dir11= (EditText)rootView.findViewById(R.id.direction11);
        etatt11 = (EditText)rootView.findViewById(R.id.etatt11);
        heurear = (EditText)rootView.findViewById(R.id.heurear);
        HC11 = (EditText)rootView.findViewById(R.id.HC11);
        HA11 = (EditText)rootView.findViewById(R.id.HA11);
        Ajouter11 = (Button) rootView.findViewById(R.id.ajouterh11);
        Ajouter11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nomst11.getText().toString();
                String direction  = dir11.getText().toString();
                String HeureC = datenow+" "+ HC11.getText().toString();
                String HeureA = datenow+" "+ HA11.getText().toString();
                String etat = etatt11.getText().toString();
                String HeureAR = datenow+" "+heurear.getText().toString();

                if(!name.isEmpty()&&!direction.isEmpty()&&!HeureC.isEmpty()&&!HeureA.isEmpty()&&!etat.isEmpty()&&!HeureAR.isEmpty()){
                    Ajouterh11(name, direction, HeureC, HeureA,etat,HeureAR);
               //Toast.makeText(getActivity(),name+" "+direction+" "+HeureC+" "+HeureA+" "+etat+" "+HeureAR,Toast.LENGTH_LONG).show();

                }

                else {
                    Toast.makeText(getActivity(), "Verifie vos champs", Toast.LENGTH_LONG).show();
                }}
        });
        if (getArguments() != null) {
            nomst11.setText(this.getArguments().getString("Nom"));}
        if (getArguments() != null) {
            dir11.setText(this.getArguments().getString("direction"));}
        if (getArguments() != null) {
            etatt11.setText(this.getArguments().getString("etat"));}
        if (getArguments() != null) {
            HA11.setText(this.getArguments().getString("HA"));}
        if (getArguments() != null) {
            HC11.setText( this.getArguments().getString("HC"));}
        if (getArguments() != null) {
            heurear.setText(this.getArguments().getString("heurear"));}

        checkHC11 = (CheckBox)rootView.findViewById(R.id.checkHC11);
        checkHA11 = (CheckBox)rootView.findViewById(R.id.checkHA11);
        checkHr = (CheckBox)rootView.findViewById(R.id.checkHr);


        checkHC11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkHC11.isChecked()){


                    android.support.v4.app.Fragment fragment = null;
                    Bundle bundle = new Bundle();
                    bundle.putString("Nom", nomst11.getText().toString());
                    bundle.putString("direction", dir11.getText().toString());
                    bundle.putString("etat", etatt11.getText().toString());
                    bundle.putString("HA", HA11.getText().toString());
                    bundle.putString("heurear", heurear.getText().toString());
                    fragment = new fragmentahtr1();
                    fragment.setArguments(bundle);
                    android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                    android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.admin81,fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                }
            }
        });
        checkHA11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkHA11.isChecked()){


                    android.support.v4.app.Fragment fragment = null;
                    Bundle bundle = new Bundle();
                    bundle.putString("Nom", nomst11.getText().toString());
                    bundle.putString("direction", dir11.getText().toString());
                    bundle.putString("etat", etatt11.getText().toString());
                    bundle.putString("HC", HC11.getText().toString());
                    bundle.putString("heurear", heurear.getText().toString());
                    fragment = new heuread1();
                    fragment.setArguments(bundle);
                    android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                    android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.admin81,fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                }
            }
        });
        checkHr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkHr.isChecked()){


                    android.support.v4.app.Fragment fragment = null;
                    Bundle bundle = new Bundle();
                    bundle.putString("Nom", nomst11.getText().toString());
                    bundle.putString("direction", dir11.getText().toString());
                    bundle.putString("etat", etatt11.getText().toString());
                    bundle.putString("HC", HC11.getText().toString());
                    bundle.putString("HA", HA11.getText().toString());
                    fragment = new heuread2();
                    fragment.setArguments(bundle);
                    android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                    android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.admin81,fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                }
            }
        });



        return rootView;
    }
    private void Ajouterh11(final String name, final String direction, final String heureC, final String heureA, final String etat, final String HeureAR) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";



        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.Ajouterht, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                if(response.equals("error")){
                    Toast.makeText(getActivity(),
                            response, Toast.LENGTH_LONG).show();
                }
                else
                {

                    Toast.makeText(getActivity(),response,Toast.LENGTH_SHORT).show();


                    dir11.setText("");
                    etatt11.setText("");
                    HC11.setText("");
                    HA11.setText("");
                    heurear.setText("");

                }



            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getActivity(),
                        error.getMessage(), Toast.LENGTH_LONG).show();

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("Nom",name);
                params.put("Direction",direction);
                params.put("HeureC",heureC);
                params.put("HeureA",heureA);
                params.put("etat",etat);
                params.put("HeureAR",HeureAR);
                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

}

