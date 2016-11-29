package com.example.android5777_4390_7178_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android5777_4390_7178_01.R;

public class Business extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);
    }

    private long IDbusines;
    private String nameBusines;
    private String Ad_street;
    private String Ad_country;
    private String Ad_city;
    private int phone;
    private String Email;
    private String Link;

    public Business(long IDbusines, String nameBusines, String ad_street, String ad_country,
                           String ad_city, int phone, String email, String link) {
        this.IDbusines = IDbusines;
        this.nameBusines = nameBusines;
        Ad_street = ad_street;
        Ad_country = ad_country;
        Ad_city = ad_city;
        this.phone = phone;
        Email = email;
        Link = link;
    }

    public long getIDbusines() {
        return IDbusines;
    }

    public void setIDbusines(long IDbusines) {
        this.IDbusines = IDbusines;
    }

    public String getNameBusines() {
        return nameBusines;
    }

    public void setNameBusines(String nameBusines) {
        this.nameBusines = nameBusines;
    }

    public String getAd_street() {
        return Ad_street;
    }

    public void setAd_street(String ad_street) {
        Ad_street = ad_street;
    }

    public String getAd_country() {
        return Ad_country;
    }

    public void setAd_country(String ad_country) {
        Ad_country = ad_country;
    }

    public String getAd_city() {
        return Ad_city;
    }

    public void setAd_city(String ad_city) {
        Ad_city = ad_city;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }


}
