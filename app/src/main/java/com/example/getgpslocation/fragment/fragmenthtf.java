package com.example.getgpslocation.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.getgpslocation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmenthtf extends android.support.v4.app.Fragment {

EditText stnom,stdirection;
    Button hsearch ;
    public fragmenthtf() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragmenthtf, container, false);
   stnom = (EditText)rootView.findViewById(R.id.stnom);
        stdirection = (EditText) rootView.findViewById(R.id.stdirection);
        hsearch = (Button) rootView.findViewById(R.id.hserach);
   hsearch.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
          String name = stnom.getText().toString();
           String direction = stdirection.getText().toString();
           android.support.v4.app.Fragment fragment = null;
           fragment = new Modif2();
           Bundle bundle =new Bundle();
           bundle.putString("name",name);
           bundle.putString("direction", direction);

           fragment.setArguments(bundle);
           android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
           android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
           transaction.replace(R.id.modifuse,fragment);
           transaction.addToBackStack(null);
           transaction.commit();
       }
   });

    return rootView ;
    }

}
