package com.example.android5777_4390_7178_01;

import android.content.ContentValues;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android5777_4390_7178_01.model.Activity_type;
import com.example.android5777_4390_7178_01.model.datasource.CustomContentProvider;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText manegerUser = (EditText) findViewById(R.id.etUser);

                if (manegerUser.getText().toString().equals("בניה")) {
                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(login.this, "מורדוך סמרטוט !!", Toast.LENGTH_LONG).show();
                }
                final ContentValues maneger = new ContentValues();
                maneger.put("nameKey", manegerUser.toString());

                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        getContentResolver().insert(CustomContentProvider.MANAGER_CONTENT_URL, maneger);
                        return null;
                    }
                };
            }
        }
        );

       /* findViewById(R.id.buttonSign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sign = new Intent(login.this , Manager.class);
                startActivity(sign);
            }
        });*/
    }

  /*  public void buttonLogin (View view)
    {
        EditText editText = (EditText) findViewById(R.id.editTextUser);
        String string = editText.getText().toString();

        Toast.makeText(this, string , Toast.LENGTH_SHORT).show();
    }*/

    public void buttonSign (View view)
    {
        Intent sign = new Intent(login.this , MainActivity.class);
        startActivity(sign);
    }
}
