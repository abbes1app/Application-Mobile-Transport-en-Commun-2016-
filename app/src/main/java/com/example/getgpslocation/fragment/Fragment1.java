package com.example.getgpslocation.fragment;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.getgpslocation.GPSTracker;
import com.example.getgpslocation.Main2Activity;
import com.example.getgpslocation.MainActivity;
import com.example.getgpslocation.MapsActivity;
import com.example.getgpslocation.R;
import com.example.getgpslocation.helper.SQLiteHandler;
import com.example.getgpslocation.helper.SessionManager;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.HashMap;

public class Fragment1 extends android.support.v4.app.Fragment {

    Button btnShowLocation;
    Button mapslocation;
    Button thor,info ;

    GPSTracker gps;

    private TextView txtName;
    private TextView txtEmail;
    private Button btnLogout;

    private DecimalFormat df1;
    private TouchImageView kk;
    private SQLiteHandler db;
    String a ;
    private SessionManager session;
    public Fragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1, container, false);

        df1 = new DecimalFormat("#.##");

       // kk = () rootView.findViewById(R.id.kk);
        mapslocation = (Button) rootView.findViewById(R.id.mapslocation);
thor = (Button) rootView.findViewById(R.id.horairesall);
        info = (Button) rootView.findViewById(R.id.infot);

        txtName = (TextView) rootView.findViewById(R.id.name);
        txtEmail = (TextView) rootView.findViewById(R.id.email);
        btnLogout = (Button) rootView.findViewById(R.id.btnLogout);

// SqLite database handler
        db = new SQLiteHandler(getContext());

        // session manager
        session = new SessionManager(getContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }

        // Fetching user details from SQLite
        HashMap<String, String> user = db.getUserDetails();

        final String name = user.get("name");
        String email = user.get("email");

        // Displaying the user details on the screen
        txtName.setText(name);
        txtEmail.setText(email);



        // Logout button click event
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });

        mapslocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1 = new Intent(getActivity(), MapsActivity.class);
                startActivity(i1);

            }
        });

thor.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        getActivity().setTitle("Horaires");
        android.support.v4.app.Fragment fragment = null;
        fragment = new Fragment2();
        android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_content, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
});

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().setTitle(info.getText().toString());

                android.support.v4.app.Fragment fragment = null;
                fragment = new fragment51();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_content, fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });



        return rootView;
    }




    /**
     * Logging out the user. Will set isLoggedIn flag to false in shared
     * preferences Clears the user data from sqlite users table
     * */
    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(getActivity(),Main2Activity.class);
        startActivity(intent);
        getActivity().finish();
    }



}

