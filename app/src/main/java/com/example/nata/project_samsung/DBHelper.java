package com.example.nata.project_samsung;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "";
    public static final String TABLE_NAME = "";
    //    .................Имена колонок..........................
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_URL = "url";
    public static final String COLUMN_MARKPLACE = "markPlace";
    //    ................Индексы колонок.........................
    public static final int NUM_COLUMN_ID = 0;
    public static final int NUM_COLUMN_TITLE = 1;
    public static final int NUM_COLUMN_DESCRIPTION = 2;
    public static final int NUM_COLUMN_ADDRESS = 3;
    public static final int NUM_COLUMN_URL = 4;
    public static final int NUM_COLUMN_MARKPLACE = 5;
    public static int DATABASE_VERSION = 1;


    DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_ADDRESS + " TEXT, " +
                COLUMN_URL + " TEXT, " +
                COLUMN_MARKPLACE + " TEXT); ";
        sqLiteDatabase.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
