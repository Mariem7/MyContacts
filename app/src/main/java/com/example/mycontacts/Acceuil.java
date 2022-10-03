package com.example.mycontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mycontacts.entities.Contact;

import java.util.ArrayList;

public class Acceuil extends AppCompatActivity {

    //declaration of components
    Button btn_add, btn_edit;
    public static ArrayList<Contact> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //load xml file in the view
        setContentView(R.layout.activity_acceuil);

        //retrieve values from view by id
        btn_add = findViewById(R.id.btn_add_acceuil);
        btn_edit = findViewById(R.id.btn_edit_acceuil);

        //listener for login button
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Acceuil.this,Ajout.class);
                startActivity(i);
            }
        });

        //listener for edit button
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Acceuil.this,Edit.class);
                startActivity(i);
            }
        });
    }
}