package com.example.getgpslocation.fragment;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.getgpslocation.R;
import com.example.getgpslocation.model.ItemSlideMenu;
import com.example.getgpslocation.model.ItemSlideMenu1;
import java.util.List;

/**
 * Created by amgsoft-pc on 26/05/2016.
 */
public class infoAdapter extends BaseAdapter


{
    LayoutInflater mInflater;



    private Context context;
    private List<ItemSlideMenu> lstItem;

    @Override
    public int getViewTypeCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        return lstItem.get(position).getType();
    }


    public infoAdapter(Context context, List<ItemSlideMenu> lstItem) {
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

        convertView = mInflater.inflate(R.layout.infolayout, parent, false);
        ImageView img = (ImageView)convertView.findViewById(R.id.item_img);
        ImageView img1 = (ImageView)convertView.findViewById(R.id.item_img1);
        TextView tv = (TextView)convertView.findViewById(R.id.item_title3);
        ImageView img2 = (ImageView)convertView.findViewById(R.id.item_img2);

        ItemSlideMenu item = lstItem.get(position);
        img.setImageResource(item.getImgId());
        tv.setText(item.getabbes());
        img1.setImageResource(item.getImgId1());
        img2.setImageResource(item.getImgId2());

        return convertView;
    }
}

