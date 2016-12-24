package com.example.android5777_4390_7178_01.Controller;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android5777_4390_7178_01.MainActivity;
import com.example.android5777_4390_7178_01.R;
import com.example.android5777_4390_7178_01.model.SharedPreferences.SharedPreferencesClass;
import com.example.android5777_4390_7178_01.model.datasource.CustomContentProvider;
import com.example.android5777_4390_7178_01.model.entities.Manager;

public class Registery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

       final Manager user = new Manager();

    //    SharedPreferencesClass shc = new SharedPreferencesClass();
     //   shc.saveSharedPreferences();

        findViewById(R.id.buttonSign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = (EditText) findViewById(R.id.etUserName);
                EditText password = (EditText) findViewById(R.id.etPassword);

                user.userNumber++;
//try {
    long numberUser = user.userNumber;
    final ContentValues contentValueManager = new ContentValues();
    contentValueManager.put("userName", username.toString());
    contentValueManager.put("password", password.toString());
    contentValueManager.put("userNumber", numberUser);


    new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... params) {
            getContentResolver().insert(CustomContentProvider.MANAGER_CONTENT_URL, contentValueManager);
            return null;
        }
    };
/*}
catch (Exception e)
{
    Toast.makeText(Registery.this ,  "הטעות כאן!!" , Toast.LENGTH_LONG).show();
}*/
                Intent sign = new Intent(Registery.this , MainActivity.class);
             startActivity(sign);
            }}
        );}


    }

