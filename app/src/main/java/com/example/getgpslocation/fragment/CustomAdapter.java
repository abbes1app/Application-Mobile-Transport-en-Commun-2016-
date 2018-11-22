package com.example.getgpslocation.fragment;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.getgpslocation.R;
import com.example.getgpslocation.model.ItemSlideMenu;
import com.example.getgpslocation.model.ViewHolder;

import java.util.List;

/**
 * Created by amgsoft-pc on 27/05/2016.
 */
public class CustomAdapter extends BaseAdapter {

    public static final int TYPE_ODD = 0;
    public static final int TYPE_EVEN = 1;
    public static final int TYPE_ODD1 = 2;
    public static final int item = 3;
    public static final int TYPE_EVEN1 = 4;
    public static final int TYPE_EVEN3 = 5;
    public static final int text = 99;
    public static final int ligne = 7;




    LayoutInflater mInflater;



    private Context context;
    private List<ItemSlideMenu> lstItem;

    @Override
    public int getViewTypeCount() {
        return 100;
    }

    @Override
    public int getItemViewType(int position) {
        return lstItem.get(position).getType();
    }


    public CustomAdapter(Context context, List<ItemSlideMenu> lstItem) {
        mInflater = LayoutInflater.from(context);
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

        int listViewItemType = getItemViewType(position);

        if (convertView == null) {

            if (listViewItemType == TYPE_EVEN) {
                convertView = mInflater.inflate(R.layout.item_sliding_menu,parent,false);
                ImageView img = (ImageView) convertView.findViewById(R.id.item_img);
                TextView tv = (TextView) convertView.findViewById(R.id.item_title);

                ItemSlideMenu item = lstItem.get(position);
                img.setImageResource(item.getImgId());
                tv.setText(item.getTitle());

            }
            if (listViewItemType == text) {
                convertView = mInflater.inflate(android.R.layout.simple_list_item_1,parent,false);

                TextView tv = (TextView) convertView.findViewById(android.R.id.text1);

                ItemSlideMenu item = lstItem.get(position);

                tv.setText(item.getTitle());

            }
            if (listViewItemType == TYPE_EVEN1) {
                convertView = mInflater.inflate(R.layout.item_sliding_me,parent,false);
                ImageView img = (ImageView) convertView.findViewById(R.id.item_img);
                TextView tv = (TextView) convertView.findViewById(R.id.item_title);

                ItemSlideMenu item = lstItem.get(position);
                img.setImageResource(item.getImgId());
                tv.setText(item.getTitle());

            }

            if (listViewItemType == TYPE_EVEN3) {
                convertView = mInflater.inflate(R.layout.item_2,parent,false);
                ImageView img = (ImageView)convertView.findViewById(R.id.item_img);
                TextView tv = (TextView)convertView.findViewById(R.id.item_title);
                TextView tk = (TextView)convertView.findViewById(R.id.item_title3);

                ItemSlideMenu item = lstItem.get(position);
                img.setImageResource(item.getImgId());
                tv.setText(item.getTitle());
                tk.setText(item.getabbes());
            }

            else if (listViewItemType == TYPE_ODD) {
                convertView = mInflater.inflate(R.layout.reseaux,parent,false);

                TextView tv = (TextView) convertView.findViewById(R.id.item_title);

                ItemSlideMenu item = lstItem.get(position);
                tv.setText(item.getTitle());



            }

            else if (listViewItemType == TYPE_ODD1) {
                convertView = mInflater.inflate(R.layout.contenu,parent,false);

                TextView tv = (TextView) convertView.findViewById(R.id.item_title);

                ItemSlideMenu item = lstItem.get(position);
                tv.setText(item.getTitle());



            }
            else if (listViewItemType == item){
                convertView = mInflater.inflate(R.layout.item_sliding_menu,parent,false);
                ImageView img = (ImageView)convertView.findViewById(R.id.item_img);
                TextView tv = (TextView)convertView.findViewById(R.id.item_title);
                TextView tk = (TextView)convertView.findViewById(R.id.item_title3);

                ItemSlideMenu item = lstItem.get(position);
                img.setImageResource(item.getImgId());
                tv.setText(item.getTitle());
                tk.setText(item.getabbes());
            }

            else if (listViewItemType == ligne){
                convertView = mInflater.inflate(R.layout.item_ligne,parent,false);
                ImageView img = (ImageView)convertView.findViewById(R.id.item_img);
                ImageView img1 = (ImageView)convertView.findViewById(R.id.item_img1);

                ItemSlideMenu item = lstItem.get(position);
                img.setImageResource(item.getImgId());
                img1.setImageResource(item.getImgId1());

            }


        }

return convertView ;

    }}



