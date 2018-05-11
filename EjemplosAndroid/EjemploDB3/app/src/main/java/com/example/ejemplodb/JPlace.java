package com.example.ejemplodb;

import java.io.Serializable;

public class JPlace implements Serializable{
    private int mID;
    private String mName;
    private String mCity;
    private String mUrl;
    private double mLat;
    private double mLon;

    public double getLan(){return mLat;}
    public double getLon(){return mLon;}
    public int getID(){
        return mID;
    }
    public String getName(){
        return mName;
    }
    public String getUrl(){
        return mUrl;
    }

    public String getCity(){
        return mCity;
    }

    public JPlace(int id, String name, String city, String url,double lan,double lon) {
        mID = id;
        mName = name;
        mCity = city;
        mUrl = url;
        mLat =lan;
        mLon=lon;
    }
}
