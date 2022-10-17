package com.example.mycontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declaration of components
    Button btn_qte, btn_login_auth;
    EditText ed_email, ed_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //load xml file in the view
        setContentView(R.layout.activity_main);

        //retrieve values from view by id
        btn_qte = findViewById(R.id.btn_qte_auth);
        btn_login_auth = findViewById(R.id.btn_login_auth);
        ed_email = findViewById(R.id.ed_mail_auth);
        ed_password = findViewById(R.id.ed_password_auth);

        //listener for quit button
        btn_qte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //close the current activity
                finish();
            }
        });

        //listener for login button
        btn_login_auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = ed_email.getText().toString();
                String password = ed_password.getText().toString();
                if(email.equals("mariem")&& password.equals("mary")){
                    Intent i = new Intent(MainActivity.this,Acceuil.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this, "echec", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}