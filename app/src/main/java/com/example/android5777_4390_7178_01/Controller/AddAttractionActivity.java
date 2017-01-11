package com.example.android5777_4390_7178_01.Controller;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
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

import java.util.Calendar;

import static com.example.android5777_4390_7178_01.R.id.spinner;

public class AddAttractionActivity extends Activity implements View.OnClickListener {

    private Button addAttractionButton;
    private EditText description;
    private EditText country;
    private EditText  price;
    private Spinner spinner;
    private TextView idBussines;
    private String type;
    private Button sDate;
    private Button eDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attraction);
        findViews();
    }

    @Override
    public void onClick(View v) {
        if (v == addAttractionButton) {
            addAttraction();
        }
    }

    private void findViews() {

        spinner = (Spinner) findViewById(R.id.spinnerAttraction);
        spinner.setAdapter(new ArrayAdapter<Activity_type>(this, android.R.layout.simple_spinner_item, Activity_type.values()));

        sDate = (Button) findViewById(R.id.buttonSdate);
        eDate = (Button) findViewById(R.id.buttonEdate);
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
                        DatePickerDialog dpd = new DatePickerDialog(AddAttractionActivity.this, android.R.style.Theme_Holo_Light_Dialog,
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
                        DatePickerDialog dpd = new DatePickerDialog(AddAttractionActivity.this, android.R.style.Theme_Holo_Light_Dialog,
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

        description = (EditText)findViewById( R.id.etDescription );
        country = (EditText)findViewById( R.id.etCountry );
        price = (EditText)findViewById( R.id.etPrice );
        //  EditText  startDate = (EditText)findViewById( R.id.etEndDate);
        //   EditText  endDate = (EditText)findViewById( R.id.etEndDate);
        type = ((Activity_type)spinner.getSelectedItem()).name();
        Log.d("TAG","type"+type.toString());
        addAttractionButton = (Button) findViewById(R.id.buttonAddAtraction);
        addAttractionButton.setOnClickListener(this);

        idBussines = (TextView) findViewById( R.id.tVID );
        idBussines.setText(getIntent().getStringExtra("ID BUSSINES"));

        final Uri uri = TravelContent.Attraction.ATTRACTION_URI;
    }

    private void addAttraction() {

        final Uri uri = TravelContent.Attraction.ATTRACTION_URI;

        final ContentValues contentValuesAttarction = new ContentValues();

        contentValuesAttarction.put(TravelContent.Attraction.activity_type, String.valueOf(type.toString()));
        contentValuesAttarction.put(TravelContent.Attraction.activity_country,country.getText().toString());
        contentValuesAttarction.put(TravelContent.Attraction.activity_TStart,sDate.getText().toString());
        contentValuesAttarction.put(TravelContent.Attraction.activity_TEnd,eDate.getText().toString());
        contentValuesAttarction.put(TravelContent.Attraction.activity_price,price.getText().toString());
        contentValuesAttarction.put(TravelContent.Attraction.activity_description,description.getText().toString());
        contentValuesAttarction.put(TravelContent.Attraction.activity_id,idBussines.getText().toString());


        new AsyncTask<Void, Void, Uri>() {
            @Override
            protected Uri doInBackground(Void... params) {
                Log.d("TAG","AsyncTask Attarction good");
                getContentResolver().insert(uri, contentValuesAttarction);
                Log.d("TAG","content Attarction good");
                return null;
            }

            @Override
            protected void onPostExecute(Uri uriResult) {
                super.onPostExecute(uriResult);
                Log.d("TAG","AsyncTask Attarction NOT good");
                Toast.makeText(getBaseContext(), "insert id: " + idBussines.getText().toString(), Toast.LENGTH_LONG).show();

                //  updateItemList(uri);
            }
        }.execute();
    }
}

