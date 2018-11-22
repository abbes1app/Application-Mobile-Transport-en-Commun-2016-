package com.example.getgpslocation.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.getgpslocation.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Ligne1Hor extends android.support.v4.app.Fragment {
    RadioGroup Radiogr ;
    RadioButton Cascade1 , Sididji,radioButton;
    TextView abbes2 ;
    String Radio,argo ;

    private CustomAdapter customAdapter ;
    JSONObject jresponse99;
    private ProgressDialog pDialog;
public Ligne1Hor() {
        }

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_ligne1_hor, container, false);
    final ListView listview = (ListView) rootView.findViewById(R.id.Sligne1);
    Radiogr = (RadioGroup) rootView.findViewById(R.id.Radiogr);
abbes2 =(TextView) rootView.findViewById(R.id.abbes2);
    Cascade1 = (RadioButton) rootView.findViewById(R.id.Cascade1);
    Sididji =(RadioButton) rootView.findViewById(R.id.SidiDji);
    int selectedId = Radiogr.getCheckedRadioButtonId();
    radioButton = (RadioButton) rootView.findViewById(selectedId);
    Radio = radioButton.getText().toString();
Cascade1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      Radio=  Cascade1.getText().toString();
    }
});
    Sididji.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Radio=  Sididji.getText().toString();
        }
    });

    String[] values = new String[] {"Cascade1","Gare Routiere Est","Le Rocher","Benhamouda","Cite AAdl Benhamouda","Gare routiere nord"
            ,"Gare feroviere","Campus","Mexique","Faculte de Droit","Sidi Djilali" };

    final ArrayList<String> list1 = new ArrayList<String>();

    for (int i = 0; i < values.length; ++i) {
        list1.add(values[i]);
    }
    final ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, list1);
    listview.setAdapter(adapter);



listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        listview.setItemChecked(position, true);
        argo = (String) listview.getItemAtPosition(position);
       if(argo.equals(Radio)){
    Toast.makeText(getActivity(), "Veillez Choisir la bonne direction",
            Toast.LENGTH_LONG).show();
}
      else {  //Replace fragment
    replaceFragment(position);
}
    }
});


        return rootView;
        }


    private void replaceFragment(int pos) {
        android.support.v4.app.Fragment fragment = null;
                Bundle bundle =new Bundle();
                bundle.putString("Radio",Radio);
                bundle.putString("list",argo);

                fragment = new TramHor1();

                fragment.setArguments(bundle);





        if(null!=fragment) {
            android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_content99,fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
        }