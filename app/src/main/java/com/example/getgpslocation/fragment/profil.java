package com.example.getgpslocation.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.getgpslocation.MainActivity;
import com.example.getgpslocation.R;
import com.example.getgpslocation.activity.LoginActivity;
import com.example.getgpslocation.app.AppConfig;
import com.example.getgpslocation.app.AppController;
import com.example.getgpslocation.helper.SQLiteHandler;
import com.example.getgpslocation.helper.SessionManager;
import com.example.getgpslocation.model.ItemSlideMenu1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class profil extends android.support.v4.app.Fragment {
String email3,name7,msname,msemail ;
    EditText nom33 ,email33 ;
    Button confirmer , chmdp ;
    private ProgressDialog pDialog;
    private SessionManager session;
    private SQLiteHandler db;

    public profil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootView = inflater.inflate(R.layout.fragment_profil, container, false);

        if (getArguments() != null) {
            email3 = this.getArguments().getString("email");
            name7 =  this.getArguments().getString("name8");
        }

        nom33 = (EditText) rootView.findViewById(R.id.mname);
        email33 = (EditText) rootView.findViewById(R.id.memail);
        confirmer = (Button) rootView.findViewById(R.id.btnmodif1);
        nom33.setText(name7);
        email33.setText(email3);


        // Progress dialog
        pDialog = new ProgressDialog(getActivity());
        pDialog.setCancelable(false);

        // Session manager
        session = new SessionManager(getActivity());

        // SQLite database handler
        db = new SQLiteHandler(getActivity());

confirmer.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        msname = nom33.getText().toString();
        msemail = email33.getText().toString() ;
        confirmer(msname,msemail);
    }
});




    return rootView ;
    }

    private void confirmer(final String msname, final String msemail) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";



        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.profil, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

            if(response.equals("error")){
                Toast.makeText(getActivity(),
                       response, Toast.LENGTH_LONG).show();
            }
else
            {
                Intent intent = new Intent(getActivity(),
                        MainActivity.class);
                intent.putExtra("nom5", msemail);
                intent.putExtra("nome", response);

                startActivity(intent);
            }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getActivity(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", msname);
                params.put("email", msemail);
                params.put("email1", email3);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}