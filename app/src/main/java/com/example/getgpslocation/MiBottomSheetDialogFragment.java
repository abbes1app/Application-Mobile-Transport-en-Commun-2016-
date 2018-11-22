package com.example.getgpslocation;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.widget.AdapterView;
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
import com.example.getgpslocation.app.AppConfig;
import com.example.getgpslocation.fragment.TramAdapter;
import com.example.getgpslocation.fragment.TramHor1;
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


public class MiBottomSheetDialogFragment extends BottomSheetDialogFragment {
String markertit,direct1 ;
    TextView abbes,stationt;
    double hlat,hlang ;
    String TheureC1,art;
    String TheureA1,tEXT;
    String Tetat1,T1p1,T1d1,direction1;
    JSONObject jresponse991;
    String now1;
    private ListView markhor;
    private TramAdapter adaptert78;
    private List<ItemSlideMenu1> t71,t98;
    private ProgressDialog pDialog;
    final Date date = new Date();
    TextView markertitle;
    private String TetatS;

    static MiBottomSheetDialogFragment newInstance() {
        return new MiBottomSheetDialogFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bs_dialog_fragment, container, false);
        markertitle = (TextView) rootView.findViewById(R.id.markertitle);
        markertitle.setText("Prochain passage");
        markhor=(ListView) rootView.findViewById(R.id.markhor);


        if (getArguments() != null) {
            markertit = this.getArguments().getString("Radio99");
            hlang = this.getArguments().getDouble("tlang");
            hlat =  this.getArguments().getDouble("tlat");

        }

if (markertit.equals("Gare Feroviere T"))
{   t98 = new ArrayList<>();
    t98.clear();
    t71 = new ArrayList<>();
t71.clear();
    checkLogin1(markertit);

}
    else{

    t98 = new ArrayList<>();
    t98.clear();
    t71 = new ArrayList<>();
    t71.clear();
    checkLogin(hlat, hlang);}



        markhor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                markhor.setItemChecked(position, true);
                TextView text = (TextView) view.findViewById(R.id.item_title1);

                tEXT = text.getText().toString();


            }
        });

        return rootView;
    }
    private void checkLogin1(final String markertit ) {

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_Tram19, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {



                try {
                    JSONObject jsonObj = new JSONObject(response);
                    JSONArray jsonArray = jsonObj.getJSONArray("tramhor1");


                    for (int i = 0; i < jsonArray.length(); i++) {
                        jresponse991 = jsonArray.getJSONObject(i);
                        TheureC1 = jresponse991.getString("HeureC");
                        TheureA1 = jresponse991.getString("HeureA");
                        Tetat1 = jresponse991.getString("etat");
                        TetatS = jresponse991.getString("etatS");
                        direction1 = jresponse991.getString("Direction");
                        T1p1 = jresponse991.getString("tp");
                        T1d1 = jresponse991.getString("td");
                        now1 = jresponse991.getString("now");






                        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        final Date date12,date18;

                        date12 = dateFormat.parse(TheureC1);

                        date18 = dateFormat.parse(now1);


                        int a = Integer.parseInt(T1p1);
                        int p = Integer.parseInt(T1d1);







                        if(TetatS.equals("on")) {
                            if (Tetat1.equals("on")&& (date12.before(date18))  ){

                                t98.add(new ItemSlideMenu1(direction1,"Service terminé"));

                            }

                            if( Tetat1.equals("on")&& (date12.after(date18))  ){

                                t71.add(new ItemSlideMenu1(direction1, TheureC1.substring(10)));

                            }





                        Set<String> set = new HashSet<>();

                        List<ItemSlideMenu1> t72 = new ArrayList<>();

                        t72.clear();


                        for(ItemSlideMenu1 item : t71) {

                            if( !set.contains(item.getTitle()))
                            { // si le title1 n'est pas encore dans le set
                                t72.add(item); // on récupère l'item dans la nouvelleList
                                set.add(item.getTitle()); // on stocke le title1 dans le set
                            }

                        }

if(t72.size()<3){

    for(ItemSlideMenu1 item : t98) {

        if( !set.contains(item.getTitle()))
        { // si le title1 n'est pas encore dans le set
            t72.add(item); // on récupère l'item dans la nouvelleList
            set.add(item.getTitle()); // on stocke le title1 dans le set
        }

    }

}
                        adaptert78 = new TramAdapter(getActivity(),t72);
                        }


                        else if (TetatS.equals("off")){
                            t71.add(new ItemSlideMenu1(direction1, "Hors Service"));
                            Set<String> set = new HashSet<>();

                            List<ItemSlideMenu1> t75 = new ArrayList<>();

                            t75.clear();


                            for (ItemSlideMenu1 item : t71) {

                                if (!set.contains(item.getTitle())) { // si le title1 n'est pas encore dans le set
                                    t75.add(item); // on récupère l'item dans la nouvelleList
                                    set.add(item.getTitle()); // on stocke le title1 dans le set
                                }

                            }
                            adaptert78 = new  TramAdapter(getActivity(),t75);
                        }





                        markhor.setAdapter(adaptert78);





                    }
                //pDialog.dismiss();

            } catch (ParseException | JSONException e) {
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
                params.put("Radio41", markertit);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(strReq);


    }

    private void checkLogin(final Double hlat, final Double hlang ) {

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_Tram12, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jsonObj = new JSONObject(response);
                    JSONArray jsonArray = jsonObj.getJSONArray("tramhor");


                    for (int i = 0; i < jsonArray.length(); i++) {
                        jresponse991 = jsonArray.getJSONObject(i);
                        TheureC1 = jresponse991.getString("HeureC");
                        TheureA1 = jresponse991.getString("HeureA");
                        Tetat1 = jresponse991.getString("etat");
                        TetatS = jresponse991.getString("etatS");
                        direction1 = jresponse991.getString("Direction");
                        T1p1 = jresponse991.getString("tp");
                        T1d1 = jresponse991.getString("td");
                        now1 = jresponse991.getString("now");


                        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        final Date date12;
                        final Date date13;
                        date12 = dateFormat.parse(TheureC1);
                        date13 = dateFormat.parse(now1);


                        int a = Integer.parseInt(T1p1);
                        int p = Integer.parseInt(T1d1);




                         if ((TetatS.equals("on"))) {


                             if (Tetat1.equals("on") && (date12.before(date13)) ) {

                                 t98.add(new ItemSlideMenu1(direction1, "Service terminé"));

                             }
                                if (Tetat1.equals("on") && (date12.after(date13)) && (a == 0)) {

                                    t71.add(new ItemSlideMenu1(direction1, String.valueOf(p) + " mn"));

                                }

                                if (Tetat1.equals("on") && (date12.after(date13)) && (a >= 1) && (p == 0)) {


                                    t71.add(new ItemSlideMenu1(direction1, String.valueOf(a) + " h "));

                                }

                                if (Tetat1.equals("on") && (date12.after(date13)) && (a >= 1) && (p > 1)) {


                                    t71.add(new ItemSlideMenu1(direction1, String.valueOf(a + " h " + p + "mn")));

                                }


                                if (!TheureC1.equals(TheureA1) && Tetat1.equals("on") && (date12.after(date13)) && (t71.isEmpty())) {

                                    t71.add(new ItemSlideMenu1(direction1, "retardé"));
                                }


                                if (Tetat1.equals("off") && (date12.before(date13))) {
                                    t71.add(new ItemSlideMenu1(direction1, "le trajet est annulé"));

                                }


                                Set<String> set = new HashSet<>();

                                List<ItemSlideMenu1> t72 = new ArrayList<>();

                                t72.clear();


                                for (ItemSlideMenu1 item : t71) {

                                    if (!set.contains(item.getTitle())) { // si le title1 n'est pas encore dans le set
                                        t72.add(item); // on récupère l'item dans la nouvelleList
                                        set.add(item.getTitle()); // on stocke le title1 dans le set
                                    }

                                }

if(t72.size()<2){
    for (ItemSlideMenu1 item : t98) {

        if (!set.contains(item.getTitle())) { // si le title1 n'est pas encore dans le set
            t72.add(item); // on récupère l'item dans la nouvelleList
            set.add(item.getTitle()); // on stocke le title1 dans le set
        }

    }

}
                                adaptert78 = new TramAdapter(getActivity(), t72);
                            }


                        else if (TetatS.equals("off")) {
                                t71.add(new ItemSlideMenu1(direction1, "Hors Service"));
                                Set<String> set = new HashSet<>();

                                List<ItemSlideMenu1> t75 = new ArrayList<>();

                                t75.clear();


                                for (ItemSlideMenu1 item : t71) {

                                    if (!set.contains(item.getTitle())) { // si le title1 n'est pas encore dans le set
                                        t75.add(item); // on récupère l'item dans la nouvelleList
                                        set.add(item.getTitle()); // on stocke le title1 dans le set
                                    }

                                }
                                adaptert78 = new TramAdapter(getActivity(), t75);
                            }


                            markhor.setAdapter(adaptert78);


                        }
                        //pDialog.dismiss();

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
                params.put("Radio11", String.valueOf(hlang));
                params.put("Radio31", String.valueOf(hlat));
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(strReq);


    }




}




