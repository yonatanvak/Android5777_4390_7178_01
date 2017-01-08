package com.example.android5777_4390_7178_01.model.datasource;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import com.example.android5777_4390_7178_01.model.entities.Activity_type;
import com.example.android5777_4390_7178_01.model.backend.IDSManager;
import com.example.android5777_4390_7178_01.model.entities.Attractions;
import com.example.android5777_4390_7178_01.model.entities.Business;
import com.example.android5777_4390_7178_01.model.entities.Manager;

import java.util.ArrayList;

/**
 * Created by יונתן on 08/12/2016.
 */

public class ListDsManager implements IDSManager {


    final ArrayList<Manager> managerList = new ArrayList<Manager>();
    final ArrayList<Business> businessList = new ArrayList<Business>();
    final ArrayList<Attractions> attractionsesList = new ArrayList< Attractions>();
    boolean checkUpBussines = false;
    boolean checkUpAttraction = false;

    @Override
    public void addManager(ContentValues contant_manager)  {

        try {
            managerList.add(new Manager(contant_manager.getAsLong("userNumber"), contant_manager.getAsString("password"),
                    contant_manager.getAsString("userName")));
            Log.d("TAG", "user added");
        }
        catch (Exception e) {
            Log.d("TAG", "user not added");
        }
        }

    @Override
    public void addBusiness(ContentValues contant_business){
        try
        {
       businessList.add(new Business(contant_business.getAsLong("IdBusiness"),contant_business.getAsString("businessName"),
               contant_business.getAsString("AStreet"),contant_business.getAsString("ACountry"), contant_business.getAsString("ACity"),
               contant_business.getAsInteger("Phone"),contant_business.getAsString("Email"),contant_business.getAsString("WebSite")));
        Log.d("TAG", "bussines added");
    }
    catch (Exception e) {
        Log.d("TAG", "bussines not added");
    }
        checkUpBussines = true;
    }

    @Override
    public void addAttraction(ContentValues contant_attraction) {
       // SimpleDateFormat dateAttraction = new SimpleDateFormat("DD/MM/YYYY", Locale.ENGLISH);

      //  Calendar dateS = dateAttraction.getCalendar();
      //  Calendar dateE = dateAttraction.getCalendar();

        try {
          //  dateS.setTime(dateAttraction.parse(contant_attraction.getAsString("activityStart")));
          //  dateE.setTime(dateAttraction.parse(contant_attraction.getAsString("activityEnd")));

            Activity_type activity_type= Activity_type.valueOf(contant_attraction.getAsString("type"));

             attractionsesList.add(new Attractions(activity_type,contant_attraction.getAsString("country")
                ,contant_attraction.getAsString("activityStart"),contant_attraction.getAsString("activityEnd"),
                     contant_attraction.getAsInteger("price"),contant_attraction.getAsString("description"),
                contant_attraction.getAsLong("idBussines")
                      ));
            Log.d("TAG", "Attraction added");
        }
        catch (Exception ex)
        {
            Log.d("TAG", "Attraction not added");
        }
        checkUpAttraction = true;
    }

    @Override
    public Cursor getManager() {return null;}

    @Override
    public Cursor getBusiness() {return null;}
    @Override
    public Cursor getAttraction() {
        return null;
    }


    @Override
    public Boolean checkChanges() {
        if (checkUpBussines || checkUpAttraction)
        {
            checkUpBussines = false;
            checkUpAttraction = false;
            return true;
        }
        return false;
    }

    @Override
    public void reportChanges() {

    }
}
