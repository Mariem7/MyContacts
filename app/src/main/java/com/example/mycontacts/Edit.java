package com.example.mycontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Edit extends AppCompatActivity {

    //declaration of components
    EditText ed_search_edit;
    ListView list_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //load xml file in the view
        setContentView(R.layout.activity_edit);

        //retrieve values from view by id
        ed_search_edit = findViewById(R.id.ed_search_edit);
        list_search = findViewById(R.id.list_search_edit);
        ArrayAdapter ad = new ArrayAdapter(Edit.this, android.R.layout.simple_list_item_1,Acceuil.data);
        list_search.setAdapter(ad);

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