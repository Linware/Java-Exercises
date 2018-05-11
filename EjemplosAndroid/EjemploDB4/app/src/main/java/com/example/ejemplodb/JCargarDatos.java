package com.example.ejemplodb;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JCargarDatos {
    private final String TAG = "JCargarDatos";
    private Context mContext;

    public JCargarDatos(Context context) {
        mContext = context;
    }

    public ArrayList<JPlace> loadPlacesFromJSON() {
        ArrayList<JPlace> items = new ArrayList<JPlace>();
        try {
            JSONArray jsonResponse = getJSONArray(R.raw.list_places);
            if (jsonResponse != null)
                for (int i = 0; i < jsonResponse.length(); i++) {
                    JSONObject jsonItem = jsonResponse.getJSONObject(i);
                    int id = jsonItem.getInt("id");
                    String name = jsonItem.getString("name");
                    String city = jsonItem.getString("city");
                    String url =jsonItem.getString("url");
                    float lat =(float) jsonItem.getDouble("lat");
                    float lon =(float) jsonItem.getDouble("lon");
                    String web=jsonItem.getString("web");
                    String video=jsonItem.getString("video");
                    items.add(new JPlace(id, name, city, url, lat, lon,web,video));
                }
        } catch (Exception e) {
            Log.e(TAG, String.format("%s: %s", e.getStackTrace()[0].getMethodName(), e.getMessage()));
        }
        return items;
    }

    protected JSONArray getJSONArray(int resID) {
        JSONArray json = null;
        try {
            String data = getDataFromJSON(resID);
            if (data != null && data.length() > 0) json = new JSONArray(data);
        } catch (Exception e) {
            Log.e(TAG, String.format("%s: %s", e.getStackTrace()[0].getMethodName(), e.getMessage()));
        }
        return json;
    }

    private String getDataFromJSON(int resID) {
        String res = null;
        try {
            BufferedInputStream resourceStream = new BufferedInputStream(mContext.getResources().openRawResource(resID));
            StringBuilder jsonString = new StringBuilder();
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(resourceStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonString.append(line).append('\n');
                }
                reader.close();
            } catch (Exception e) {
                Log.e(TAG, String.format("%s: %s", e.getStackTrace()[0].getMethodName(), e.getMessage()));
            }
            res = jsonString.toString();
            resourceStream.close();
        } catch (Exception e) {
            Log.e(TAG, String.format("%s: %s", e.getStackTrace()[0].getMethodName(), e.getMessage()));
        }
        return res;
    }
}
