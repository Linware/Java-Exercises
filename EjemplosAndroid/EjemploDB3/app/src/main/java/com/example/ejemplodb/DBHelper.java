package com.example.ejemplodb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "fav_places.db";
    public static final String TABLE_PLACES = "places";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_CITY = "city";
    public static final String COL_URL = "url";
    public static final String COL_LON = "lon";
    public static final String COL_LAT = "lat";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creamos la tabla places:
        String sql = String.format("create table %s (%s integer primary key, " +
                "%s text, %s text, %s text, %s text, %s text)", TABLE_PLACES, COL_ID, COL_NAME, COL_CITY, COL_URL,COL_LAT,COL_LON);
        db.execSQL(sql);

        //Insertamos un par de registros para tener algo que listar (carga inicial):
        sql = String.format("insert into %s (%s, %s, %s, %s, %s) values ('Museo Guggenheim','Bilbao','http://4learning.bymhost.com/Android/fotos/gug.jpg',43.269443, -2.934033)",
                TABLE_PLACES, COL_NAME, COL_CITY, COL_URL,COL_LAT,COL_LON);
        db.execSQL(sql);
        sql = String.format("insert into %s (%s, %s, %s, %s, %s) values ('Torre Eiffel','Paris','http://4learning.bymhost.com/Android/fotos/eif.jpg',48.858525, 2.294438)",
                TABLE_PLACES, COL_NAME, COL_CITY, COL_URL,COL_LAT,COL_LON);
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = String.format("DROP TABLE IF EXISTS %s", TABLE_PLACES);
        db.execSQL(sql);
        onCreate(db);

        //Si no pudieramos eliminar la tabla existente, añadimos el campo nuevo:
        if (newVersion>oldVersion) {
            sql = String.format("Alter table %s add column %s text", TABLE_PLACES, COL_URL);
            db.execSQL(sql);

            //Actualizamos los datos existentes con las urls de las fotos:
            sql = String.format("update %s set %s='http://4learning.bymhost.com/Android/fotos/gug.jpg' where %s='1'", TABLE_PLACES, COL_URL, COL_ID,COL_LAT,COL_LON);
            db.execSQL(sql);
            sql = String.format("update %s set %s='http://4learning.bymhost.com/Android/fotos/eif.jpg' where %s='2'", TABLE_PLACES, COL_URL, COL_ID,COL_LAT,COL_LON);
            db.execSQL(sql);
        }

    }

    public boolean placeInsert(JPlace p) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, p.getName());
        contentValues.put(COL_CITY, p.getCity());
        contentValues.put(COL_URL, p.getUrl());
        contentValues.put(String.valueOf(COL_LAT),p.getLan());
        contentValues.put(String.valueOf(COL_LON),p.getLan());
        db.insert(TABLE_PLACES, null, contentValues);
        return true;
    }

    public Cursor placeData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = String.format("Select * from %s where %s='%s'",
                TABLE_PLACES, COL_ID, id);
        Cursor res = db.rawQuery(sql, null);
        return res;
    }

    public int placeCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_PLACES);
        return numRows;
    }

    public boolean placeUpdate(JPlace p) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, p.getName());
        contentValues.put(COL_CITY, p.getCity());
        contentValues.put(COL_URL, p.getUrl());
        contentValues.put(String.valueOf(COL_LAT),p.getLan());
        contentValues.put(String.valueOf(COL_LON),p.getLan());
        db.update(TABLE_PLACES, contentValues, COL_ID + " = ? ", new String[]{Integer.toString(p.getID())});
        return true;
    }

    public Integer placeDelete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_PLACES,
                COL_ID + " = ? ",
                new String[]{Integer.toString(id)});
    }

    public ArrayList<JPlace> placesList() {
        ArrayList<JPlace> list = new ArrayList<JPlace>();

        SQLiteDatabase db = this.getReadableDatabase();
        String sql = String.format("Select * from %s", TABLE_PLACES);
        Cursor res = db.rawQuery(sql, null);
        if (res.moveToFirst()) {
            do {
                JPlace p = new JPlace(res.getInt(res.getColumnIndex(COL_ID)),
                        res.getString(res.getColumnIndex(COL_NAME)),
                        res.getString(res.getColumnIndex(COL_CITY)),
                        res.getString(res.getColumnIndex(COL_URL)),
                        res.getDouble(res.getColumnIndex(String.valueOf(COL_LAT))),
                        res.getDouble(res.getColumnIndex(String.valueOf(COL_LON)))
                        );
                list.add(p);
            } while (res.moveToNext());
        }
        return list;
    }
}