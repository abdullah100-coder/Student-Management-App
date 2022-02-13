package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class changeActivity extends AppCompatActivity {
EditText cedit1, cedit2;
Button delete, update, chome, cdisp, cex;
DBhelper DB;
String dataName, dataCollege;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_change);
        cedit1 = findViewById(R.id.cedit1);
        cedit2 = findViewById(R.id.cedit2);
        delete = findViewById(R.id.delete);
        chome = findViewById(R.id.chome);
        cdisp = findViewById(R.id.cdisp);
        update = findViewById(R.id.update);
        cex = findViewById(R.id.cex);
        DB = new DBhelper(this );


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataName = cedit1.getText().toString();
                    Boolean checkdeletedata = DB.deleteUserData(dataName);
                    if(checkdeletedata == true){
                        Toast.makeText(getApplicationContext(), "Successfully deleted", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(), "Name does not exits", Toast.LENGTH_SHORT).show();
                    }
                }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataName = cedit1.getText().toString();
                dataCollege = cedit2.getText().toString();

                if(dataName != null && dataCollege != null){
                    Boolean checkupdatedata = DB.updateUserData(dataName, dataCollege);
                    if (checkupdatedata == true){
                        Toast.makeText(getApplicationContext(), "Successfully updated", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Name does not exits", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    chome.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
    });
    cdisp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(),displayActivity.class);
            startActivity(intent);
        }
    });
    cex.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finishAffinity();
        }
    });
    }
}

