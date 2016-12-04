package com.example.android5777_4390_7178_01.model.backend;

import com.example.android5777_4390_7178_01.model.entities.Activities_List;
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
    final ArrayList<Activities_List> activityList = new ArrayList<Activities_List>();

    void addManager(Manager manager) ;
    void addBusiness(Business business) throws IOException;
    void addActivity(Activities_List activities) throws IOException;

    public ArrayList<Manager> getManagerList();
    public ArrayList<Business> getBusinessList();
    public ArrayList<Activities_List> getActivityList();

    ///////////////////----seif h--/////////////

}
