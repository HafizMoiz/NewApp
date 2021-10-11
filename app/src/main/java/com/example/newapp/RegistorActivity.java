package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistorActivity extends AppCompatActivity {
    EditText Rusername , Rmail , Rpassword ,Rcpassword ;
    Button registorbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registor);
        Rusername = findViewById(R.id.Rusername);
        Rmail = findViewById(R.id.Rmail);
        Rpassword = findViewById(R.id.Rpassword);
        Rcpassword = findViewById(R.id.Rcpassword);
    }

    public void already(View view) {
        Intent i = new Intent(RegistorActivity.this , LoginActivity.class);
        startActivity(i);
        Toast.makeText(this, "Login Your Account", Toast.LENGTH_SHORT).show();
    }

    public void registor(View view) {
        String name = Rusername.getText().toString();
        String mail = Rmail.getText().toString();
        String pass = Rpassword.getText().toString();
        String confirm = Rcpassword.getText().toString();
        if(name.equalsIgnoreCase("PNY") && mail.equals("pny23@gmail.com")&&
        pass.equals("1234")&&confirm.equals("1234")){
            Toast.makeText(RegistorActivity.this , "You,r Registored Login Your Account!!" ,Toast.LENGTH_SHORT).show();
            Intent i = new Intent(RegistorActivity.this, LoginActivity.class);
            startActivity(i);
           Rusername.setText("");
           Rmail.setText("");
           Rpassword.setText("");
           Rcpassword.setText("");
        }
        else {
            Toast.makeText(RegistorActivity.this , "PASSWORD Does Not Match " ,Toast.LENGTH_SHORT).show();
        }
    }
}