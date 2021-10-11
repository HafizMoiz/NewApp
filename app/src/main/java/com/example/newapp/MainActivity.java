 package com.example.newapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity {
    String url = "https://scontent.flhe20-1.fna.fbcdn.net/v/t39.30808-6/240649454_1468430580181600_8914378278640507511_n.jpg?_nc_cat=103&ccb=1-5&_nc_sid=730e14&_nc_ohc=RZg8JWxDYm8AX9_ZZBU&_nc_ht=scontent.flhe20-1.fna&oh=6daa18c77f7e942b6569d2c78c6d2a97&oe=612AC907";
    CardView database , fragments , location ,logout ;
    CircleImageView profileimg;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
       database =findViewById(R.id.database);
       fragments =findViewById(R.id.fragments);
       location = findViewById(R.id.location);
       profileimg =findViewById(R.id.profileimg);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu,menu);
       for(int i =0 ; i<menu.size(); i++){
           MenuItem menuItem = menu.getItem(i);
           SpannableString spannableString = new SpannableString(
                   menu.getItem(i).getTitle().toString()
           );
           spannableString.setSpan(new ForegroundColorSpan(Color.BLACK),
                   0,spannableString.length(),0);
           menuItem.setTitle(spannableString);
       }
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.share) {
            Toast.makeText(this, "Clicked Share Button", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.about) {
            Toast.makeText(this, "Clicked About Button", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.exit) {
            Toast.makeText(this, "Clicked Exit Button", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.search) {
            Toast.makeText(this, "Clicked Search Button", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.setting) {
            Toast.makeText(this, "Clicked Setting Button", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public void DataBase(View view) {
        Intent i = new Intent(MainActivity.this , Db.class);
        startActivity(i);
        Toast.makeText(this, "Your Data Base", Toast.LENGTH_SHORT).show();
    }

    public void LogOut(View view) {
        SharedPreferences sp = getSharedPreferences("Test", MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.clear();
        ed.commit();

        Intent i = new Intent(MainActivity.this , LoginActivity.class);
        startActivity(i);


    }

    public void Location(View view) {
        Intent i = new Intent(MainActivity.this , MapsActivity.class);
        startActivity(i);
        Toast.makeText(this, "Your location", Toast.LENGTH_SHORT).show();

    }



    public void gallery(View view) {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i , "Select") , 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == RESULT_OK){
            Uri path = data.getData();
            try {
                Bitmap b = MediaStore.Images.Media.getBitmap(getContentResolver(),path  );
                b.getHeight();
//                b.com
                profileimg.setImageBitmap(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Glide.with(this).load(data.getData()).into(profileimg);
        }
        else{
            Toast.makeText(this, "user Cancelled", Toast.LENGTH_SHORT).show();
        }

    }
}