package com.example.android5777_4390_7178_01.model.entities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android5777_4390_7178_01.Controller.login;
import com.example.android5777_4390_7178_01.R;

public class screen_open extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_open);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(3000);
                        Intent intent = new Intent (screen_open.this,login.class);
                        startActivity(intent);
                        finish();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }
}
