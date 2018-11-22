package com.example.getgpslocation.model;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by amgsoft-pc on 27/05/2016.
 */
public class ViewHolder {

        TextView text;
    ImageView image ;

        public ViewHolder(TextView text) {
            this.text = text;
        }

    public ViewHolder(ImageView image , TextView text){
        this.text = text ;
        this.image = image ;
    }

        public TextView getText() {
            return text;
        }


        public void setText(TextView text) {
            this.text = text;
        }

    public ImageView getImage(){
        return image ;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
}

