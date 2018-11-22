package com.example.getgpslocation.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.getgpslocation.MainActivity;
import com.example.getgpslocation.R;
import com.example.getgpslocation.app.AppConfig;
import com.example.getgpslocation.app.AppController;
import com.example.getgpslocation.model.ItemSlideMenu1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

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


public class TramHor1 extends android.support.v4.app.Fragment {
    TextView abbes,stationt;
    String TheureC;
    String TheureA;
    String Tetat,TetatS,T1p,T1d;
    JSONObject jresponse99;
    String RAdio1, argo1,now;
ImageButton swap ;
    private ListView  l1tram;
    private TramAdapter adaptert1;
    private List<ItemSlideMenu1> t1;
    private ProgressDialog pDialog;
    final Date date = new Date();
    public TramHor1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tram_hor1, container, false);
        stationt = (TextView) rootView.findViewById(R.id.stationt);
        if (getArguments() != null) {
            RAdio1 = this.getArguments().getString("Radio");
            argo1 = this.getArguments().getString("list");

            stationt.setText(argo1);

            abbes = (TextView) rootView.findViewById(R.id.abbes);
            l1tram=(ListView) rootView.findViewById(R.id.l1tram);
            t1 = new ArrayList<>();
            t1.clear();
            adaptert1 = new  TramAdapter(getActivity(),t1);

            l1tram.setAdapter(adaptert1);



        }
        checkLogin(RAdio1, argo1);
swap = (ImageButton) rootView.findViewById(R.id.swap);

        swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(RAdio1.equals("Cascade1")){
                    RAdio1 = "Sidi Djilali" ;

                }
                else {
                    RAdio1 = "Cascade1" ;

                }
                t1.clear();
                adaptert1 = new  TramAdapter(getActivity(),t1);

                l1tram.setAdapter(adaptert1);
                checkLogin(RAdio1, argo1);

            }
        });
        return rootView;
    }

    private void checkLogin(final String RAdio1, final String argo1) {


        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_Tram1, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {



                try {
                    JSONObject jsonObj = new JSONObject(response);
                    JSONArray jsonArray = jsonObj.getJSONArray("tramhor");


                    for (int i = 0; i < jsonArray.length(); i++) {
                        jresponse99 = jsonArray.getJSONObject(i);
                        TheureC = jresponse99.getString("HeureC");
                        TheureA = jresponse99.getString("HeureA");
                        Tetat = jresponse99.getString("etat");
                        TetatS = jresponse99.getString("etatS");
                        T1p = jresponse99.getString("tp");
                        T1d = jresponse99.getString("td");
                        now = jresponse99.getString("now");

                        abbes.setText("premier depart : " + jsonArray.getJSONObject(0).getString("HeureC").substring(10, 16) + " - deriner depart : " + jsonArray.getJSONObject(jsonArray.length()-1).getString("HeureC").substring(10,16) );

                        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        final   Date date12;
                        final   Date date13;
                        date12 = dateFormat.parse(TheureC);
                        date13 = dateFormat.parse(now);


                        int a = Integer.parseInt(T1p);
                        int p = Integer.parseInt(T1d);

                       if(TetatS.equals("on")) {
if(date13.after(dateFormat.parse(jsonArray.getJSONObject(jsonArray.length()-1).getString("HeureC"))) ){

    List<ItemSlideMenu1> t24 = new ArrayList<>();

    t24.add(new ItemSlideMenu1(RAdio1,"Service Terminé"));

    Set<String> set = new HashSet<>();



    t1.clear();


    for (ItemSlideMenu1 item : t24) {

        if (!set.contains(item.getTitle())) { // si le title1 n'est pas encore dans le set
            t1.add(item); // on récupère l'item dans la nouvelleList
            set.add(item.getTitle()); // on stocke le title1 dans le set
        }

    }


}
                           if (TheureC.equals(TheureA)&&Tetat.equals("on") && (date12.after(date13)) && (a == 0)) {

                               t1.add(new ItemSlideMenu1(RAdio1, String.valueOf(p) + " mn"));

                           }

                           if (TheureC.equals(TheureA)&&Tetat.equals("on") && (date12.after(date13)) && (a >= 1) && (p == 0)) {


                               t1.add(new ItemSlideMenu1(RAdio1, String.valueOf(a) + " h "));

                           }

                           if (TheureC.equals(TheureA)&&Tetat.equals("on") && (date12.after(date13)) && (a >= 1) && (p > 1)) {


                               t1.add(new ItemSlideMenu1(RAdio1, String.valueOf(a + " h " + p + "mn")));

                           }


                           if (!TheureC.equals(TheureA) && Tetat.equals("on") && (date12.after(date13)) && (t1.isEmpty())) {

                               t1.add(new ItemSlideMenu1(RAdio1, "retardé"));
                           }


                           if (Tetat.equals("off") && (date12.after(date13))) {
                               t1.add(new ItemSlideMenu1(RAdio1, "le trajet est annulé"));

                           }
                           adaptert1 = new  TramAdapter(getActivity(),t1);
                       }
                        else if (TetatS.equals("off")){
                           t1.add(new ItemSlideMenu1(RAdio1, "Hors Service"));
                           Set<String> set = new HashSet<>();

                           List<ItemSlideMenu1> t74 = new ArrayList<>();

                           t74.clear();


                           for (ItemSlideMenu1 item : t1) {

                               if (!set.contains(item.getTitle())) { // si le title1 n'est pas encore dans le set
                                   t74.add(item); // on récupère l'item dans la nouvelleList
                                   set.add(item.getTitle()); // on stocke le title1 dans le set
                               }

                           }
                           adaptert1 = new  TramAdapter(getActivity(),t74);
                       }


                        l1tram.setAdapter(adaptert1);







                    }
                } catch (JSONException | ParseException e) {
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
                params.put("Radio", RAdio1);
                params.put("list", argo1);

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(strReq);


    }
}
