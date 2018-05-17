package com.example.nata.project_samsung;


import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.nata.project_samsung.DBHelper.TABLE_NAME;

public class ShowplaceHelper {

    SQLiteDatabase db;

    public ShowplaceHelper(Context context) {
        DBHelper dbHelper = new DBHelper(context);
        try {
            dbHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
    }

    ArrayList<Showplace> getAll(String markPlaceToSearch){

        Cursor cursor = db.query(TABLE_NAME, null, null,null,null,null,null, null);
        ArrayList<Showplace> arrayList = new ArrayList<>();

        cursor.moveToFirst();

        if(!cursor.isAfterLast()){

            do {

                String markPlace = cursor.getString(DBHelper.NUM_COLUMN_MARKPLACE);
                if (!markPlaceToSearch.equals(markPlace) && markPlaceToSearch!="") {
                    break;
                }
                long id = cursor.getLong(DBHelper.NUM_COLUMN_ID);
                String title = cursor.getString(DBHelper.NUM_COLUMN_TITLE);
                String description = cursor.getString(DBHelper.NUM_COLUMN_DESCRIPTION);
                String address = cursor.getString(DBHelper.NUM_COLUMN_ADDRESS);
                String url = cursor.getString(DBHelper.NUM_COLUMN_URL);
                String image = cursor.getString(DBHelper.NUM_COLUMN_IMAGE);
                Double lat = cursor.getDouble(DBHelper.NUM_COLUMN_LAT);
                Double lng = cursor.getDouble(DBHelper.NUM_COLUMN_LNG);

                arrayList.add(new Showplace(id, title, description, address, url, markPlace, image, lat, lng));
            }while (cursor.moveToNext());
        }
        db.close();

        return arrayList;
    }
}
