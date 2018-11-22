package com.example.getgpslocation.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.getgpslocation.R;
import com.example.getgpslocation.app.AppConfig;
import com.example.getgpslocation.app.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Modif3 extends android.support.v4.app.Fragment {
EditText dnom, ddirection,dheurec,dheurea,detat ;
    Button modifd;
    String a,b,c;

    public Modif3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_modif3, container, false);
    dnom = (EditText) rootView.findViewById(R.id.dnom);
        ddirection = (EditText) rootView.findViewById(R.id.ddirection);
        dheurec = (EditText) rootView.findViewById(R.id.dheurec);
        dheurea = (EditText) rootView.findViewById(R.id.dheurea);
        detat = (EditText) rootView.findViewById(R.id.detat);
        modifd = (Button) rootView.findViewById(R.id.modifd);

        if (getArguments() != null) {
            a =(this.getArguments().getString("name"));
            b = (this.getArguments().getString("direction"));
           c =(this.getArguments().getString("HeureA"));
            sear(a,b,c);
        }
        dnom.setText(a);
        ddirection.setText(b);
        dheurea.setText(c);
modifd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String Nom = dnom.getText().toString();
        String Direction =ddirection.getText().toString();
        String HeureA = dheurea.getText().toString();
        String  HeureC = dheurec.getText().toString();
        String etat = detat.getText().toString();

        if(!Nom.isEmpty()&&!Direction.isEmpty()&&!HeureA.isEmpty()&&!HeureC.isEmpty()&&!etat.isEmpty()){
            mod(Nom,Direction,HeureA,HeureC,etat,a,b);
        }else{
            Toast.makeText(getActivity(),"Verifiez vos champs",Toast.LENGTH_LONG).show();
        }
    }
});
        return rootView ;
    }

    private void mod(final String Nom, final String Direction, final String HeureA, final String HeureC, final String etat, final String a, final String b) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";



        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.ModifS7, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                if(response.equals("error")){
                    Toast.makeText(getActivity(),
                            response, Toast.LENGTH_LONG).show();
                }
                else
                {

                    Toast.makeText(getActivity(),response,Toast.LENGTH_SHORT).show();



dnom.setText("");
                    ddirection.setText("");
                    dheurec.setText("");
                    dheurea.setText("");
                    detat.setText("");


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
                params.put("Direction",Direction);
                params.put("HeureA",HeureA);
                params.put("HeureC",HeureC);
                params.put("etat",etat);
                params.put("Nom1",a);
                params.put("Direction1",b);


                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }


    private void sear(final String a, final String b, final String c) {
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_Tram5, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {



                try {
                    JSONObject jsonObj = new JSONObject(response);
                    JSONArray jsonArray = jsonObj.getJSONArray("tramhor");


                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject  j = jsonArray.getJSONObject(i);

                        dheurec.setText(j.getString("HeureC"));
                        detat.setText(j.getString("etat"));








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
                params.put("Radio",b);
                params.put("list",a);
                params.put("list1",c);

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(strReq);


    }
}
