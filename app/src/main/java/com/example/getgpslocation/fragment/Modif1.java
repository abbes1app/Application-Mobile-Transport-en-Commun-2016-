package com.example.getgpslocation.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.getgpslocation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Modif1 extends android.support.v4.app.Fragment {

    ArrayAdapter<CharSequence> adaptern2;
    Button modif1 ;
    EditText noms1 ;
    Spinner spi ;
    ArrayAdapter<CharSequence> adaptern9 ;
    public Modif1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View b = inflater.inflate(R.layout.fragment_modif1, container, false);
        noms1 = (EditText) b.findViewById(R.id.noms1);
        modif1 = (Button)b.findViewById(R.id.modif1);
        spi = (Spinner) b.findViewById(R.id.spi);
        adaptern9 = ArrayAdapter.createFromResource(getActivity(),
                R.array.array1, android.R.layout.simple_spinner_item);
        adaptern9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi.setAdapter(adaptern9);
        modif1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((spi.getSelectedItemPosition() == 0) ){
                    Toast.makeText(getActivity(), "Verifiez vos champs", Toast.LENGTH_LONG).show();
                }
                else {
                String name= noms1.getText().toString();
                    String type = spi.getSelectedItem().toString();
                    android.support.v4.app.Fragment fragment = null;
                    fragment = new Modifierads();
                    Bundle bundle =new Bundle();
                    bundle.putString("nom1",name);
                    bundle.putString("type1", type);

                    fragment.setArguments(bundle);
                    android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                    android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.main8,fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

            }}
        });


        return b ;
    }

    private void Modifier(String name, String type) {

    }

}
