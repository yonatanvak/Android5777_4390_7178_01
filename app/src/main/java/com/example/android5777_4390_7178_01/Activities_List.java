package com.example.android5777_4390_7178_01;

import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android5777_4390_7178_01.R;
import com.example.android5777_4390_7178_01.model.Activity_type;

public class Activities_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities__list);
    }

    private Activity_type types;
    private String country;
    private Calendar activityStart;
    private Calendar activityEnd;
    private int price;
    private String description;
    private long IDbusines;

    public Activities_List(Activity_type types, String country, Calendar activityStart, Calendar activityEnd,
                           int price, String description, long IDbusiness) {
        this.types = types;
        this.country = country;
        this.activityStart = activityStart;
        this.activityEnd = activityEnd;
        this.price = price;
        this.description = description;
        this.IDbusines = IDbusines;
    }
    public Activities_List(){};

    public Activity_type getTypes() {
        return types;
    }

    public void setTypes(Activity_type types) {
        this.types = types;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Calendar getActivityStart() {
        return activityStart;
    }

    public void setActivityStart(Calendar activityStart) {
        this.activityStart = activityStart;
    }

    public Calendar getActivityEnd() {
        return activityEnd;
    }

    public void setActivityEnd(Calendar activityEnd) {
        this.activityEnd = activityEnd;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getIDbusines() {
        return IDbusines;
    }

    public void setIDbusines(long IDbusines) {
        this.IDbusines = IDbusines;
    }


}
