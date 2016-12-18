package com.example.android5777_4390_7178_01.model.backend;

import android.content.ContentValues;

import com.example.android5777_4390_7178_01.model.entities.Activities_List;
import com.example.android5777_4390_7178_01.model.entities.Attractions;
import com.example.android5777_4390_7178_01.model.entities.Business;
import com.example.android5777_4390_7178_01.model.entities.Manager;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by יונתן on 01/12/2016.
 */

public interface IDSManager {

    final ArrayList<Manager> managerList = new ArrayList<Manager>();
    final ArrayList<Business> businessList = new ArrayList<Business>();
    final ArrayList<Attractions> attractions = new ArrayList<Attractions>();

    void addManager(ContentValues contant_manager);
    void addBusiness(ContentValues contant_business);
    void addAttraction(ContentValues contant_attraction);

    public ArrayList<Manager> getManagerList();
    public ArrayList<Business> getBusinessList();
    public ArrayList<Attractions> getAttraction();

    Boolean checkChanges();
    void reportChanges();

    ///////////////////----seif h--/////////////

}
