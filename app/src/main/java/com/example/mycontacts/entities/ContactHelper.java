package com.example.mycontacts.entities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ContactHelper extends SQLiteOpenHelper {

    //declare database name and attributes
    public static final String table_contact="Contacts";
    public static final String col_id= "ID";
    public static final String col_first_name= "Fist_Name";
    public static final String col_last_name= "Last_Name";
    public static final String col_phone_number= "Phone_Number";

    //requests
    String create_database_request="create table "+table_contact+" ("+col_id+" Integer Primary Key Autoincrement,"+
            col_first_name+" Text not null,"+col_last_name+" Text not null,"
            +col_phone_number+" Text not null)";


    public ContactHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //create database
        sqLiteDatabase.execSQL(create_database_request);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //update the version of the app
        //delete table
        sqLiteDatabase.execSQL("drop table "+table_contact);
        //create table
        onCreate(sqLiteDatabase);
    }
}
