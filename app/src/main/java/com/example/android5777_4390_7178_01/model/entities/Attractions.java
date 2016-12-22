package com.example.android5777_4390_7178_01.model.entities;

import android.icu.util.Calendar;

import com.example.android5777_4390_7178_01.model.Activity_type;

/**
 * Created by יונתן on 22/12/2016.
 */

public class Attractions {

    private Activity_type types;
    private String country;
    private Calendar activityStart;
    private Calendar activityEnd;
    private int price;
    private String description;
    private long IDbusines;

    public  Attractions(Activity_type types, String country, Calendar activityStart, Calendar activityEnd,
                        int price, String description, Long IDbusiness) {
        this.types = types;
        this.country = country;
        this.activityStart = activityStart;
        this.activityEnd = activityEnd;
        this.price = price;
        this.description = description;
        this.IDbusines = IDbusines;
    }
    public  Attractions(){};

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
