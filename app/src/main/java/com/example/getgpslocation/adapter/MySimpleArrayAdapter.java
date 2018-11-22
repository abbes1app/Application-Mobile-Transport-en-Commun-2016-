package com.example.getgpslocation.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.getgpslocation.R;

import java.util.List;

public class MySimpleArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final List<String> values;

    public MySimpleArrayAdapter(Context context, List<String> values) {
        super(context,R.layout.rowlayout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = View.inflate(context, R.layout.rowlayout, null);
        TextView textView = (TextView) rowView.findViewById(R.id.text);

        TextView textView1 = (TextView) rowView.findViewById(R.id.item_title1);

        textView1.setText(values.get(position));
        // Change the icon for Windows and iPhone


        return rowView;
    }
}