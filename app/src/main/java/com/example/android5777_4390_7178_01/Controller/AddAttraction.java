package com.example.android5777_4390_7178_01.Controller;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.android5777_4390_7178_01.R;
import com.example.android5777_4390_7178_01.model.Activity_type;
import com.example.android5777_4390_7178_01.model.datasource.CustomContentProvider;

public class AddAttraction extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attraction);


        final Spinner spinner = (Spinner) findViewById(R.id.spinnerAttraction);
        spinner.setAdapter(new ArrayAdapter<Activity_type>(this, android.R.layout.simple_spinner_item, Activity_type.values()));

        findViewById(R.id.buttonAddAtraction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText description = (EditText)findViewById( R.id.etDescription );
                EditText idBussines = (EditText)findViewById( R.id.etIdBussines );
                EditText country = (EditText)findViewById( R.id.etCountry );
                EditText  price = (EditText)findViewById( R.id.etPrice );
                EditText  startDate = (EditText)findViewById( R.id.etEndDate);
                EditText  endDate = (EditText)findViewById( R.id.etEndDate);
                String type = ((Activity_type)spinner.getSelectedItem()).name();

                final ContentValues contentValuesAttarction = new ContentValues();
                contentValuesAttarction.put("description",description.toString());
                contentValuesAttarction.put("idBussines",idBussines.toString());
                contentValuesAttarction.put("country",country.toString());
                contentValuesAttarction.put("price",price.toString());
                contentValuesAttarction.put("startDate",startDate.toString());
                contentValuesAttarction.put("endDate",endDate.toString());
                contentValuesAttarction.put("type",type.toString());

                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        getContentResolver().insert(CustomContentProvider.ATTRACTION_CONTENT_URL, contentValuesAttarction);
                        return null;
                    }
                };
            }}
        );}
}










