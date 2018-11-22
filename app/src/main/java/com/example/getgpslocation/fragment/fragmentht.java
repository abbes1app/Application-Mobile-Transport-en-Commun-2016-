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
public class fragmentht extends android.support.v4.app.Fragment {

EditText nomst1,dir,etatt,HC,HA;
    CheckBox checkHC, checkHA ;
    Button Ajouter;
    public fragmentht() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        final String datenow = dateFormat.format(date);
       View rootView = inflater.inflate(R.layout.fragment_fragmentht, container, false);
    nomst1 = (EditText) rootView.findViewById(R.id.nomst1);
        dir= (EditText)rootView.findViewById(R.id.direction);
        etatt = (EditText)rootView.findViewById(R.id.etatt);
        HC = (EditText)rootView.findViewById(R.id.HC);
        HA = (EditText)rootView.findViewById(R.id.HA);
Ajouter = (Button) rootView.findViewById(R.id.ajouterh);
Ajouter.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String name = nomst1.getText().toString();
        String direction  = dir.getText().toString();
        String HeureC = datenow+" "+ HC.getText().toString();
        String HeureA = datenow+" "+ HA.getText().toString();
        String etat = etatt.getText().toString();

        if(!name.isEmpty()&&!direction.isEmpty()&&!HeureC.isEmpty()&&!HeureA.isEmpty()&&!etat.isEmpty()){
            Ajouterh(name,direction,HeureC,HeureA,etat);
        }
else {
            Toast.makeText(getActivity(),"Verifie vos champs", Toast.LENGTH_LONG).show();
        }}
});
        if (getArguments() != null) {
            nomst1.setText(this.getArguments().getString("Nom"));}
        if (getArguments() != null) {
            dir.setText(this.getArguments().getString("direction"));}
        if (getArguments() != null) {
            etatt.setText(this.getArguments().getString("etat"));}
        if (getArguments() != null) {
            HA.setText(this.getArguments().getString("HA"));}
        if (getArguments() != null) {
            HC.setText( this.getArguments().getString("HC"));}

        checkHC = (CheckBox)rootView.findViewById(R.id.checkHC);
        checkHA = (CheckBox)rootView.findViewById(R.id.checkHA);


checkHC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (checkHC.isChecked()){


            android.support.v4.app.Fragment fragment = null;
            Bundle bundle = new Bundle();
            bundle.putString("Nom", nomst1.getText().toString());
            bundle.putString("direction", dir.getText().toString());
            bundle.putString("etat", etatt.getText().toString());
            bundle.putString("HA", HA.getText().toString());
            fragment = new fragmentahtr();
            fragment.setArguments(bundle);
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.admin71,fragment);
            transaction.addToBackStack(null);
            transaction.commit();

        }
    }
});
        checkHA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkHA.isChecked()){


                    android.support.v4.app.Fragment fragment = null;
                    Bundle bundle = new Bundle();
                    bundle.putString("Nom", nomst1.getText().toString());
                    bundle.putString("direction", dir.getText().toString());
                    bundle.putString("etat", etatt.getText().toString());
                    bundle.putString("HC", HC.getText().toString());
                    fragment = new heuread();
                    fragment.setArguments(bundle);
                    android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                    android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.admin71,fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                }
            }
        });



        return rootView;
    }

    private void Ajouterh(final String name, final String direction, final String heureC, final String heureA, final String etat) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";



        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.Ajouterh, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                if(response.equals("error")){
                    Toast.makeText(getActivity(),
                            response, Toast.LENGTH_LONG).show();
                }
                else
                {

                    Toast.makeText(getActivity(),response,Toast.LENGTH_SHORT).show();

                    nomst1.setText("");
                    dir.setText("");
                    etatt.setText("");
                    HC.setText("");
                    HA.setText("");


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


                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

}
