package com.example.ejemplodb;

import java.io.Serializable;

public class JPlace implements Serializable{
    private int mID;
    private String mName;
    private String mCity;
    private String mUrl;
    private float mLat;
    private float mLon;
    private String mWeb;
    private String mVid;

    public int getID(){
        return mID;
    }
    public String getName(){
        return mName;
    }
    public String getUrl(){
        return mUrl;
    }
    public String getWeb(){
        return mWeb;
    }
    public String getVid(){
        return mVid;
    }

    public String getCity(){
        return mCity;
    }

    public float getLat(){
        return mLat;
    }
    public float getLon(){
        return mLon;
    }

    public JPlace(int id, String name, String city, String url, float lat, float lon,String web,String video) {
        mID = id;
        mName = name;
        mCity = city;
        mUrl = url;
        mLat = lat;
        mLon = lon;
        mWeb=web;
        mVid=video;
    }
}
