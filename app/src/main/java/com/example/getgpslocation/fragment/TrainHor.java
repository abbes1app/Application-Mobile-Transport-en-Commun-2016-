package com.example.getgpslocation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;



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
import java.util.List;
import java.util.Map;


public class TrainHor  extends android.support.v4.app.Fragment {
    String HeureAR;
    String heureC;
    String heureA;
    String etat ;
    JSONObject jresponse2;

    String td,tp,D1 ;
   private ListView  list9;
   private ListViewAdapter adapter9;
   private List<ItemSlideMenu1> r;
    TextView  date1 ,direction9;
    public TrainHor() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_train_hor, container, false);

        if (getArguments() != null) {
            D1 = this.getArguments().getString("Radio51");}
        list9=(ListView) rootView.findViewById(R.id.listView9);
        r = new ArrayList<>();

     checkLogin(D1);
        date1 = (TextView) rootView.findViewById(R.id.date);
        direction9 = (TextView) rootView.findViewById(R.id.direction9);
        direction9.setText(D1);

        return rootView;
    }



    private void checkLogin(final String D1) {

    StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConfig.URL_Train_Oran,
            new Response.Listener<String>() {


                @Override
                public void onResponse(String response) {

                    try {

                        JSONObject jsonObj = new JSONObject(response);
                        JSONArray jsonArray = jsonObj.getJSONArray("trainhor");



                        for (int i = 0; i < jsonArray.length(); i++) {
                            jresponse2 = jsonArray.getJSONObject(i);
                            heureC = jresponse2.getString("HeureC");
                            heureA =jresponse2.getString("HeureA");
                            etat = jresponse2.getString("etat") ;
                            HeureAR = jresponse2.getString("HeureAR");
                            td = jresponse2.getString("td") ;
                            tp = jresponse2.getString("tp") ;

                            date1.setText("premier depart : " + jsonArray.getJSONObject(0).getString("HeureC").substring(10, 16) + " - deriner depart : " + jsonArray.getJSONObject(jsonArray.length()-1).getString("HeureC").substring(10,16) );

                            final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            final Date date = new Date();


                            final   Date date12;
                            date12 = dateFormat.parse(heureA);

                            int a = Integer.parseInt(td);
                            int p = Integer.parseInt(tp);

                            //&& (date12.before(date))
                            if(heureC.equals(heureA) && etat.equals("on")&& (date12.after(date))  ){

                                r.add(new ItemSlideMenu1(heureC.substring(10), HeureAR.substring(10)));

                            }

                            if (!heureC.equals(heureA) && etat.equals("on")&& (a == 0)&& (date12.after(date))) {

                                String b = " \n retard de : ";
                                r.add(new ItemSlideMenu1(heureC.substring(10) + b + p + " mn",HeureAR.substring(10)));
                            }

                            if (!heureC.equals(heureA) && etat.equals("on")&& (a > 0)&& (date12.after(date))){


                                String b = " \n retard de :";
                                r.add(new ItemSlideMenu1(heureC.substring(10) + b + " "+a+ " h et " + p + " mn",HeureAR.substring(10)));

                            }



                            if (etat.equals("off")&& (date12.after(date))){
                                r.add(new ItemSlideMenu1(heureC.substring(10) ,"le trajet est annulé"));

                            }


                            adapter9 = new  ListViewAdapter(getActivity(),r);

                            list9.setAdapter(adapter9);


                        }





                    } catch (JSONException | ParseException e) {
                        e.printStackTrace();
                    }
                    //pDialog.dismiss();

                }

            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            }) {
        @Override
        protected Map<String, String> getParams() {
            // Posting parameters to login url
            Map<String, String> params = new HashMap<String, String>();
            params.put("Radio51", D1);


            return params;
        }

    };

    RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
    requestQueue.add(stringRequest);


}}