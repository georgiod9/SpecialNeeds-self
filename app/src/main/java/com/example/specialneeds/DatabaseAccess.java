package com.example.specialneeds;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database = null;
    private static DatabaseAccess instance;

    public static final String TABLE_USER = "User";
    public static final int TABLE_USER_LENGTH = 4;

    public static final String TABLE_VOLUNTEER = "Volunteer";
    public static final String TABLE_CALLS = "Calls";
    public static final String TABLE_RATINGS = "Rating";
    public static final String COL_USER_ID = "User_Id";
    public static final String COL_USER_NAME = "User_Name";
    public static final String COL_USER_EMAIL = "User_Email";
    public static final String COL_USER_PASSWORD = "User_Password";
    public static final String COL_VOL_ID = "Volunteer_Id";
    public static final String COL_VOL_NAME = "Volunteer_Name";
    public static final String COL_VOL_EMAIL = "Volunteer_Email";
    public static final String COL_VOL_PASSWORD = "Volunteer_Password";

    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if (instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.database = openHelper.getWritableDatabase();
    }

    public void close(){
        if (database != null){
            this.database.close();
        }
    }

    public List<String> getData(){
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM User", null);
        cursor.moveToNext();
        list.add(COL_USER_ID);
        list.add(COL_USER_NAME);
        list.add(COL_USER_EMAIL);
        list.add(COL_USER_PASSWORD);

        while(!cursor.isAfterLast()){
            for (int i = 0; i < TABLE_USER_LENGTH; i++){
                list.add(cursor.getString(i));
            }
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }

    public void addAccount(String name, String email, String password, String accountType){
        ContentValues contentValues = new ContentValues();

        if (accountType.equals("u")){
        contentValues.put(COL_USER_NAME, name);
        contentValues.put(COL_USER_EMAIL, email);
        contentValues.put(COL_USER_PASSWORD, password);

        database.insert(TABLE_USER, null, contentValues);
         }

        else if (accountType.equals("v")){
            contentValues.put(COL_VOL_NAME, name);
            contentValues.put(COL_VOL_EMAIL, email);
            contentValues.put(COL_VOL_PASSWORD, password);

            database.insert(TABLE_VOLUNTEER, null, contentValues);
        }
    }
}
