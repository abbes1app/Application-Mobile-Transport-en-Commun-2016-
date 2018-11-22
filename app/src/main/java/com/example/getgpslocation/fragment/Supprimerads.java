package com.example.getgpslocation.fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
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

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Supprimerads extends android.support.v4.app.Fragment {
    Button Sup1 ;
    EditText noms7 ;
    Spinner spi7 ;
    ArrayAdapter<CharSequence> adaptern19 ;

    public Supprimerads() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View a= inflater.inflate(R.layout.fragment_supprimerads, container, false);

        noms7 = (EditText) a.findViewById(R.id.noms7);
        Sup1 = (Button)a.findViewById(R.id.sup1);
        spi7 = (Spinner) a.findViewById(R.id.spi7);
        adaptern19 = ArrayAdapter.createFromResource(getActivity(),
                R.array.array1, android.R.layout.simple_spinner_item);
        adaptern19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi7.setAdapter(adaptern19);

        Sup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog diaBox = AskOption();
                diaBox.show();


            }
        });
    return a;
    }


    private AlertDialog AskOption()
    {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(getActivity())
                //set message, title, and icon
                .setTitle("Delete")
                .setMessage("Do you want to Delete")
                .setIcon(R.drawable.priority)

                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        //your deleting code
                        dialog.dismiss();
             String Nom = noms7.getText().toString();
                        String type = spi7.getSelectedItem().toString();
                        search1(Nom, type);
                    }

                })



                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                })
                .create();
        return myQuittingDialogBox;

    }

    private void search1(final String nom, final String type) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";



        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.Supr1, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                if(response.equals("error")){
                    Toast.makeText(getActivity(),
                            response, Toast.LENGTH_LONG).show();
                }
                else
                {

                    Toast.makeText(getActivity(),response,Toast.LENGTH_SHORT).show();
                    noms7.setText("");

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
                params.put("Nom",nom);
                params.put("type",type);



                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

}
