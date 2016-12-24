package com.example.android5777_4390_7178_01.Controller;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.android5777_4390_7178_01.R;
import com.example.android5777_4390_7178_01.model.datasource.CustomContentProvider;
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
                contentValuesAddBusiness.put("businessName",etBusinessName.toString());
                contentValuesAddBusiness.put("IdBusiness",etIdBusiness.toString());
                contentValuesAddBusiness.put("WebSite",etWebSite.toString());
                contentValuesAddBusiness.put("Email",etEmail.toString());
                contentValuesAddBusiness.put("Phone",etPhone.toString());
                contentValuesAddBusiness.put("AStreet",etStreet.toString());
                contentValuesAddBusiness.put("ACity",etCity.toString());
                contentValuesAddBusiness.put("ACountry",etCountry.toString());

                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        getContentResolver().insert(CustomContentProvider.BUSINESS_CONTENT_URL, contentValuesAddBusiness);
                        return null;
                    }
                };
            }}
        );}


}
