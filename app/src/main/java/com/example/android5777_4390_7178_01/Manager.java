package com.example.android5777_4390_7178_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Manager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
    }

    private long userNumber;
    private String name;
    private long password;

    public Manager(long userNumber, String name, long password) {
        this.userNumber = userNumber;
        this.name = name;
        this.password = password;
    }

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

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }
}
