package com.example.prabhusivanandam.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Prabhu Sivanandam on 12-Mar-17.
 */

public class Databasehelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="users.db";
    private static final String TABLE_NAME="users";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_USERNAME="username";
    private static final String COLUMN_PASSWORD="password";
    private static final String TABLE_CREATE="create table users (id integer primary key not null,"+"username text not null,password text not null)";
    SQLiteDatabase db;
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="DROP TABLE IF EXISTS users";
        db.execSQL(query);
        this.onCreate(db);
    }
    public Databasehelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    public void insertuser(User user)
    {
        db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        String query="select * from users";
        Cursor c=db.rawQuery(query,null);
        int count=c.getCount();
        values.put(COLUMN_ID,count);
        values.put(COLUMN_USERNAME,user.getUsername());
        values.put(COLUMN_PASSWORD,user.getPassword());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public int searchuser(String name)
    {
        db=this.getReadableDatabase();
        int flag=1;
        String query="SELECT username from users";
        Cursor c=db.rawQuery(query,null);
        if(c.moveToFirst())
        {
            do {
                if(name.equals(c.getString(0)))
                {
                    flag=0;
                    break;
                }
            }while(c.moveToNext());
        }
        return flag;
    }
    public String searchpass(String s)
    {
        db=this.getReadableDatabase();
        String query="SELECT username,password from users";
        Cursor c=db.rawQuery(query,null);
        String a,b;
        b="not found";
        if(c.moveToFirst())
        {
            do {
                a=c.getString(0);
                if(a.equals(s))
                {
                    b=c.getString(1);
                    break;
                }
            }while(c.moveToNext());
        }
        return b;
    }
}
