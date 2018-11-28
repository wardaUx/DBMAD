package com.example.wardauzair.madassignmentdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBMS extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Users.db";
    public static final String TABLE_NAME = "Users_tABLE";
   // public static final String ID_COL1 = "ID";
    //public static final String USERNAME_COL2 = "USERNAME";
    //public static final String EMAIL_COL3 = "EMAIL";
    //public static final String PASSWORD_COL4 = "PASSWORD";



    //public String queryInsert1 = "INSERT INTO Users_tABLE(ID,USERNAME,EMAIL,PASSWORD) VALUES(Warda,wardasbgmailcom,123)" ;
  //  public String queryInsert2 = "INSERT INTO " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, EMAIL TEXT, PASSWORD TEXT )" ;
   // public String queryInsert3 = "INSERT INTO " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, EMAIL TEXT, PASSWORD TEXT )" ;


    public DBMS(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Users_tABLE(ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, EMAIL TEXT, PASSWORD TEXT )");
        db.execSQL("INSERT INTO `Users_tABLE` (`ID`, `USERNAME`, `EMAIL`, `PASSWORD`) VALUES (NULL, 'WARDA', 'WARDA123', 'W123');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Users_tABLE");
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor resultFromCursor = db.rawQuery("select * from Users_tABLE" , null );
        return resultFromCursor;

    }

}
