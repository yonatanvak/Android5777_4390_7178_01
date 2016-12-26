package com.example.android5777_4390_7178_01.model.entities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import com.example.android5777_4390_7178_01.R;

public class Manager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
    }

    public static long userNumber;
    private String name;
    private String password;


    public Manager(long userNumber, String name, String password) {
        this.userNumber = userNumber;
        this.name = name;
        this.password = password;
    }
    public Manager(){};

    public long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(long userNumber) {
        this.userNumber = userNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
