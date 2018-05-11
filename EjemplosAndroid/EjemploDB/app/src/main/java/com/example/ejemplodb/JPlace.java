package com.example.ejemplodb;

import java.io.Serializable;

public class JPlace implements Serializable{
    private int mID;
    private String mName;
    private String mCity;
    private String mUrl;
    private String mLat;
    private String mLon;

    public String getLat(){
        return mLat;
    }
    public String getLon(){
        return mLon;
    }
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

    public JPlace(int id, String name, String city, String url, String lat,String lon) {
        mID = id;
        mName = name;
        mCity = city;
        mUrl = url;
        mLon= lon;
        mLat=lat;
    }
}
