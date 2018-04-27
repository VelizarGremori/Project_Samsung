package com.example.nata.project_samsung;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static com.example.nata.project_samsung.DBHelper.TABLE_NAME;

public class ShowplaceHelper {

    SQLiteDatabase db;

    public ShowplaceHelper(Context context){
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getReadableDatabase();
    }

    ArrayList<Showplace> getAll(String markPlaceToSearch){

        Cursor cursor = db.query(TABLE_NAME, null, null,null,null,null,null, null);
        ArrayList<Showplace> arrayList = new ArrayList<>();

        cursor.moveToFirst();

        if(!cursor.isAfterLast()){

            do {

                String markPlace = cursor.getString(DBHelper.NUM_COLUMN_MARKPLACE);
                if (markPlaceToSearch!=markPlace) {
                    break;
                }
                long id = cursor.getLong(DBHelper.NUM_COLUMN_ID);
                String title = cursor.getString(DBHelper.NUM_COLUMN_TITLE);
                String description = cursor.getString(DBHelper.NUM_COLUMN_DESCRIPTION);
                String address = cursor.getString(DBHelper.NUM_COLUMN_ADDRESS);
                String url = cursor.getString(DBHelper.NUM_COLUMN_URL);

                arrayList.add(new Showplace(id, title, description, address, url, markPlace));
            }while (cursor.moveToNext());
        }
        db.close();

        return arrayList;
    }
}
