package com.example.android5777_4390_7178_01.Controller;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android5777_4390_7178_01.R;
import com.example.android5777_4390_7178_01.model.datasource.TravelContent;

public class AddBusinessActivity extends Activity implements View.OnClickListener {

    private EditText idEditText;
    private EditText nameEditText;
    private EditText minGradeEditText;
    private CheckBox requiredCheckBox;
    private Spinner lecturerIdSpinner;
    private Button addCourseButton;
    private ListView itemListView;
    private TextView loadingTextView;

    private EditText etStreet;
    private EditText etCity;
    private EditText etCountry;
    private EditText  etEmail;
    private EditText  etPhone;
    private EditText  etIdBusiness;
    private EditText etBusinessName;
    private EditText   etWebSite;
    private Button addBusinessButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_business);
        findViews();
    }

    @Override
    public void onClick(View v) {
        if (v == addBusinessButton) {
            addBusiness();
        }
    }

    private void findViews() {
        etStreet = (EditText) findViewById(R.id.etStreet);
        etCity = (EditText) findViewById(R.id.etCity);
        etCountry = (EditText) findViewById(R.id.etCountry);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etIdBusiness = (EditText) findViewById(R.id.etIdBusiness);
        etBusinessName = (EditText) findViewById(R.id.etUserName);
        etWebSite = (EditText) findViewById(R.id.etWebSite);
        addBusinessButton = (Button) findViewById(R.id.buttonAddBusines);
        addBusinessButton.setOnClickListener(this);

        final Uri uri = TravelContent.Business.BUSINESS_URI;
    }
     //   updateItemList(uri);


     /*   new AsyncTask<Void, Void, Cursor>() {
            @Override
            protected Cursor doInBackground(Void... params) {
                return getContentResolver().query(TravelContent.Attraction.ATTRACTION_URI, null, null, null, null);
            }

            @Override
            protected void onPostExecute(Cursor cursor) {
                super.onPostExecute(cursor);
                CursorAdapter adapter = new CursorAdapter(AddBusinessActivity.this, cursor) {
                    @Override
                    public View newView(Context context, Cursor cursor, ViewGroup parent) {
                        TextView tv = new TextView(context);
                        tv.setTextSize(15);
                        tv.setTextColor(Color.BLUE);
                        return tv;
                    }

                    @Override
                    public void bindView(View view, Context context, Cursor cursor) {
                        TextView tv = (TextView) view;
                        tv.setText("[" + cursor.getString(0) + "]  " + cursor.getString(1));
                    }
                };
                lecturerIdSpinner.setAdapter(adapter);
                lecturerIdSpinner.setEnabled(true);
            }
        }.execute();
    }*/

    /*private void updateItemList(final Uri uri) {

        new AsyncTask<Void, Void, Cursor>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                itemListView.setVisibility(View.INVISIBLE);
                loadingTextView.setVisibility(View.VISIBLE);
            }

            @Override
            protected Cursor doInBackground(Void... params) {
                return getContentResolver().query(uri, null, null, null, null);
                // return null;
            }

            @Override
            protected void onPostExecute(Cursor cursor) {
                super.onPostExecute(cursor);
                CursorAdapter adapter = new CursorAdapter(AddBusinessActivity.this, cursor) {
                    @Override
                    public View newView(Context context, Cursor cursor, ViewGroup parent) {
                        TextView tv = new TextView(context);

                        return tv;
                    }

                    @Override
                    public void bindView(View view, Context context, Cursor cursor) {
                        TextView tv = (TextView) view;
                        tv.setText("[" + cursor.getString(0) + "]  " + cursor.getString(1));
                    }


                };

                itemListView.setAdapter(adapter);
                itemListView.setVisibility(View.VISIBLE);
                loadingTextView.setVisibility(View.INVISIBLE);
            }
        }.execute();

    }*/

    private void addBusiness() {

        final Uri uri = TravelContent.Business.BUSINESS_URI;
        final ContentValues contentValuesAddBusiness = new ContentValues();

        contentValuesAddBusiness.put(TravelContent.Business.business_id,etIdBusiness.toString());
        contentValuesAddBusiness.put(TravelContent.Business.business_name,etBusinessName.toString());
        contentValuesAddBusiness.put(TravelContent.Business.business_street,etStreet.toString());
        contentValuesAddBusiness.put(TravelContent.Business.business_country,etCountry.toString());
        contentValuesAddBusiness.put(TravelContent.Business.business_city,etCity.toString());
        contentValuesAddBusiness.put(TravelContent.Business.business_phone,etPhone.toString());
        contentValuesAddBusiness.put(TravelContent.Business.business_email,etEmail.toString());
        contentValuesAddBusiness.put(TravelContent.Business.business_webSite,etWebSite.toString());

        new AsyncTask<Void, Void, Uri>() {
            @Override
            protected Uri doInBackground(Void... params) {
                Log.d("TAG","AsyncTask bussines good");
                getContentResolver().insert(uri, contentValuesAddBusiness);
                Log.d("TAG","content bussines good");
                return null;
            }

            @Override
            protected void onPostExecute(Uri uriResult) {
                super.onPostExecute(uriResult);
                Log.d("TAG","AsyncTask bussines NOT good");
                    Toast.makeText(getBaseContext(), "insert id: " + etIdBusiness.toString(), Toast.LENGTH_LONG).show();

              //  updateItemList(uri);
            }
        }.execute();
    }
}

