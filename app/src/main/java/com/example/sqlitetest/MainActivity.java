package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button insert, display, change;
    EditText edit1, edit2;
    String name, coll;
    DBhelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert = findViewById(R.id.insert);
        display = findViewById(R.id.display);
        change = findViewById(R.id.change);
        edit1 = findViewById(R.id.cedit1);
        edit2 = findViewById(R.id.edit2);
        DB = new DBhelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edit1.getText().toString();
                coll = edit2.getText().toString();
                Boolean checkinsertdata = DB.insertUserData(name, coll);
                if(checkinsertdata == true)
                {
                    Toast.makeText(getApplicationContext(), "Data inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),displayActivity.class);
                startActivity(intent);
            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),changeActivity.class);
                startActivity(intent);
            }
        });
    }
}