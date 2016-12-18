package com.example.android5777_4390_7178_01.Controller;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.android5777_4390_7178_01.R;
import com.example.android5777_4390_7178_01.model.datasource.CustomContentProvider;
import com.example.android5777_4390_7178_01.model.entities.Manager;

public class Registery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

       final Manager user = new Manager();

        findViewById(R.id.buttonSign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = (EditText) findViewById(R.id.etUser);
                EditText password = (EditText) findViewById(R.id.etPassword);
                user.userNumber++;

                long numberUser = user.userNumber;
                final ContentValues contentValueManager = new ContentValues();
                contentValueManager.put("userName", username.toString());
                contentValueManager.put("password", password.toString());
                contentValueManager.put("userNumber",numberUser);

                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        getContentResolver().insert(CustomContentProvider.MANAGER_CONTENT_URL, contentValueManager);
                        return null;
                    }
                };
            }}
        );}


    }

