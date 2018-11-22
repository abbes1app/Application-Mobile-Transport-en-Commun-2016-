package com.example.getgpslocation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.getgpslocation.fragment.fragment9;
import com.example.getgpslocation.fragment.fragmentadh;
import com.example.getgpslocation.fragment.fragmentadi;
import com.example.getgpslocation.fragment.fragmentads;

public class Main33Activity extends AppCompatActivity {
Button adminstat,adminhor,admintrafic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main33);


    adminstat = (Button) findViewById(R.id.adminstat);
        adminhor = (Button) findViewById(R.id.adminhor);
        admintrafic = (Button) findViewById(R.id.admintrafic);


             adminstat.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     android.support.v4.app.Fragment fragment = null;
                     fragment = new fragmentads();
                     android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                     android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                     transaction.replace(R.id.admin1,fragment);
                     transaction.addToBackStack(null);
                     transaction.commit();

                 }
             });

        adminhor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.Fragment fragment = null;
                fragment = new fragmentadh();
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.admin1,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        admintrafic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.Fragment fragment = null;
                fragment = new fragmentadi();
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.admin1,fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });


    }
}
