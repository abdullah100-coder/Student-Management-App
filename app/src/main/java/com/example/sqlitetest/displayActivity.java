package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class displayActivity extends AppCompatActivity {

    TextView nameText, collegeText;
    Button prev, next, dhome, dex, dchange;
    DBhelper DB;
    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        getSupportActionBar().hide();
        nameText = findViewById(R.id.nameText);
        collegeText = findViewById(R.id.collegeText);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        dhome = findViewById(R.id.chome);
        dex = findViewById(R.id.cex);
        dchange = findViewById(R.id.cdisp);
        DB = new DBhelper(this);
        Cursor c = DB.getdata();

        nameText.setText(c.getString(c.getColumnIndex("name")));
        collegeText.setText(c.getString(c.getColumnIndex("college")));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    c.moveToNext();
                    nameText.setText(c.getString(c.getColumnIndex("name")));
                    collegeText.setText(c.getString(c.getColumnIndex("college")));
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Last Record", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();

                }
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    c.moveToPrevious();
                    nameText.setText(c.getString(c.getColumnIndex("name")));
                    collegeText.setText(c.getString(c.getColumnIndex("college")));
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "First Record", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
        dhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        dchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),changeActivity.class);
                startActivity(intent);
            }
        });
        dex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }
}


