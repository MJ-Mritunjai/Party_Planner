package com.example.android.partyplanner;

import android.content.ContentValues;
import android.content.Context;
//import android.database.Cursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mritunjai on 4/15/2018.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Registertion.db";
    public static final String TABLE_NAME = "Users";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "EMAIL";
    public static final String COL_4 = "USERNAME";
    public static final String COL_5 = "PASSWORD";
    public static final String COL_6 = "C_PASSWORD";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, EMAIL TEXT, USERNAME TEXT, PASSWORD TEXT, C_PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String email, String username, String passw, String c_passw) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4, username);
        contentValues.put(COL_5, passw);
        contentValues.put(COL_6, c_passw);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    /*
    public Cursor login(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur =  db.rawQuery("select PASSWORD from "+ TABLE_NAME + " where USERNAME = " + username, null);
        return cur;
    }*/

    public String login(String username) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "select USERNAME, PASSWORD from " + TABLE_NAME;
        String usern, pass = "not found";

        Cursor cur = db.rawQuery(query, null);
        if (cur.moveToFirst()) {
            do {
                usern = cur.getString(0);
                if (usern.equals(username)) {
                    pass = cur.getString(1);
                }
            }
            while (cur.moveToNext());
        }
        return pass;
    }
}
    /*
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }*/
//}

/*

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mritunjai on 4/15/2018.
 */
/*
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "register.db";
    public static final String TABLE_NAME = "user";
    public static final String col_0 = "ID";
    public static final String col_1 = "Username";
    public static final String col_2 = "Password";
    public static final String col_3 = "Confirm_Password";
    public static final String col_4 = "Name";
    public static final String col_5 = "E-mail";

    //SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME +" ( Id INTEGER PRIMARY KEY AUTOINCREMENT, Username TEXT, Password TEXT, Con_pass TEXT, Name TEXT, Email TEXT)");
        //this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertdata (String Username, String Password, String Con_pass, String Name, String email){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put(col_1, Username);
        content.put(col_2, Password);
        content.put(col_3, Con_pass);
        content.put(col_4, Name);
        content.put(col_5, email);

        long result = db.insert(TABLE_NAME, null, content);

        if (result == -1){
            return false;
        }else{
            return true;
        }
    }
}
*/