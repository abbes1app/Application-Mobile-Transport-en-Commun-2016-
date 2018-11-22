package com.example.getgpslocation;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.getgpslocation.adapter.SlidingMenuAdapter3;
import com.example.getgpslocation.fragment.Fragment1;
import com.example.getgpslocation.fragment.Fragment2;
import com.example.getgpslocation.fragment.Fragment3;
import com.example.getgpslocation.fragment.Fragment4;
import com.example.getgpslocation.fragment.fragment5;

import com.example.getgpslocation.fragment.fragment51;
import com.example.getgpslocation.fragment.fragment6;
import com.example.getgpslocation.fragment.fragment7;
import com.example.getgpslocation.fragment.fragment8;
import com.example.getgpslocation.fragment.fragment9;
import com.example.getgpslocation.model.ItemSlideMenu;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

	public static Bundle myBundl = new Bundle();
	private List<ItemSlideMenu> listSliding;
	private SlidingMenuAdapter3 adapter;
	private ListView listViewSliding;
	private DrawerLayout drawerLayout;
	private ActionBarDrawerToggle actionBarDrawerToggle;
	String name1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Init component
		listViewSliding = (ListView) findViewById(R.id.lv_sliding_menu);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		listSliding = new ArrayList<>();
		//Add item for sliding list
		listSliding.add(new ItemSlideMenu(R.drawable.home_96,"Accueil" ));
		listSliding.add(new ItemSlideMenu(R.drawable.clock_96,"Horaires"));
		listSliding.add(new ItemSlideMenu(R.drawable.polyline96,"Lignes"));
		listSliding.add(new ItemSlideMenu(R.drawable.circled,"Stations"));
		listSliding.add(new ItemSlideMenu(R.drawable.geo,"Autour de moi"));
		listSliding.add(new ItemSlideMenu(R.drawable.priorityy,"Info & alertes trafic"));
		listSliding.add(new ItemSlideMenu(R.drawable.security,"Tarifs"));
		listSliding.add(new ItemSlideMenu(R.drawable.stack,"Gallery"));
		listSliding.add(new ItemSlideMenu(R.drawable.user,"Mon compte"));
		listSliding.add(new ItemSlideMenu(R.drawable.message,"Contact"));
		listSliding.add(new ItemSlideMenu(R.drawable.information,"Credits"));

		adapter = new SlidingMenuAdapter3(this, listSliding);
		listViewSliding.setAdapter(adapter);

		//Display icon to open/ close sliding list
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		//Set title
		setTitle(listSliding.get(0).getTitle());
		//item selected
		listViewSliding.setItemChecked(0, true);
		//Close menu
		drawerLayout.closeDrawer(listViewSliding);

		//Display fragment 1 when start
		replaceFragment(0);
		//Hanlde on item click

		listViewSliding.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//Set title
				setTitle(listSliding.get(position).getTitle());
				//item selected
				listViewSliding.setItemChecked(position, true);

				if (position==4){
					Intent i2 = new Intent(getApplicationContext(), MapsActivity.class);
					startActivity(i2);

				}	else
				{//Replace fragment
				replaceFragment(position);
				}//Close menu
				drawerLayout.closeDrawer(listViewSliding);
			}
		});

		actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_opened, R.string.drawer_closed){

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				invalidateOptionsMenu();
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				invalidateOptionsMenu();
			}
		};

		drawerLayout.setDrawerListener(actionBarDrawerToggle);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		actionBarDrawerToggle.syncState();
	}

	//Create method replace fragment

	private void replaceFragment(int pos) {

		android.support.v4.app.Fragment fragment = null;
		switch (pos) {

			case 0:

				fragment = new Fragment1();

				break;
			case 1:
				fragment = new Fragment2();
				break;
			case 2:
				fragment = new Fragment3();
				break;
			case 3 :
				fragment = new fragment5();
				break;
			case 5 :
				fragment = new fragment51();
				break;
			case 6 :
				fragment = new fragment6();
				break;
			case 7 :
				fragment = new fragment7();
				break ;
			case 8 :
				Intent intent = getIntent();

				String name = intent.getStringExtra("nom5");
				name1 = intent.getStringExtra("nome");

				fragment = new fragment8();
				Bundle bundle =new Bundle();
				bundle.putString("nom1",name);

				fragment.setArguments(bundle);
				break ;
			case 9 :
				fragment = new fragment9();
				break;

		}

		if(null!=fragment) {
			android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
			android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
			transaction.replace(R.id.main_content,fragment);
			transaction.addToBackStack(null);
			transaction.commit();
		}
	}






}







