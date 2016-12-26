package com.example.android5777_4390_7178_01.model.SharedPreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android5777_4390_7178_01.R;

/**
 * Created by יונתן on 15/12/2016.
 */

public class SharedPreferencesClass extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        findViews();
    }

    private EditText nameLoginEditText;
    private EditText passwordLoginEditText;
    private EditText nameUserEditText;
    private EditText numberUserEditText;
    private EditText passwordUserEditText;

    private Button saveButton;
    private Button loginButton;
    private Button clearButton;

private void findViews()

    {
        nameUserEditText = (EditText) findViewById(R.id.etUserName);
        passwordUserEditText = (EditText) findViewById(R.id.etPassword);
        saveButton = (Button) findViewById(R.id.buttonSign);
     //   loginButton = (Button) findViewById(R.id.buttonSign);
    }

    public void onClick(View v) {
       saveSharedPreferences();
    }

    private void clearSharedPreferences() {///////--------------////////////////
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        passwordUserEditText.setText("");
        Toast.makeText(this, "clear Preferences", Toast.LENGTH_SHORT).show();
    }

    private void loadSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        if (sharedPreferences.contains("NAME USER")) {
            nameUserEditText.setText(sharedPreferences.getString("NAME USER", null));
            Toast.makeText(this, "loading...user name", Toast.LENGTH_SHORT).show();
        }
        if (sharedPreferences.contains("PASSWORD")) {
            int password = sharedPreferences.getInt("PASSWORD", 0);
            numberUserEditText.setInputType(Integer.valueOf(password));
            Toast.makeText(this, "loading...password", Toast.LENGTH_SHORT).show();
        }
    }

    public void saveSharedPreferences() {
        try {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            String name = nameUserEditText.getText().toString();
        //    int numberUser = Integer.parseInt(numberUserEditText.getText().toString());
            int passwoedUser = Integer.parseInt(passwordUserEditText.getText().toString());
//    editor.putInt("NUMBER_USER", numberUser);
            editor.putString("NAME", name);

            editor.putInt("PASSWOER_USER", passwoedUser);
            editor.commit();

            Toast.makeText(this, "save name and number and password Preferences", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Toast.makeText(this, "failed to save Preferences", Toast.LENGTH_SHORT).show();
        }
    }



}
//-----------------------------------------------------------------------------
/*  private EditText nameEditText;
    private EditText ageEditText;
    private Button saveButton;
    private Button loadButton;
    private Button clearButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2016-11-27 18:11:06 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    /*
private void findViews() {
    nameEditText = (EditText) findViewById(R.id.nameEditText);
    ageEditText = (EditText) findViewById(R.id.ageEditText);
    saveButton = (Button) findViewById(R.id.saveButton);
    loadButton = (Button) findViewById(R.id.loadButton);
    clearButton = (Button) findViewById(R.id.clearButton);

    saveButton.setOnClickListener(this);
    loadButton.setOnClickListener(this);
    clearButton.setOnClickListener(this);
}

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2016-11-27 18:11:06 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    /*
    @Override
    public void onClick(View v) {
        if (v == saveButton) {
            saveSharedPreferences();
        } else if (v == loadButton) {
            loadSharedPreferences();
        } else if (v == clearButton) {
            clearSharedPreferences();
        }
    }

    private void clearSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        nameEditText.setText("");
        ageEditText.setText("");
        Toast.makeText(this, "clear Preferences", Toast.LENGTH_SHORT).show();
    }

    private void loadSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        if (sharedPreferences.contains("NAME")) {
            nameEditText.setText(sharedPreferences.getString("NAME", null));
            Toast.makeText(this, "load name", Toast.LENGTH_SHORT).show();
        }
        if (sharedPreferences.contains("AGE")) {
            int age = sharedPreferences.getInt("AGE", 0);
            ageEditText.setText(String.valueOf(age));
            Toast.makeText(this, "load age", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveSharedPreferences() {
        try {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            String name = nameEditText.getText().toString();
            int age = Integer.parseInt(ageEditText.getText().toString());

            editor.putString("NAME", name);
            editor.putInt("AGE", age);
            editor.commit();
            Toast.makeText(this, "save name and age Preferences", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Toast.makeText(this, "failed to save Preferences", Toast.LENGTH_SHORT).show();
        }
    }



}
*/