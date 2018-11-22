package com.example.getgpslocation.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
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
import com.example.getgpslocation.model.ItemSlideMenu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Infotrafictram extends android.support.v4.app.Fragment {
    TextView maj,direction1,direction2;
    private List<ItemSlideMenu> listinfot;
    private infoAdapter1 adapterinfo;
    private ListView listinfo;
    String name1,name2;
    private ProgressDialog pDialog;
    public Infotrafictram() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_infotrafictram, container, false);
        listinfo=(ListView) rootView.findViewById(R.id.info1);
        listinfot = new ArrayList<>();
        maj = (TextView) rootView.findViewById(R.id.datemaj2);
        direction1 = (TextView) rootView.findViewById(R.id.direction1);
        direction2 = (TextView) rootView.findViewById(R.id.direction2);
        pDialog = new ProgressDialog(getActivity());
        pDialog.setCancelable(false);

         name1 = direction1.getText().toString();
         name2 = direction2.getText().toString();
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_infodate, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {



                try {
                    JSONObject jsonObj = new JSONObject(response);
                    JSONArray jsonArray = jsonObj.getJSONArray("markerss");


                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject   jresponset = jsonArray.getJSONObject(i);
                        String  date1 = jresponset.getString("date");

                        maj.setText(date1);

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


                return params;
            }

        };

        pDialog.setMessage("Logging in ...");
        showDialog();

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(strReq);

        StringRequest strReq1 = new StringRequest(Request.Method.POST,
                AppConfig.URL_Traminfo1, new Response.Listener<String>() {



            @Override
            public void onResponse(String response) {
                hideDialog();


                try {
                    JSONObject jsonObj = new JSONObject(response);
                    JSONArray jsonArray = jsonObj.getJSONArray("markers");


                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject   jresponset = jsonArray.getJSONObject(i);
                        String  tnom = jresponset.getString("Nom");
                        String    typet = jresponset.getString("type");
                        String    info = jresponset.getString("tetat");


                        if(info.equals("Normal")) {


                                listinfot.add(new ItemSlideMenu( R.drawable.g,"le trafic est Normal sur cette ligne"));


                            }





                        else if (info.equals("perturbe")) {


                            listinfot.add(new ItemSlideMenu( R.drawable.o,typet));
                        }


                        else if (info.equals("interrompu")) {


                                listinfot.add(new ItemSlideMenu(R.drawable.r,typet));

                        }







                        adapterinfo = new infoAdapter1(getActivity(), listinfot);
                        listinfo.setAdapter(adapterinfo);
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

                params.put("direction1",name1);
                params.put("direction2",name2);
                return params;
            }

        };

        RequestQueue requestQueue1 = Volley.newRequestQueue(getActivity());
        requestQueue1.add(strReq1);

        return rootView ;
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
