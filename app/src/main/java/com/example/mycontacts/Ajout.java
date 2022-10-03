package com.example.mycontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mycontacts.entities.Contact;

import java.io.PrintStream;

public class Ajout extends AppCompatActivity {

    //declaration of components
    Button btn_confirm, btn_cancel;
    EditText ed_nom_ajout, ed_prenom_ajout, ed_telephone_ajout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //load xml file in the view
        setContentView(R.layout.activity_ajout);

        //retrieve values from view by id
        btn_confirm = findViewById(R.id.btn_confirm_ajout);
        btn_cancel = findViewById(R.id.btn_cancel_ajout);
        ed_nom_ajout = findViewById(R.id.ed_nom_ajout);
        ed_prenom_ajout = findViewById(R.id.ed_prenom_ajout);
        ed_telephone_ajout = findViewById(R.id.ed_telephone_ajout);

        //listener for login button
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firs_name = ed_nom_ajout.getText().toString();
                String last_name = ed_prenom_ajout.getText().toString();
                String phone_number = ed_telephone_ajout.getText().toString();
                Contact new_contact = new Contact(firs_name,last_name,phone_number);
                Acceuil.data.add(new_contact);
                Toast.makeText(Ajout.this, "ajouter", Toast.LENGTH_SHORT).show();
            }
        });
    }
}