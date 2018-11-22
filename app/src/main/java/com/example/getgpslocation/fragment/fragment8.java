package com.example.getgpslocation.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.getgpslocation.R;
import com.example.getgpslocation.app.AppConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment8 extends android.support.v4.app.Fragment {
    private ProgressDialog pDialog;
    TextView nom1,email1,abbes;
    Button modifier,chmdp ;
    String nom2,name;
    boolean test = false;
    public fragment8() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_fragment8, container, false);
        chmdp = (Button) rootview.findViewById(R.id.btnmdp);

        if(this.getArguments().getString("email") != null){
            nom2 = this.getArguments().getString("email");
           test = true ;

        }
        if ((getArguments() != null)&& (test == false)) {
            nom2 = this.getArguments().getString("nom1");
        }

test = false ;
        modifier = (Button) rootview.findViewById(R.id.btnmodif);
        nom1 = (TextView) rootview.findViewById(R.id.nom1);
        email1 = (TextView) rootview.findViewById(R.id.email1);


        email1.setText(nom2);
        login6(nom2);
        pDialog = new ProgressDialog(getActivity());
        pDialog.setCancelable(false);


modifier.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        android.support.v4.app.Fragment fragment = null;
        Bundle bundle = new Bundle();
        bundle.putString("email", nom2);
        bundle.putString("name8", name);

        fragment = new profil();

        fragment.setArguments(bundle);
        android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_1, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
});


        chmdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.support.v4.app.Fragment fragment = null;
                Bundle bundle = new Bundle();
                bundle.putString("email", nom2);

                fragment = new profilmp();

                fragment.setArguments(bundle);
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_1, fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

    return  rootview ;

    }

    private void login6(final String nom2) {

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_profil, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {



                try {
                    JSONObject jsonObj = new JSONObject(response);
                    JSONArray jsonArray = jsonObj.getJSONArray("markers1");


                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jresponset = jsonArray.getJSONObject(i);
                             name = jresponset.getString("name");
                        nom1.setText(name);

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
                params.put("Radi1o", nom2);

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(strReq);


    }}