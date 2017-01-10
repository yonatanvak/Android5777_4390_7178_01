package com.example.android5777_4390_7178_01.Controller;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android5777_4390_7178_01.R;
import com.example.android5777_4390_7178_01.model.datasource.TravelContent;
import com.example.android5777_4390_7178_01.model.entities.Activity_type;
import com.example.android5777_4390_7178_01.model.datasource.CustomContentProvider;

import java.util.Calendar;

public class AddAttraction extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attraction);


        final Spinner spinner = (Spinner) findViewById(R.id.spinnerAttraction);
        spinner.setAdapter(new ArrayAdapter<Activity_type>(this, android.R.layout.simple_spinner_item, Activity_type.values()));

        final Button sDate = (Button) findViewById(R.id.buttonSdate);
        final Button eDate = (Button) findViewById(R.id.buttonEdate);
        final Calendar c = Calendar.getInstance();
        final int mYear = c.get(Calendar.YEAR);
        final int mMonth = c.get(Calendar.MONTH);
        final int mDay = c.get(Calendar.DAY_OF_MONTH);

        sDate.setText(mDay + "/" + (mMonth + 1) + "/" + mYear);
        sDate.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(View view) {
                        final Calendar c = Calendar.getInstance();
                        DatePickerDialog dpd = new DatePickerDialog(AddAttraction.this, android.R.style.Theme_Holo_Light_Dialog,
                                new DatePickerDialog.OnDateSetListener() {

                                    @Override
                                    public void onDateSet(DatePicker view, int year,
                                                          int monthOfYear, int dayOfMonth) {
                                        // Display Selected date in textbox
                                        sDate.setText(dayOfMonth + "/"
                                                + (monthOfYear + 1) + "/" + year);

                                    }
                                }, mYear, mMonth, mDay);
                        dpd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dpd.show();
                    }

                }
        );

        eDate.setText(mDay + "/" + (mMonth + 1) + "/" + mYear);
        eDate.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(View view) {
                        final Calendar c = Calendar.getInstance();
                        DatePickerDialog dpd = new DatePickerDialog(AddAttraction.this, android.R.style.Theme_Holo_Light_Dialog,
                                new DatePickerDialog.OnDateSetListener() {

                                    @Override
                                    public void onDateSet(DatePicker view, int year,
                                                          int monthOfYear, int dayOfMonth) {
                                        // Display Selected date in textbox
                                        eDate.setText(dayOfMonth + "/"
                                                + (monthOfYear + 1) + "/" + year);

                                    }
                                }, mYear, mMonth, mDay);
                        dpd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dpd.show();
                    }

                }
        );
       final TextView idBussines = (TextView) findViewById( R.id.tVID );
        idBussines.setText(getIntent().getStringExtra("ID BUSSINES"));

        findViewById(R.id.buttonAddAtraction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText description = (EditText)findViewById( R.id.etDescription );
                EditText country = (EditText)findViewById( R.id.etCountry );
                EditText  price = (EditText)findViewById( R.id.etPrice );
                //  EditText  startDate = (EditText)findViewById( R.id.etEndDate);
                //   EditText  endDate = (EditText)findViewById( R.id.etEndDate);
                String type = ((Activity_type)spinner.getSelectedItem()).name();
                Log.d("TAG","type"+type.toString());
                final ContentValues contentValuesAttarction = new ContentValues();

                contentValuesAttarction.put(TravelContent.Attraction.activity_type, String.valueOf(type.toString()));
                contentValuesAttarction.put(TravelContent.Attraction.activity_country,country.toString());
                contentValuesAttarction.put(TravelContent.Attraction.activity_TStart,sDate.getText().toString());
                contentValuesAttarction.put(TravelContent.Attraction.activity_TEnd,eDate.getText().toString());
                contentValuesAttarction.put(TravelContent.Attraction.activity_price,price.toString());
                contentValuesAttarction.put(TravelContent.Attraction.activity_description,description.toString());
                contentValuesAttarction.put(TravelContent.Attraction.activity_id,idBussines.toString());

                new AsyncTask<Void, Void, Uri>() {
                    @Override
                    protected Uri doInBackground(Void... params) {
                        try{
                            Log.d("TAG","AsyncTask attraction good");
                        getContentResolver().insert(TravelContent.Attraction.ATTRACTION_URI, contentValuesAttarction);
                            Log.d("TAG","AsyncTask attraction good1");
                            for (int i=0; i<11 ; i++)
                            {
                                SystemClock.sleep(500);
                            }
                            Log.d("TAG","AsyncTask attraction good3");
                        }
                        catch (Exception e) {
                            Log.d("TAG","AsyncTask attraction not good");
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Uri uriResult) {
                        super.onPostExecute(uriResult);
                        Log.d("TAG","AsyncTask bussines NOT good");
                        Toast.makeText(getBaseContext(), "insert id: " + idBussines.toString(), Toast.LENGTH_LONG).show();

                        //  updateItemList(uri);
                    }
                }.execute();

                Intent intent = new Intent(AddAttraction.this , MainActivity.class);
                intent.putExtra("ID BUSSINES",idBussines.getText().toString());
                startActivity(intent);
            }}
        );}
}










