package com.example.getgpslocation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.android.volley.Request;
import com.example.getgpslocation.app.AppConfig;
import com.example.getgpslocation.fragment.Ligne1Hor;
import com.example.getgpslocation.fragment.Statbus;
import com.example.getgpslocation.fragment.TramHor1;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
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
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.SphericalUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleMap.OnMarkerDragListener,
        GoogleMap.OnMapLongClickListener,
        View.OnClickListener{

    //Our Map
    private GoogleMap mMap;
    JSONObject jresponse;
    //To store longitude and latitude from map
    private double longitude;
    private double latitude;
    //From -> the first coordinate from where we need to calculate the distance
    private double Longitude1;
    private double Latitude1;




TextView markertitle ;


    //To -> the second coordinate to where we need to calculate the distance
     double toLongitude;
     double toLatitude;
    String a ;


    double[][] StationTram1,bus1;


    //Buttons

    private ImageButton buttonBus;
    private ImageButton buttontrain;
    private ImageButton buttonView;

    //Google ApiClient
    private GoogleApiClient googleApiClient;
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Initializing googleapi client
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        //Initializing views and adding onclick listeners
        buttonBus = (ImageButton) findViewById(R.id.buttonBus);
        buttontrain = (ImageButton) findViewById(R.id.buttontrain);

        buttonView = (ImageButton) findViewById(R.id.buttonView);

        buttonBus.setOnClickListener(this);
        buttontrain.setOnClickListener(this);
        buttonView.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        googleApiClient.connect();
        super.onStart();






    }

    @Override
    protected void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }


    //Getting current location
    private void getCurrentLocation() {

        //Creating a location object
        Location location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        if (location != null) {
            //Getting longitude and latitude
            Longitude1 = location.getLongitude();
            Latitude1 = location.getLatitude();

            //moving the map to location
            moveMap();
        }
    }
    //Function to move the map
    private void moveMap() {
        //String to display current latitude and longitude


        //Creating a LatLng Object to store Coordinates
        LatLng latLng = new LatLng(Latitude1, Longitude1);

        //Adding marker to map


        //Moving the camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        //Animating the camera
        mMap.animateCamera(CameraUpdateFactory.zoomTo(18));

        //Displaying current coordinates in toast

    }
    public void onSearch(View view)
    {
        EditText location_tf = (EditText)findViewById(R.id.TFaddress);
        String location = location_tf.getText().toString();
        List<Address> addressList = null;
        if(location != null || !location.equals(""))
        {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location , 1);


            } catch (IOException e) {
                e.printStackTrace();
            }

            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude() , address.getLongitude());
            
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

        }
    }

    //The parameter is the server response
    public void drawPath() {


        //Getting both the coordinate
        LatLng from = new LatLng(Latitude1,Longitude1);




        int distance = 999999999;


        for(double[] point : StationTram1) {


            LatLng to = new LatLng(point[0], point[1]);


            //Calculating the distance in meters
            int distanceLambda = (int) SphericalUtil.computeDistanceBetween(from, to);



            if (distanceLambda < distance) { // cette distance est donc plus petite que la plus petite distance déjà trouvée
                distance = distanceLambda;
                Latitude1 = point[0];
                Longitude1 = point[1];

            }

        }

        Toast.makeText(this,String.valueOf(distance+" Meters"),Toast.LENGTH_LONG).show();
        moveMap();

    }

    public void traindis() {

        LatLng from = new LatLng(Latitude1,Longitude1);

        LatLng to = new LatLng(35.199187, -0.638310);
        int distance = (int) SphericalUtil.computeDistanceBetween(from, to);

        Latitude1 = 35.199187;
        Longitude1 = -0.638310;

        Toast.makeText(this,String.valueOf(distance+" Meters"),Toast.LENGTH_LONG).show();
        moveMap();
    }


public void busdis(){
    LatLng from = new LatLng(Latitude1,Longitude1);

    double[][]   Stationbus = new double [17][2];


    Stationbus [0][0] = 35.181002 ;
    Stationbus [0][1] = -0.660231;

    Stationbus [1][0] =35.185318;
    Stationbus [1][1] =-0.650397;

    Stationbus [2][0] = 35.192546 ;
    Stationbus [2][1] = -0.617908;

    Stationbus [3][0] = 35.180111 ;
    Stationbus [3][1] = -0.644376;

    Stationbus [4][0] = 35.189382 ;
    Stationbus [4][1] = -0.633911;

    Stationbus [5][0] = 35.192989 ;
    Stationbus [5][1] = -0.631788;

    Stationbus [6][0] = 35.201292 ;
    Stationbus [6][1] = -0.638332;

    Stationbus [7][0] =  35.184847 ;
    Stationbus [7][1] = -0.617871;

    Stationbus [8][0] = 35.182962 ;
    Stationbus [8][1] = -0.646560;

    Stationbus [9][0] = 35.180877 ;
    Stationbus [9][1] = -0.630823;

    Stationbus [10][0] = 35.220228 ;
    Stationbus [10][1] = -0.642793;

    Stationbus [11][0] = 35.215012 ;
    Stationbus [11][1] = -0.614027;

    Stationbus [12][0] = 35.205687 ;
    Stationbus [12][1] = -0.624565;

    Stationbus [13][0] = 35.204890 ;
    Stationbus [13][1] = -0.633382;

    Stationbus [14][0] = 35.185111 ;
    Stationbus [14][1] = -0.638439;

    Stationbus [15][0] = 35.196326 ;
    Stationbus [15][1] = -0.622165;

    Stationbus [16][0] = 35.183910;
    Stationbus [16][1] = -0.628771;







    int distance = 999999999;


    for(double[] point : Stationbus) {


        LatLng to = new LatLng(point[0], point[1]);


        //Calculating the distance in meters
        int distanceLambda = (int) SphericalUtil.computeDistanceBetween(from, to);



        if (distanceLambda < distance) { // cette distance est donc plus petite que la plus petite distance déjà trouvée
            distance = distanceLambda;
            Latitude1 = point[0];
            Longitude1 = point[1];

        }

    }

    Toast.makeText(this,String.valueOf(distance+" Meters"),Toast.LENGTH_LONG).show();
    moveMap();


}

    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(35.199187, -0.638310))
                .title("Gare Feroviere T").icon(BitmapDescriptorFactory.fromResource(R.drawable.train_96))
                .draggable(true));

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



        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.getUiSettings().setZoomControlsEnabled(true);
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMapToolbarEnabled(true);

        }
        mMap.setOnMarkerDragListener(this);
        mMap.setOnMapLongClickListener(this);

        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
            @Override
            public boolean onMyLocationButtonClick() {
                LatLng loc = new LatLng(mMap.getMyLocation().getLatitude(), mMap.getMyLocation().getLongitude());

                Longitude1 = mMap.getMyLocation().getLongitude();
                Latitude1 = mMap.getMyLocation().getLatitude();
                Toast.makeText(
                        getApplicationContext(),
                        "votre position", Toast.LENGTH_LONG).show();


                mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(18));
                return true;
            }
        });



        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConfig.URL_Marker,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject jsonObj = new JSONObject(response);
                            JSONArray jsonArray = jsonObj.getJSONArray("markers");


                            StationTram1 = new double [jsonArray.length()][2];
                            for (int i = 0; i < jsonArray.length(); i++) {
                                jresponse = jsonArray.getJSONObject(i);
                                StationTram1[i][0]=Double.parseDouble(jresponse.getString("lng"));
                                StationTram1[i][1]=Double.parseDouble(jresponse.getString("lat"));


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

        RequestQueue requestQueue = Volley.newRequestQueue(MapsActivity.this);
        requestQueue.add(stringRequest);


        StringRequest stringRequest1 = new StringRequest(Request.Method.POST, AppConfig.URL_Marker_OFF,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject jsonObj = new JSONObject(response);
                            JSONArray jsonArray = jsonObj.getJSONArray("markers");


                            double[][]   StationTram2 = new double [jsonArray.length()][3];
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jresponse1 = jsonArray.getJSONObject(i);
                                StationTram2[i][0]=Double.parseDouble(jresponse1.getString("lng"));
                                StationTram2[i][1]=Double.parseDouble(jresponse1.getString("lat"));
                                String a =(jresponse1.getString("Nom"));


                                mMap.addMarker(new MarkerOptions()
                                        .position(new LatLng(StationTram2[i][0], StationTram2[i][1]))
                                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.tram_96_)).title("Station "+a+" Hors Service")
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

        RequestQueue requestQueue1 = Volley.newRequestQueue(MapsActivity.this);
        requestQueue1.add(stringRequest1);

        StringRequest stringRequest2 = new StringRequest(Request.Method.POST, AppConfig.URL_Marker,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject jsonObj = new JSONObject(response);
                            JSONArray jsonArray = jsonObj.getJSONArray("markers");

                            double[][]   StationTram3 = new double [jsonArray.length()][3];
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jresponse3 = jsonArray.getJSONObject(i);
                                StationTram3[i][0]=Double.parseDouble(jresponse3.getString("lng"));
                                StationTram3[i][1]=Double.parseDouble(jresponse3.getString("lat"));
                                String a =(jresponse3.getString("Nom"));




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

        RequestQueue requestQueue2 = Volley.newRequestQueue(MapsActivity.this);
        requestQueue2.add(stringRequest2);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

            @Override
            public boolean onMarkerClick(Marker arg0) {
               String a = arg0.getTitle() ;
                double b = arg0.getPosition().longitude;
                double c = arg0.getPosition().latitude;

                if (ContextCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {
                    mMap.getUiSettings().setMapToolbarEnabled(true);

                }

                BottomSheetDialogFragment bsdFragment =
                        MiBottomSheetDialogFragment.newInstance();
                Bundle bundle =new Bundle();
                bundle.putString("Radio99",a);
                bundle.putDouble("tlat",c);
                bundle.putDouble("tlang",b);
                bsdFragment.setArguments(bundle);

                bsdFragment.show(
                        MapsActivity.this.getSupportFragmentManager(), "BSDialog");

                return false;
            }

        });


    }





    @Override
    public void onConnected(Bundle bundle) {
       gps = new GPSTracker(MapsActivity.this);

        if(gps.canGetLocation()) {
            Latitude1 = gps.getLatitude();
            Longitude1 = gps.getLongitude();

            moveMap();
        } else {
            gps.showSettingsAlert();
        }
   }

    @Override
    public void onConnectionSuspended(int i) {

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
        //Getting the coordinates
        latitude = marker.getPosition().latitude;
        longitude = marker.getPosition().longitude;

        //Moving the map
        moveMap();
    }

    @Override
    public void onClick(View v) {
        if(v==buttonView){ drawPath();}

        if (v==buttontrain){
            traindis();}
        if (v==buttonBus){
            busdis();}
        }

}



