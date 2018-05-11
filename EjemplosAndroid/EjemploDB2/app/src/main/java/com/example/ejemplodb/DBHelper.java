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

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creamos la tabla places:
        String sql = String.format("create table %s (%s integer primary key, " +
                "%s text, %s text)", TABLE_PLACES, COL_ID, COL_NAME, COL_CITY);
        db.execSQL(sql);

        //Insertamos un par de registros para tener algo que listar (carga inicial):
        sql = String.format("insert into %s (%s, %s) values ('Museo Guggenheim','Bilbao')",
                TABLE_PLACES,COL_NAME,COL_CITY);
        db.execSQL(sql);
        sql = String.format("insert into %s (%s, %s) values ('Torre Eiffel','Paris')",
                TABLE_PLACES,COL_NAME,COL_CITY);
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = String.format("DROP TABLE IF EXISTS %s", TABLE_PLACES);
        db.execSQL(sql);
        onCreate(db);
    }

    public boolean placeInsert (JPlace p) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, p.getName());
        contentValues.put(COL_CITY, p.getCity());
        db.insert(TABLE_PLACES, null, contentValues);
        return true;
    }

    public Cursor placeData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = String.format("Select * from %s where %s='%s'",
                TABLE_PLACES, COL_ID, id);
        Cursor res =  db.rawQuery( sql, null );
        return res;
    }

    public int placeCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_PLACES);
        return numRows;
    }

    public boolean placeUpdate (JPlace p) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, p.getName());
        contentValues.put(COL_CITY, p.getCity());
        db.update(TABLE_PLACES, contentValues, COL_ID + " = ? ", new String[] { Integer.toString(p.getID()) } );
        return true;
    }

    public Integer placeDelete (int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_PLACES,
                COL_ID + " = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<JPlace> placesList() {
        ArrayList<JPlace> list = new ArrayList<JPlace>();

        SQLiteDatabase db = this.getReadableDatabase();
        String sql = String.format("Select * from %s", TABLE_PLACES);
        Cursor res =  db.rawQuery( sql, null );
        if (res.moveToFirst()) {
            do {
                JPlace p = new JPlace(res.getInt(res.getColumnIndex(COL_ID)),
                        res.getString(res.getColumnIndex(COL_NAME)),
                        res.getString(res.getColumnIndex(COL_CITY)));
                list.add(p);
            } while (res.moveToNext());
        }
        return list;
    }
}