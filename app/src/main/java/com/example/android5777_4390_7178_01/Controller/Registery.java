package com.example.android5777_4390_7178_01.Controller;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android5777_4390_7178_01.R;
import com.example.android5777_4390_7178_01.model.datasource.CustomContentProvider;
import com.example.android5777_4390_7178_01.model.datasource.TravelContent;
import com.example.android5777_4390_7178_01.model.entities.Manager;

public class Registery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

       final Manager user = new Manager();
        Button sign = (Button) findViewById(R.id.buttonSign);

        final SharedPreferences sharedPreferences = getSharedPreferences("TEST",0);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        final EditText username = (EditText) findViewById(R.id.etUserName);
        final EditText password = (EditText) findViewById(R.id.etPassword);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((username.getText().toString().equals("")) || (password.getText().toString().equals("")))
                {
                    AlertDialog.Builder problem = new AlertDialog.Builder(Registery.this);
                    problem.setTitle("Error");
                    problem.setMessage("Please fill in all fields!");
                    problem.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    problem.show();
                }
                    else{
                editor.putString("NAME", username.getText().toString());
                editor.putString("PASSWORD", password.getText().toString());
                editor.commit();
              //  TextView test = (TextView) findViewById(R.id.textTest);
            //    test.setText(sharedPreferences.getString("NAME",""));
                user.userNumber++;
                final long numberUser = user.userNumber;

try {

    final ContentValues contentValueManager = new ContentValues();
    contentValueManager.put("userName", username.getText().toString());
    contentValueManager.put("password", password.getText().toString());
    contentValueManager.put("userNumber", numberUser);

    new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                getContentResolver().insert(TravelContent.Manager.MANAGER_URI, contentValueManager);
                for (int i=0; i<11 ; i++)
                {
                    SystemClock.sleep(500);
                }
                Log.d("TAG","AsyncTask user good");
            }
            catch (Exception e) {
                Log.d("TAG","AsyncTask user not good");
            }
            return null;
        }
    };
}
catch (Exception e)
{
    Toast.makeText(Registery.this ,  "יש בעיה בהוספת משתמש!!" , Toast.LENGTH_LONG).show();
}
                Toast.makeText(Registery.this ,  "number user = "+numberUser+"" , Toast.LENGTH_LONG).show();
                Intent sign = new Intent(Registery.this , MainActivity.class);
                sign.putExtra("USERNAME", username.getText().toString());
             startActivity(sign);
            }}}
        );}
    }

