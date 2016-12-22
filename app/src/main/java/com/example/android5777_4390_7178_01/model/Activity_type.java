package com.example.android5777_4390_7178_01.model;

/**
 * Created by יונתן on 29/11/2016.
 */

public enum Activity_type {VACATION_PACKEGE("vacation packege") , TRAVEL_AGENCY("travel agency") ,
    ENTERTAINMENT("entertainment") , AIRLINES("airlines") , EXCURESIONS("excuresions");

    private String friendlyName;

    private Activity_type(String friendlyName){
        this.friendlyName = friendlyName;
    }

    @Override public String toString(){
        return friendlyName;
    }

}