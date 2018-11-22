package com.example.getgpslocation.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.getgpslocation.R;
import com.example.getgpslocation.app.AppConfig;
import com.example.getgpslocation.app.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Modifierads extends android.support.v4.app.Fragment {

    ArrayAdapter<CharSequence> adaptern1,adaptern11;
    EditText nomst1,latst1,lngst1;
    Spinner spinner2 ,spinner3;
    Button Modif ;
    JSONObject    jresponsemm ;
    String aa,bb ;
    public Modifierads() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View a = inflater.inflate(R.layout.fragment_modifierads, container, false);
        nomst1 = (EditText) a.findViewById(R.id.nomst1);
        latst1 = (EditText) a.findViewById(R.id.latst1);
        lngst1 = (EditText) a.findViewById(R.id.lngst1);
        Modif = (Button)a.findViewById(R.id.Modif);
        spinner2 = (Spinner) a.findViewById(R.id.spinner2);
        spinner3 = (Spinner) a.findViewById(R.id.spinner3);
        adaptern1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.array, android.R.layout.simple_spinner_item);
        adaptern1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adaptern1);
        adaptern11 = ArrayAdapter.createFromResource(getActivity(),
                R.array.array1, android.R.layout.simple_spinner_item);
        adaptern11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adaptern11);

        if (getArguments() != null) {
          aa  = this.getArguments().getString("nom1");
            bb  = this.getArguments().getString("type1");

        }

        search(aa,bb);

        Modif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((spinner3.getSelectedItemPosition() == 0) ||(spinner2.getSelectedItemPosition() == 0)){
                    Toast.makeText(getActivity(), "Verifiez vos champs", Toast.LENGTH_LONG).show();
                }
                else {
                    String name = nomst1.getText().toString();
                    String lat = latst1.getText().toString();
                    String lng = lngst1.getText().toString();
                    String etat = spinner2.getSelectedItem().toString();
                    String type = spinner3.getSelectedItem().toString();

                    Ajouter(name, lat, lng, etat, type,aa,bb);
                }
            }
        });

        return  a;






    }

    private void search(final String aa, final String bb) {

        // Tag used to cancel the request
        String tag_string_req = "req_login";



        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.ModifS1, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObj = new JSONObject(response);
                    JSONArray jsonArray = jsonObj.getJSONArray("tramhor");


                    for (int i = 0; i < jsonArray.length(); i++) {
                        jresponsemm = jsonArray.getJSONObject(i);

                        String nom = jresponsemm.getString("Nom");
                        String lat = jresponsemm.getString("lat");
                        String lng = jresponsemm.getString("lng");
                        String etat = jresponsemm.getString("etatS");
                        String type = jresponsemm.getString("type");

                        nomst1.setText(nom);
                        latst1.setText(lat);
                         lngst1.setText(lng);
                        if(etat.equals("on")) {
                            spinner2.setSelection(1);
                        }
                        else{
                            spinner2.setSelection(2);}

                        if(type.equals("tram")){
                            spinner3.setSelection(1);}
                        else {
                            spinner3.setSelection(1);
                        }


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //pDialog.dismiss();

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
                params.put("Nom",aa);
                params.put("type",bb);



                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }



    private void Ajouter(final String name, final String lat, final String lng, final String etat, final String type, final String aa, final String bb) {


        // Tag used to cancel the request
        String tag_string_req = "req_login";



        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.ModifS, new Response.Listener<String>() {

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
                    latst1.setText("");
                    lngst1.setText("");
                    spinner2.setSelection(0);
                    spinner3.setSelection(0);



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
                params.put("lat",lat);
                params.put("lng",lng);
                params.put("etatS",etat);
                params.put("type",type);
                params.put("Nom1",aa);
                params.put("type1",bb);


                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

}
