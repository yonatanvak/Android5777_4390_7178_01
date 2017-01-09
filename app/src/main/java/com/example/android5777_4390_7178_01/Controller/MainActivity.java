package com.example.android5777_4390_7178_01.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android5777_4390_7178_01.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView s = (TextView) findViewById(R.id.textViewUser);
        s.setText(getIntent().getStringExtra("USERNAME"));

        findViewById(R.id.buttonADDB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intentAddBusiness = new Intent(MainActivity.this, AddBusinessActivity.class);
               startActivity(intentAddBusiness);

            }
        });

        findViewById(R.id.buttonADDA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddAtraction = new Intent(MainActivity.this, AddAttraction.class);
                startActivity(intentAddAtraction);
            }
        });

    }
}
