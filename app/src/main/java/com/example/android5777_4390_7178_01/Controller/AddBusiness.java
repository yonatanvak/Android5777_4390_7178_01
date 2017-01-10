package com.example.android5777_4390_7178_01.Controller;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.android5777_4390_7178_01.R;
import com.example.android5777_4390_7178_01.model.datasource.CustomContentProvider;
import com.example.android5777_4390_7178_01.model.datasource.TravelContent;
import com.example.android5777_4390_7178_01.model.entities.Business;

public class AddBusiness extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_business);

        final Business business = new Business();

        findViewById(R.id.buttonAddBusines).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etStreet = (EditText)findViewById( R.id.etStreet );
                EditText etCity = (EditText)findViewById( R.id.etCity );
                EditText etCountry = (EditText)findViewById( R.id.etCountry );
                EditText  etEmail = (EditText)findViewById( R.id.etEmail );
                EditText  etPhone = (EditText)findViewById( R.id.etPhone );
                EditText  etIdBusiness = (EditText)findViewById( R.id.etIdBusiness );
                EditText etBusinessName = (EditText)findViewById( R.id.etUserName);
                EditText   etWebSite = (EditText)findViewById( R.id.etWebSite );

                final ContentValues contentValuesAddBusiness = new ContentValues();

                contentValuesAddBusiness.put(TravelContent.Business.business_name,etBusinessName.toString());
                contentValuesAddBusiness.put(TravelContent.Business.business_id,etIdBusiness.toString());
                contentValuesAddBusiness.put(TravelContent.Business.business_webSite,etWebSite.toString());
                contentValuesAddBusiness.put(TravelContent.Business.business_email,etEmail.toString());
                contentValuesAddBusiness.put(TravelContent.Business.business_phone,etPhone.toString());
                contentValuesAddBusiness.put(TravelContent.Business.business_street,etStreet.toString());
                contentValuesAddBusiness.put(TravelContent.Business.business_city,etCity.toString());
                contentValuesAddBusiness.put(TravelContent.Business.business_country,etCountry.toString());

                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        try{
                        getContentResolver().insert(TravelContent.Business.BUSINESS_URI, contentValuesAddBusiness);
                            Log.d("TAG","AsyncTask bussines not good3");
                            for (int i=0; i<11 ; i++)
                            {
                                SystemClock.sleep(500);
                            }
                            Log.d("TAG","AsyncTask bussines good");
                        }
                        catch (Exception e) {
                            Log.d("TAG","AsyncTask bussines not good");
                        }

                        return null;
                    }
                }.execute();
                
                Log.d("TAG","AsyncTask bussines not good2");
                Intent intent = new Intent(AddBusiness.this , AddAttraction.class);
                intent.putExtra("ID BUSSINES",etIdBusiness.getText().toString());
                startActivity(intent);
            }}
        );}


}
