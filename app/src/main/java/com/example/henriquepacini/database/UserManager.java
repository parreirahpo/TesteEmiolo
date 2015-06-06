package com.example.henriquepacini.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class UserManager extends SQLiteOpenHelper{

    private static final String DB_NAME = "users.db";
    private static final int SCHEMA = 1;

    public UserManager(Context context) {
        super(context, DB_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " user TEXT, pass TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String user, String pass) {
        ContentValues values = new ContentValues();

        values.put("user", user);
        values.put("pass", pass);

        getWritableDatabase().insert("users", "user", values);
    }

    public Cursor showUsers() {
        return getReadableDatabase().rawQuery("select _id, user FROM users ORDER BY user", null);
    }

    public String showUsername(Cursor c) {
        return c.getString(1);
    }

}
