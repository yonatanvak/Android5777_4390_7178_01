package com.example.android5777_4390_7178_01.model.datasource;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
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
            Log.d("TAG", "bussines almost added");
       businessList.add(new Business(contant_business.getAsLong(TravelContent.Business.business_id)
               ,contant_business.getAsString(TravelContent.Business.business_name),
               contant_business.getAsString(TravelContent.Business.business_street)
               ,contant_business.getAsString(TravelContent.Business.business_country),
               contant_business.getAsString(TravelContent.Business.business_city),
               contant_business.getAsInteger(TravelContent.Business.business_phone),
               contant_business.getAsString(TravelContent.Business.business_email),
               contant_business.getAsString(TravelContent.Business.business_webSite)));
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
                contant_attraction.getAsLong("IDBussines")
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
    public Cursor getManager() {
        String[] columns = new String[]
                {
                        TravelContent.Manager.user_name,
                        TravelContent.Manager.user_number,
                        TravelContent.Manager.user_password,
                };

        MatrixCursor matrixCursor = new MatrixCursor(columns);

        for (Manager m : managerList) {
            matrixCursor.addRow(new Object[]
                    {
                            m.getUserNumber(),
                            m.getName(),
                            m.getPassword()
                    });
        }

        return matrixCursor;
    }

    @Override
    public Cursor getBusiness(){
    String[] columns = new String[]
            {
                    TravelContent.Business.business_id,
                    TravelContent.Business.business_name,
                    TravelContent.Business.business_street,
                    TravelContent.Business.business_country,
                    TravelContent.Business.business_city,
                    TravelContent.Business.business_phone,
                    TravelContent.Business.business_email,
                    TravelContent.Business.business_webSite
            };

    MatrixCursor matrixCursor = new MatrixCursor(columns);

    for (Business b : businessList) {
        matrixCursor.addRow(new Object[]
                {
                        b.getIDbusines(),
                        b.getNameBusines(),
                        b.getAd_street(),
                        b.getAd_country(),
                        b.getAd_city(),
                        b.getPhone(),
                        b.getEmail(),
                        b.getwebSite()
                });
    }

    return matrixCursor;
}
    @Override
    public Cursor getAttraction() {
        String[] columns = new String[]
                {
                        TravelContent.Attraction.activity_type,
                        TravelContent.Attraction.activity_country,
                        TravelContent.Attraction.activity_TStart,
                        TravelContent.Attraction.activity_TEnd,
                        TravelContent.Attraction.activity_price,
                        TravelContent.Attraction.activity_description,
                        TravelContent.Attraction.activity_id
                };

        MatrixCursor matrixCursor = new MatrixCursor(columns);

        for (Attractions a : attractionsesList) {
            matrixCursor.addRow(new Object[]
                    {
                            a.getTypes(),
                            a.getCountry(),
                            a.getActivityEnd(),
                            a.getActivityEnd(),
                            a.getPrice(),
                            a.getDescription(),
                            a.getIDbusines()
                    });
        }
        return matrixCursor;
    }


    @Override
    public boolean checkChanges() {
        if (checkUpBussines || checkUpAttraction)
        {
            checkUpBussines = false;
            checkUpAttraction = false;
            return true;
        }
        return false;
    }

}
