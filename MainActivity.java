package com.example.wardauzair.madassignmentdb;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnShow;
    DBMS dbms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShow = findViewById(R.id.btnShow);
        dbms = new DBMS(this);
        show();
    }
    public void show(){
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor ress = dbms.getData();
                int counttt = ress.getCount();
               if(ress.getCount() == 0 ){
                   Toast.makeText(MainActivity.this, "int "+counttt, Toast.LENGTH_SHORT).show();
                   return;
                }else{
                while (ress.moveToNext()){
                    final String  id = ress.getString(0);
                    final String  name = ress.getString(1);
                    final String email =ress.getString(2);
                    final String password = ress.getString(3);

                    Toast.makeText(MainActivity.this, ""+email, Toast.LENGTH_SHORT).show();

                }
               }

            }
        });

    }

    public void showData(String title, String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
}
