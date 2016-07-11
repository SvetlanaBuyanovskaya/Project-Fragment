package com.fandroid.fragments;


public class ItemData {
    private  String name;
    private int image;
    private String number_phone;
    public ItemData(String name,int  image,String number_phone){
        this.name=name;
        this.image=image;
        this.number_phone=number_phone;
    }
    public int getImage() {return image;}
    public String getName() {
        return name;
    }
    public String getNumber_phone(){return number_phone;}
}
