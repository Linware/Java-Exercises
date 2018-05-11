package com.example.ejemplodb;

import java.io.Serializable;

public class JPlace implements Serializable{
    private int mID;
    private String mName;
    private String mCity;

    public int getID(){
        return mID;
    }
    public String getName(){
        return mName;
    }

    public String getCity(){
        return mCity;
    }

    public JPlace(int id, String name, String city) {
        mID = id;
        mName = name;
        mCity = city;
    }
}
