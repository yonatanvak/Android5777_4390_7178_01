package com.example.android5777_4390_7178_01.model.datasource;

import android.content.ContentValues;

import com.example.android5777_4390_7178_01.model.backend.IDSManager;
import com.example.android5777_4390_7178_01.model.entities.Activities_List;
import com.example.android5777_4390_7178_01.model.entities.Attractions;
import com.example.android5777_4390_7178_01.model.entities.Business;
import com.example.android5777_4390_7178_01.model.entities.Manager;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by יונתן on 01/12/2016.
 */

public class RemoteDsManager implements IDSManager{
    @Override
    public void addManager(ContentValues contant_manager){

    }

    @Override
    public void addBusiness(ContentValues contant_business){

    }

    @Override
    public void addAttraction(ContentValues contant_attraction) {

    }

    @Override
    public ArrayList<Manager> getManagerList() {
        return null;
    }

    @Override
    public ArrayList<Business> getBusinessList() {
        return null;
    }

    @Override
    public ArrayList<Attractions> getAttraction() {
        return null;
    }

    @Override
    public Boolean checkChanges() {
        return null;
    }

    @Override
    public void reportChanges() {

    }
}
