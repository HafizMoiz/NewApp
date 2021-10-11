package com.example.newapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final String DataBase_Name ="Student.db";
    public static final String Table_Name ="Student_Table";
    public static final String Col_1 ="ID";
    public static final String Col_2 ="NAME";
    public static final String Col_3 ="SURNAME";
    public static final String Col_4 ="MARKS";

    public Database(@Nullable Context context) {
        super(context, DataBase_Name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table " +Table_Name+" (ID INTEGER PRIMARY KEY AUTOINCREMENT  , NAME TEXT , SURNAME TEXT ,MARKS INTEGER)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Name);
        onCreate(db);

    }
    public boolean InsertData(String id,String name , String surname ,String marks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_1,id);
        contentValues.put(Col_2, name);
        contentValues.put(Col_3, surname);
        contentValues.put(Col_4, marks);
        long result =db.insert(Table_Name ,null ,contentValues);
        if(result == -1){
            return false;
        }else {
            return true;
        }

    }
    public Cursor getalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+Table_Name,null);

        return res;

    }

    public boolean updateData(String id, String name, String surname, String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_1, id);
        contentValues.put(Col_2, name);
        contentValues.put(Col_3, surname);
        contentValues.put(Col_4, marks);
        db.update(Table_Name ,contentValues ,"id = ?", new String[] {id});
        return true;
    }
    public Integer DeleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(Table_Name,"id = ?", new String[] {id});

    }
}
