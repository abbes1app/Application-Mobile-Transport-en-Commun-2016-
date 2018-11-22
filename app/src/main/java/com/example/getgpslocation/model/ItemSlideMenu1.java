package com.example.getgpslocation.model;

/**
 * Created by amgsoft-pc on 26/05/2016.
 */
public class ItemSlideMenu1 {

    private int imgId,imgId1,imgId2;
    private String title,abbes;
    private String title1 ;
    public ItemSlideMenu1(String title, String title1) {
        this.title = title;
        this.title1 = title1;
    }

    public ItemSlideMenu1(int imgId,int imgId1,String abbes,int imgId2) {
        this.imgId = imgId;
        this.imgId1 = imgId1;
        this.abbes = abbes;
        this.imgId2 = imgId2;
    }


    public String getTitle() {
        return title;
    }
    public String getTitle1() {
        return title1;
    }


    public void setTitle(String title,String title1) {
        this.title = title;
        this.title1 = title1;
        this.abbes = abbes;
    }

    public int getImgId2() {

        return imgId2;
    }
    public int getImgId1() {

        return imgId1;
    }

    public int getImgId() {

        return imgId;
    }

    public void setImgId(int imgId) {

        this.imgId = imgId;
    }

    public void setImgId1(int imgId1) {

        this.imgId1 = imgId1;
    }

    public void setImgId2(int imgId2) {

        this.imgId2 = imgId2;
    }
    public String getabbes() {
        return abbes;
    }

}




