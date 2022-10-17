package com.example.mycontacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import com.example.mycontacts.adapters.MyRecyclerAdapter;
import com.example.mycontacts.manager.ContactManager;

public class Edit extends AppCompatActivity {

    //declaration of components
    EditText ed_search_edit;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //load xml file in the view
        setContentView(R.layout.activity_edit);

        //retrieve values from view by id
        ed_search_edit = findViewById(R.id.ed_search_edit);
        rv = findViewById(R.id.rv);
        //take as parameter the context (the activity) and the data to be displayed
        //MyListViewAdapter ad = new MyListViewAdapter(Edit.this, Acceuil.data);
        ContactManager contactManager = new ContactManager(Edit.this);
        contactManager.openDataBase();
        //init data
        Acceuil.data = contactManager.getAllContact();
        MyRecyclerAdapter ad = new MyRecyclerAdapter(Edit.this,Acceuil.data);
        LinearLayoutManager manager = new GridLayoutManager(Edit.this,1,GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(manager);
        rv.setAdapter(ad);




        ed_search_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}