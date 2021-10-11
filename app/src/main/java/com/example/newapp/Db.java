package com.example.newapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.newapp.R.drawable.*;

public class Db extends AppCompatActivity {
    Database mydb ;
    EditText inputname , inputsurname , inputmarks , inputid;
    Button btnadd , btnshow , update , delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mydb = new Database(this);
        inputname = findViewById(R.id.inputname);
        inputsurname = findViewById(R.id.inputsurname);
        inputid = findViewById(R.id.inputid);
        inputmarks = findViewById(R.id.inputmarks);
        btnadd = findViewById(R.id.btnadd);
        btnshow = findViewById(R.id.btnshow);
        delete = findViewById(R.id.delete);
        update = findViewById(R.id.update);

    }
    //Toolbar Coding

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
        // toolbar coding End
    }
    public void updateData(View view) {
        boolean updateData=  mydb.updateData(inputid.getText().toString() , inputname.getText().toString(),
                inputsurname.getText().toString(),inputmarks.getText().toString());
        if(updateData == true){
            Toast.makeText(this, "Data Is Updated", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Data Is Not Updated", Toast.LENGTH_SHORT).show();
        }
        inputid.setText("");
        inputname.setText("");
        inputsurname.setText("");
        inputmarks.setText("");
    }

    public void AddData(View view) {
       boolean inserted=  mydb.InsertData(inputid.getText().toString(),inputname.getText().toString(),
               inputsurname.getText().toString(),inputmarks.getText().toString());
       if(inserted == true){
           Toast.makeText(this, "Data Is Inserted", Toast.LENGTH_SHORT).show();
       }else {
           Toast.makeText(this, "Data Is Not Inserted", Toast.LENGTH_SHORT).show();
       }
       inputid.setText("");
       inputname.setText("");
        inputsurname.setText("");
        inputmarks.setText("");

    }

    public void showData(View view) {
        Cursor res = mydb.getalldata();
        if(res.getCount() == 0){
            showMessage( "Error","Nothing is found" );
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("ID ; " +res.getString(0)+ "\n");
            buffer.append("NAME ; " +res.getString(1)+ "\n");
            buffer.append("SURNAME ; " +res.getString(2)+ "\n");
            buffer.append("MARKS ; " +res.getString(3)+ "\n\n");
        }
        showMessage("Data is found",buffer.toString() );

    }
    public  void  showMessage(String title , String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }


    public void DeleteData(View view) {
        Integer deletedrow = mydb.DeleteData(inputid.getText().toString());
        if(deletedrow > 0){
                Toast.makeText(this, "Data Is Deleted", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Data Is Not Deleted", Toast.LENGTH_SHORT).show();
            }
        inputid.setText("");
        inputname.setText("");
        inputsurname.setText("");
        inputmarks.setText("");

    }
}