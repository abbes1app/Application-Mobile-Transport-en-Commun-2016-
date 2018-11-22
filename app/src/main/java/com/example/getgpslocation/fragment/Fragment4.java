package com.example.getgpslocation.fragment;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.getgpslocation.GPSTracker;
import com.example.getgpslocation.R;
import com.example.getgpslocation.app.AppConfig;
import com.example.getgpslocation.model.ItemSlideMenu1;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

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


public class Fragment4 extends android.support.v4.app.Fragment implements OnMapReadyCallback,GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleMap.OnMarkerDragListener,
        GoogleMap.OnMapLongClickListener,
        View.OnClickListener {
    private GoogleMap mMap;
    private GoogleApiClient googleApiClient;
    GPSTracker gps;
    JSONObject jresponsez;
    double Longitude9;
    double Latitude9;
    String marker ;
    String marker54 = marker;
    String TheureC71;
    String TheureA71, tEXT2;
    String T1p71, T1d71, direction71, Tetat71,Tetat71S, now71;
    private TramAdapter adaptert88;
    ListView markerh;
    private List<ItemSlideMenu1> t73;
    private ProgressDialog pDialog;
    final Date date = new Date();
    List<ItemSlideMenu1> t88;
    String now1;

    public Fragment4() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment4, container, false);
        if (getArguments() != null) {
            marker = this.getArguments().getString("Stat1");}
        mMap = ((SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map)).getMap();
        markerh = (ListView) rootView.findViewById(R.id.markerh1);
       t88 = new ArrayList<>();
        t88.clear();;
        t73 = new ArrayList<>();
        t73.clear();




        googleApiClient = new GoogleApiClient.Builder(getContext())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();


        markerh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                markerh.setItemChecked(position, true);
                TextView text = (TextView) view.findViewById(R.id.item_title1);

                tEXT2 = text.getText().toString();
                replaceFragment(position);

            }
        });


        return rootView;
    }
/*

*/
    @Override
    public void onStart() {
        //     OnMapReady(mMap);
        googleApiClient.connect();
        OnMapReady(mMap);
        super.onStart();
    }
    private void replaceFragment(int pos) {
        android.support.v4.app.Fragment fragment = null;
        Bundle bundle =new Bundle();
        bundle.putString("Radio", tEXT2);
        bundle.putString("list", marker);

        fragment = new TramHor1();

        fragment.setArguments(bundle);





        if(null!=fragment) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_content54,fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }


    private void Search(final String marker) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConfig.URL_Tram14,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject jsonObj = new JSONObject(response);
                            JSONArray jsonArray = jsonObj.getJSONArray("tramhor");


                            for (int i = 0; i < jsonArray.length(); i++) {
                                jresponsez = jsonArray.getJSONObject(i);
                                Latitude9 = Double.parseDouble(jresponsez.getString("lng"));
                                Longitude9 = Double.parseDouble(jresponsez.getString("lat"));
                                Tetat71S = jresponsez.getString("etatS");

                                TheureC71 = jresponsez.getString("HeureC");
                                TheureA71 = jresponsez.getString("HeureA");
                                Tetat71 = jresponsez.getString("etat");
                                direction71 = jresponsez.getString("Direction");
                                T1p71 = jresponsez.getString("tp");
                                T1d71 = jresponsez.getString("td");
                                now71 = jresponsez.getString("now");


                                final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                final Date date12;
                                final Date date13;
                                date12 = dateFormat.parse(TheureC71);
                                date13 = dateFormat.parse(now71);


                                int a = Integer.parseInt(T1p71);
                                int p = Integer.parseInt(T1d71);


if(Tetat71S.equals("on")) {

 if ((Tetat71.equals("on") && (date12.before(date13)) )){

     t88.add(new ItemSlideMenu1(direction71,"service terminé"));
 }

    //&& (date12.before(date))
    if (Tetat71.equals("on") && (date12.after(date13)) && (a == 0)) {

        t73.add(new ItemSlideMenu1(direction71, String.valueOf(p) + " mn"));

    }

    if (Tetat71.equals("on") && (date12.after(date13)) && (a >= 1) && (p == 0)) {


        t73.add(new ItemSlideMenu1(direction71, String.valueOf(a) + " h "));

    }
    //&& (date12.before(date))
    if (Tetat71.equals("on") && (date12.after(date13)) && (a >= 1) && (p > 1)) {


        t73.add(new ItemSlideMenu1(direction71, String.valueOf(a + " h " + p + "mn")));

    }


    if (!TheureC71.equals(TheureA71) && Tetat71.equals("on") && (date12.after(date13)) && (t73.isEmpty())) {

        t73.add(new ItemSlideMenu1(direction71, "retardé"));
    }

    if (Tetat71.equals("off") && (date12.before(date13))) {
        t73.add(new ItemSlideMenu1(direction71, "le trajet est annulé"));

    }


    Set<String> set = new HashSet<>();

    List<ItemSlideMenu1> t74 = new ArrayList<>();

    t74.clear();


    for (ItemSlideMenu1 item : t73) {

        if (!set.contains(item.getTitle())) { // si le title1 n'est pas encore dans le set
            t74.add(item); // on récupère l'item dans la nouvelleList
            set.add(item.getTitle()); // on stocke le title1 dans le set
        }

    }
    if(t74.size()<2){
        for (ItemSlideMenu1 item : t88) {

            if (!set.contains(item.getTitle())) { // si le title1 n'est pas encore dans le set
                t74.add(item); // on récupère l'item dans la nouvelleList
                set.add(item.getTitle()); // on stocke le title1 dans le set
            }

        }

    }

    adaptert88 = new TramAdapter(getActivity(), t74);
}

                             else if   (Tetat71S.equals("off")){
                                    t73.add(new ItemSlideMenu1(direction71, "Hors Service"));
                                    Set<String> set = new HashSet<>();

                                    List<ItemSlideMenu1> t74 = new ArrayList<>();

                                    t74.clear();


                                    for (ItemSlideMenu1 item : t73) {

                                        if (!set.contains(item.getTitle())) { // si le title1 n'est pas encore dans le set
                                            t74.add(item); // on récupère l'item dans la nouvelleList
                                            set.add(item.getTitle()); // on stocke le title1 dans le set
                                        }

                                    }
                                    adaptert88 = new  TramAdapter(getActivity(),t74);
                                }
                                markerh.setAdapter(adaptert88);

                                moveMap();
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
                Map<String, String> params1 = new HashMap<String, String>();
                params1.put("Radio21", marker);


                return params1;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);


    }


    private void OnMapReady(final GoogleMap mMap) {

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.181002,-0.660231))
                .title("Station BD.Amara").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.181002,-0.660231))
                .title("Itma").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.199128, -0.641999))
                .title("Station BD").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.185318,-0.650397))
                .title("Agence").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.192546,-0.617908))
                .title("maternité").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.180111,-0.644376))
                .title("faculté medecine").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.189382,-0.633911))
                .title("Boulevard Larbi Tebessi").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.192989,-0.631788))
                .title("Coupole").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.201292,-0.638332))
                .title("Fac central").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.184847, -0.617871))
                .title("Stade 24 fevrier").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.182962,-0.646560))
                .title("CHU").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.180877,-0.630823))
                .title("Makam").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.183910,-0.628771))
                .title("Rue Mohamed khemisti").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.220228,-0.642793))
                .title("campus").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.215012,-0.614027))
                .title("Rocher").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.205687,-0.624565))
                .title("fac informatique").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.204890,-0.633382))
                .title("Faculté genie civil").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.185111,-0.638439))
                .title("Rue amarna").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.196326,-0.622165))
                .title("Boulevard Aissat Idir").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_96))
                .draggable(true));

        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            mMap.getUiSettings().setMapToolbarEnabled(true);

        }
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConfig.URL_Marker,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject jsonObj = new JSONObject(response);
                            JSONArray jsonArray = jsonObj.getJSONArray("markers");


                            double[][] StationTram1 = new double[jsonArray.length()][2];
                            for (int i = 0; i < jsonArray.length(); i++) {
                                jresponsez = jsonArray.getJSONObject(i);
                                StationTram1[i][0] = Double.parseDouble(jresponsez.getString("lng"));
                                StationTram1[i][1] = Double.parseDouble(jresponsez.getString("lat"));


                            }


                        } catch (JSONException e) {
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
                Map<String, String> params = new HashMap<String, String>();

                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);


        StringRequest stringRequest1 = new StringRequest(Request.Method.POST, AppConfig.URL_Marker_OFF,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject jsonObj = new JSONObject(response);
                            JSONArray jsonArray = jsonObj.getJSONArray("markers");


                            double[][] StationTram2 = new double[jsonArray.length()][3];
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jresponse1 = jsonArray.getJSONObject(i);
                                StationTram2[i][0] = Double.parseDouble(jresponse1.getString("lng"));
                                StationTram2[i][1] = Double.parseDouble(jresponse1.getString("lat"));
                                String a = (jresponse1.getString("Nom"));


                                mMap.addMarker(new MarkerOptions()
                                        .position(new LatLng(StationTram2[i][0], StationTram2[i][1]))
                                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.tram_96_)).title(a)
                                        .draggable(true));

                            }


                        } catch (JSONException e) {
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
                Map<String, String> params = new HashMap<String, String>();

                return params;
            }

        };

        RequestQueue requestQueue1 = Volley.newRequestQueue(getActivity());
        requestQueue1.add(stringRequest1);

        StringRequest stringRequest2 = new StringRequest(Request.Method.POST, AppConfig.URL_Marker,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject jsonObj = new JSONObject(response);
                            JSONArray jsonArray = jsonObj.getJSONArray("markers");

                            double[][] StationTram3 = new double[jsonArray.length()][3];
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jresponse3 = jsonArray.getJSONObject(i);
                                StationTram3[i][0] = Double.parseDouble(jresponse3.getString("lng"));
                                StationTram3[i][1] = Double.parseDouble(jresponse3.getString("lat"));
                                String a = (jresponse3.getString("Nom"));


                                mMap.addMarker(new MarkerOptions()
                                        .position(new LatLng(StationTram3[i][0], StationTram3[i][1]))
                                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.tram_48))
                                        .title(a)
                                        .draggable(true));

                            }


                        } catch (JSONException e) {
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
                Map<String, String> params = new HashMap<String, String>();

                return params;
            }

        };

        RequestQueue requestQueue2 = Volley.newRequestQueue(getActivity());
        requestQueue2.add(stringRequest2);

    }


    private void moveMap() {
        //String to display current latitude and longitude

double Latitude1 ,Longitude1;
        Latitude1 = Latitude9;
        Longitude1 = Longitude9;
        //Creating a LatLng Object to store Coordinates
        LatLng latLng = new LatLng(Latitude1, Longitude1);

        //Adding marker to map


        //Moving the camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        //Animating the camera
        mMap.animateCamera(CameraUpdateFactory.zoomTo(18));

    }


    @Override
    public void onStop() {

        super.onStop();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


    }

    @Override
    public void onConnected(Bundle bundle) {

        Search(marker);


    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onMapLongClick(LatLng latLng) {

    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }
  }