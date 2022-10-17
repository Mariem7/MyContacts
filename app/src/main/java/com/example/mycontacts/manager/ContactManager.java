package com.example.mycontacts.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mycontacts.entities.Contact;
import com.example.mycontacts.entities.ContactHelper;

import java.util.ArrayList;
import java.util.Currency;

public class ContactManager {

    //initialize the database
    SQLiteDatabase db = null;
    Context context;

    public ContactManager(Context context){
        this.context = context;
    }

    public void openDataBase(){
        ContactHelper helper = new ContactHelper(context,"mybase.db",null,1);
        //open database on mode read and write
        db = helper.getWritableDatabase();
    }

    public long addContact(String first_name,String last_name,String phone_number){
        long result = 0;
        ContentValues values = new ContentValues();
        values.put(ContactHelper.col_first_name,first_name);
        values.put(ContactHelper.col_last_name,last_name);
        values.put(ContactHelper.col_phone_number,phone_number);
        return result = db.insert(ContactHelper.table_contact,null,values);
    }

    public ArrayList<Contact> getAllContact(){
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        Cursor cr = db.query(ContactHelper.table_contact,
                new String[]{ContactHelper.col_id,
                             ContactHelper.col_first_name,
                             ContactHelper.col_last_name,
                             ContactHelper.col_phone_number},
                             null,null,null,null,null);
        cr.moveToFirst();
        while(!cr.isAfterLast()){
            int i1 = cr.getInt(0);
            String i2 = cr.getString(1);
            String i3 = cr.getString(2);
            String i4 = cr.getString(3);
            contacts.add(new Contact(i1,i2,i3,i4));
            cr.moveToNext();
        }
        return contacts;
    }

    public void deleteContact(){

    }

    public void closeDataBase(){

    }
}
