package com.example.getgpslocation.fragment;


import android.app.ProgressDialog;
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
import com.example.getgpslocation.adapter.SlidingMenuAdapter;
import com.example.getgpslocation.app.AppConfig;
import com.example.getgpslocation.model.ItemSlideMenu;
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
public class fragment51 extends android.support.v4.app.Fragment {
    private List<ItemSlideMenu> listinfot;
    private infoAdapter adapterinfo;
    private ListView listinfo;
TextView datemaj;
    private ProgressDialog pDialog;
    public fragment51() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.fragment_fragment51, container, false);
        listinfo=(ListView) rootView.findViewById(R.id.listinfo);
        listinfot = new ArrayList<>();
        datemaj = (TextView) rootView.findViewById(R.id.datemaj);
        pDialog = new ProgressDialog(getActivity());
        pDialog.setCancelable(false);

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

                    datemaj.setText(date1);

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
                AppConfig.URL_Traminfo, new Response.Listener<String>() {



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

    if (tnom.equals("T1")) {

        listinfot.add(new ItemSlideMenu(R.drawable.t, R.drawable.circle1, "trafic " + info, R.drawable.g));


    }
    if (tnom.equals("T2")) {

        listinfot.add(new ItemSlideMenu(R.drawable.t, R.drawable.circled2, "trafic " + info, R.drawable.g));


    }
    if (tnom.equals("B13")) {

        listinfot.add(new ItemSlideMenu(R.drawable.b, R.drawable.ligne13, "trafic " + info, R.drawable.g));


    }

    if (tnom.equals("B14")) {

        listinfot.add(new ItemSlideMenu(R.drawable.b, R.drawable.ligne14, "trafic " + info, R.drawable.g));


    }
    if (tnom.equals("B15")) {

        listinfot.add(new ItemSlideMenu(R.drawable.b, R.drawable.ligne15, "trafic " + info, R.drawable.g));


    }
    if (tnom.equals("B16")) {

        listinfot.add(new ItemSlideMenu(R.drawable.b, R.drawable.ligne16, "trafic " + info, R.drawable.g));


    }

    if (tnom.equals("B17")) {

        listinfot.add(new ItemSlideMenu(R.drawable.b, R.drawable.ligne17, "trafic " + info, R.drawable.g));


    }


}


else if (info.equals("perturbe")) {

    if (tnom.equals("T1")) {

        listinfot.add(new ItemSlideMenu(R.drawable.t, R.drawable.circle1, "trafic " + info, R.drawable.o));


    }
    if (tnom.equals("T2")) {

        listinfot.add(new ItemSlideMenu(R.drawable.t, R.drawable.circled2, "trafic " + info, R.drawable.o));


    }
    if (tnom.equals("B13")) {

        listinfot.add(new ItemSlideMenu(R.drawable.b, R.drawable.ligne13, "trafic " + info, R.drawable.o));


    }

    if (tnom.equals("B14")) {

        listinfot.add(new ItemSlideMenu(R.drawable.b, R.drawable.ligne14, "trafic " + info, R.drawable.o));


    }
    if (tnom.equals("B15")) {

        listinfot.add(new ItemSlideMenu(R.drawable.b, R.drawable.ligne15, "trafic " + info, R.drawable.o));


    }
    if (tnom.equals("B16")) {

        listinfot.add(new ItemSlideMenu(R.drawable.b, R.drawable.ligne16, "trafic " + info, R.drawable.o));


    }

    if (tnom.equals("B17")) {

        listinfot.add(new ItemSlideMenu(R.drawable.b, R.drawable.ligne17, "trafic " + info, R.drawable.o));


    }


}


else if (info.equals("interrompu")) {

    if (tnom.equals("T1")) {

        listinfot.add(new ItemSlideMenu(R.drawable.t, R.drawable.circle1, "trafic " + info, R.drawable.r));


    }
    if (tnom.equals("T2")) {

        listinfot.add(new ItemSlideMenu(R.drawable.t, R.drawable.circled2, "trafic " + info, R.drawable.r));


    }
    if (tnom.equals("B13")) {

        listinfot.add(new ItemSlideMenu(R.drawable.b, R.drawable.ligne13, "trafic " + info, R.drawable.r));


    }

    if (tnom.equals("B14")) {

        listinfot.add(new ItemSlideMenu(R.drawable.b, R.drawable.ligne14, "trafic " + info, R.drawable.r));


    }
    if (tnom.equals("B15")) {

        listinfot.add(new ItemSlideMenu(R.drawable.b, R.drawable.ligne15, "trafic " + info, R.drawable.r));


    }
    if (tnom.equals("B16")) {

        listinfot.add(new ItemSlideMenu(R.drawable.b, R.drawable.ligne16, "trafic " + info, R.drawable.r));


    }

    if (tnom.equals("B17")) {

        listinfot.add(new ItemSlideMenu(R.drawable.b, R.drawable.ligne17, "trafic " + info, R.drawable.r));


    }


}





                        Set<String> set = new HashSet<>();

                        List<ItemSlideMenu> t74 = new ArrayList<>();

                        t74.clear();


                        for (ItemSlideMenu item : listinfot) {

                            if (!set.contains(String.valueOf(item.getImgId1()))) { // si le title1 n'est pas encore dans le set
                                t74.add(item); // on récupère l'item dans la nouvelleList
                                set.add(String.valueOf(item.getImgId1())); // on stocke le title1 dans le set
                            }

                        }

                        adapterinfo = new infoAdapter(getActivity(), t74);
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
