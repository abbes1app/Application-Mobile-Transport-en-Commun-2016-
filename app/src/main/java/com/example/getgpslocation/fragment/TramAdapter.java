package com.example.getgpslocation.fragment;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.getgpslocation.R;
import com.example.getgpslocation.model.ItemSlideMenu1;
import java.util.List;

/**
 * Created by amgsoft-pc on 26/05/2016.
 */
public class TramAdapter extends BaseAdapter
{

    private Context context;
    private List<ItemSlideMenu1> lstItem;

    public TramAdapter(Context context, List<ItemSlideMenu1> lstItem) {
        this.context = context;
        this.lstItem = lstItem;
    }


    @Override
    public int getCount() {
        return lstItem.size();
    }

    @Override
    public Object getItem(int position) {
        return lstItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(context, R.layout.tramlayout, null);
        TextView tv = (TextView)v.findViewById(R.id.item_title1);
        TextView tv1 = (TextView)v.findViewById(R.id.item_title2);

        ItemSlideMenu1 item = lstItem.get(position);
        tv.setText(item.getTitle());
        tv1.setText(item.getTitle1());
        return v;
    }
}

