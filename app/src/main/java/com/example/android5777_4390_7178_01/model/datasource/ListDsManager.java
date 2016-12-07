package com.example.android5777_4390_7178_01.model.datasource;

import android.content.Context;

import com.example.android5777_4390_7178_01.model.backend.IDSManager;
import com.example.android5777_4390_7178_01.model.entities.Activities_List;
import com.example.android5777_4390_7178_01.model.entities.Business;
import com.example.android5777_4390_7178_01.model.entities.Manager;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by יונתן on 01/12/2016.
 */

public class ListDsManager implements IDSManager {

    public ListDsManager(Context context) {}

    final ArrayList<Manager> managerList = new ArrayList<Manager>();
    final ArrayList<Business> businessList = new ArrayList<Business>();
    final ArrayList<Activities_List> activityList = new ArrayList<Activities_List>();


    @Override
    public ArrayList<Activities_List> getActivityList() {return activityList;}

    @Override
    public ArrayList<Business> getBusinessList() {return businessList;}

    @Override
    public ArrayList<Manager> getManagerList() {return managerList;}

    @Override
    public void addActivity(Activities_List activities) throws IOException {
        activityList.add(activities);
    }

    @Override
    public void addBusiness(Business business) throws IOException {
        businessList.add(business);
    }

    @Override
    public void addManager(Manager manager) {
        managerList.add(manager);
    }

    @Override
    public void reportChanges() {

    }

    @Override
    public Boolean checkChanges() {
        return null;
    }
}
