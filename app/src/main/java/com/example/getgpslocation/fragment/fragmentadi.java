package com.example.getgpslocation.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
public class fragmentadi extends android.support.v4.app.Fragment {
EditText nomi , typei,etati,dir1,dir2;
        Button ajouteri;

    public fragmentadi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview  =inflater.inflate(R.layout.fragment_fragmentadi, container, false);
    nomi =(EditText) rootview.findViewById(R.id.nomi);
        typei =(EditText) rootview.findViewById(R.id.typei);
        etati =(EditText) rootview.findViewById(R.id.etati);
        dir1 =(EditText) rootview.findViewById(R.id.dir1);
        dir2 =(EditText) rootview.findViewById(R.id.dir2);
        ajouteri = (Button)rootview.findViewById(R.id.ajoteri);

        ajouteri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nom =nomi.getText().toString();
                String type = typei.getText().toString();
                String Direction1 = dir1.getText().toString();
                String Direction2 = dir2.getText().toString();
                String etat = etati.getText().toString();
                if(!Nom.isEmpty()&&!type.isEmpty()&&!Direction1.isEmpty()&&!Direction2.isEmpty()&&!etat.isEmpty()){
                    ab(Nom,type,Direction1,Direction2,etat );
                }else{
                    Toast.makeText(getActivity(),"Verifiez vos champs",Toast.LENGTH_LONG).show();
                }
            }
        });
        return rootview;
    }

    private void ab(final String Nom, final String type, final String Direction1, final String Direction2, final String etat) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";



        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.AjouterSi, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                if(response.equals("error")){
                    Toast.makeText(getActivity(),
                            response, Toast.LENGTH_LONG).show();
                }
                else
                {

                    Toast.makeText(getActivity(),response,Toast.LENGTH_SHORT).show();

                    nomi.setText("");
                    typei.setText("");
                    etati.setText("");
                    dir1.setText("");
                    dir2.setText("");


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
                params.put("Nom",Nom);
                params.put("type",type);
                params.put("Direction1",Direction1);
                params.put("Direction2",Direction2);
                params.put("etat",etat);


                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

}
