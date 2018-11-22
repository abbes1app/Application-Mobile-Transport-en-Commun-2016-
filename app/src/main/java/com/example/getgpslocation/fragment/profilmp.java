package com.example.getgpslocation.fragment;


import android.content.Intent;
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
import com.example.getgpslocation.MainActivity;
import com.example.getgpslocation.R;
import com.example.getgpslocation.app.AppConfig;
import com.example.getgpslocation.app.AppController;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class profilmp extends android.support.v4.app.Fragment {
EditText password,newpassword,cnpassword ;
    Button cnpass ;
String email59 ;
    public profilmp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_profilmp, container, false);
        password = (EditText) rootview.findViewById(R.id.password9);
        newpassword = (EditText) rootview.findViewById(R.id.newpassword);
        cnpassword = (EditText) rootview.findViewById(R.id.cnpassword);
        cnpass = (Button) rootview.findViewById(R.id.cnpass);
        if (getArguments() != null) {
            email59 = this.getArguments().getString("email");}

        cnpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = password.getText().toString();
                String a = newpassword.getText().toString();
                String b = cnpassword.getText().toString();

                if (!a.equals(b)){
                    Toast.makeText(getActivity(),"Verifié vos chammp",Toast.LENGTH_LONG).show();
                    newpassword.setText("");
                    cnpassword.setText("");
                    Toast.makeText(getActivity(),email59+"  "+c+"  "+a,Toast.LENGTH_LONG).show();
                }

                else
                    mdp(email59, c, a);


            }
        });



   return rootview ;
    }

    private void mdp(final String email59, final String c, final String a) {


        // Tag used to cancel the request
        String tag_string_req = "req_login";



        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.profilmp, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                if(response.equals("error")){
                    Toast.makeText(getActivity(),
                            response, Toast.LENGTH_LONG).show();
                }
                else
                {

                  Toast.makeText(getActivity(),response,Toast.LENGTH_SHORT).show();
                    password.setText("");
                    newpassword.setText("");
                    cnpassword.setText("");
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
                params.put("email",email59);
                params.put("pass",c);
                params.put("newpass",a);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }


    }


