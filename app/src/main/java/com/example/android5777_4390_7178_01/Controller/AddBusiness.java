package com.example.android5777_4390_7178_01.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android5777_4390_7178_01.model.entities.Business;

public class AddBusiness extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_business);

        final Business business = new Business();
    }
}
