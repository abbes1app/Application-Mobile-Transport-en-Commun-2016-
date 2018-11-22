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

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Ajouterads extends android.support.v4.app.Fragment {
    ArrayAdapter<CharSequence> adaptern,adaptern1;
EditText nomst,latst,lngst;
    Spinner spinner ,spinner1;
    Button Ajout ;
    public Ajouterads() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View a= inflater.inflate(R.layout.fragment_ajouterads, container, false);

        nomst = (EditText) a.findViewById(R.id.nomst);
        latst = (EditText) a.findViewById(R.id.latst);
        lngst = (EditText) a.findViewById(R.id.lngst);
        Ajout = (Button)a.findViewById(R.id.Ajout);
        spinner = (Spinner) a.findViewById(R.id.spinner);
        spinner1 = (Spinner) a.findViewById(R.id.spinner1);
        adaptern = ArrayAdapter.createFromResource(getActivity(),
                R.array.array, android.R.layout.simple_spinner_item);
        adaptern.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptern);
        adaptern1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.array1, android.R.layout.simple_spinner_item);
        adaptern1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adaptern1);

        Ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if((spinner1.getSelectedItemPosition() == 0) ||(spinner.getSelectedItemPosition() == 0)){
    Toast.makeText(getActivity(),"Verifiez vos champs",Toast.LENGTH_LONG).show();
}
                else {
    String name = nomst.getText().toString();
    String lat = latst.getText().toString();
    String lng = lngst.getText().toString();
    String etat = spinner.getSelectedItem().toString();
    String type = spinner1.getSelectedItem().toString();

    Ajouter(name, lat, lng, etat, type);
}
            }
        });

    return  a;






    }

    private void Ajouter(final String name, final String lat, final String lng, final String etat, final String type) {


        // Tag used to cancel the request
        String tag_string_req = "req_login";



        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.AjouterS, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                if(response.equals("error")){
                    Toast.makeText(getActivity(),
                            response, Toast.LENGTH_LONG).show();
                }
                else
                {

                    Toast.makeText(getActivity(),response,Toast.LENGTH_SHORT).show();

                    nomst.setText("");
                     latst.setText("");
                     lngst.setText("");
                   spinner.setSelection(0);
                   spinner1.setSelection(0);



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


                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

}
