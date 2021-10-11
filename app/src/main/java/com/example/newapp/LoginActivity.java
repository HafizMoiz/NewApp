package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
//    private  Sharedprefrencecoding sharedprefrencecoding;
    EditText mail , password ;
    Button loginbtn;
    TextView dontaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mail = findViewById(R.id.mail);
        password = findViewById(R.id.password);
        loginbtn = findViewById(R.id.loginbtn);
        dontaccount = findViewById(R.id.dontaccount);

        SharedPreferences sp = getSharedPreferences("Test", MODE_PRIVATE);
        boolean bool = sp.getBoolean("bool", false);

        if(bool)
        {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this, "Please login to your account.", Toast.LENGTH_SHORT).show();
        }

    }

    public void login(View view) {
        String name = mail.getText().toString();
        String pass = password.getText().toString();
        if(name.equals("pny23@gmail.com") && pass.equals("1234")){
            SharedPreferences sp = getSharedPreferences("Test" , MODE_PRIVATE);
            SharedPreferences.Editor ed = sp.edit();
            ed.putBoolean("bool", true);
            ed.commit();
           // Toast.makeText(LoginActivity.this , "Successfully login " ,Toast.LENGTH_SHORT).show();
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
            mail.setText("");
            password.setText("");
        }
        else{
            Toast.makeText(LoginActivity.this , "LOGIN AGAIN" ,Toast.LENGTH_SHORT).show();
            mail.setError("Invalid Email");
            password.setError("Invalid password");
        }
    }

    public void dontaccount(View view) {
        Intent i = new Intent(LoginActivity.this , RegistorActivity.class);
        startActivity(i);
        Toast.makeText(this, "Registor now", Toast.LENGTH_SHORT).show();
    }
}