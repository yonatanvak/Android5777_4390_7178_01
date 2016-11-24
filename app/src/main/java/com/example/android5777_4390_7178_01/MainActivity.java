package com.example.android5777_4390_7178_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                EditText edit = (EditText) findViewById(R.id.editTextUser);

                if(edit.getText().toString().equals("בניה")) {
                    Intent intent = new Intent(MainActivity.this, screen1.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"רק בניה יכול!!",Toast.LENGTH_LONG).show();
                }

            }
        }
        );
    }
}
