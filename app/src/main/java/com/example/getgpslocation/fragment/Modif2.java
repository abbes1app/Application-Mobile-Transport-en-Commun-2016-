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
import com.example.getgpslocation.model.ItemSlideMenu1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 */
public class Modif2 extends android.support.v4.app.Fragment  {
TextView nom9,direction9;
    Spinner heurea ;
    Button serach52;
    String ab,ac;
    ArrayAdapter<String>  adap ;
    private List<String> t1;

    public Modif2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_modif2, container, false);

        nom9 = (TextView) rootview.findViewById(R.id.nom9);
        direction9 = (TextView) rootview.findViewById(R.id.direction9);

        heurea= (Spinner)rootview.findViewById(R.id.heurea);
        serach52 = (Button) rootview.findViewById(R.id.serach52);
        t1 = new ArrayList<>();

        if (getArguments() != null) {
            ab  = this.getArguments().getString("name");
            ac  = this.getArguments().getString("direction");
            nom9.setText(ab);
            direction9.setText(ac);
        }

share(ab,ac) ;

        serach52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String HeureA = heurea.getSelectedItem().toString();
                android.support.v4.app.Fragment fragment = null;
                fragment = new Modif3();
                Bundle bundle =new Bundle();
                bundle.putString("name",ab);
                bundle.putString("direction", ac);
                bundle.putString("HeureA", HeureA);
                fragment.setArguments(bundle);
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.Modif3,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return rootview ;
    }

    private void share(final String ab, final String ac) {
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_Tram1, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {



                try {
                    JSONObject jsonObj = new JSONObject(response);
                    JSONArray jsonArray = jsonObj.getJSONArray("tramhor");


                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject  j = jsonArray.getJSONObject(i);

                       String TheureA = j.getString("HeureA");

                        t1.add(TheureA);
                        adap = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, t1);
                        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        heurea.setAdapter(adap);







                    }
                } catch (JSONException  e) {
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
                params.put("Radio", ac);
                params.put("list", ab);

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(strReq);


    }
}
