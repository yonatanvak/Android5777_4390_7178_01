package com.example.android5777_4390_7178_01.model.backend;

import android.content.ContentValues;
import android.content.Context;

import com.example.android5777_4390_7178_01.model.backend.IDSManager;
import com.example.android5777_4390_7178_01.model.datasource.ListDsManager;
import com.example.android5777_4390_7178_01.model.datasource.RemoteDsManager;
import com.example.android5777_4390_7178_01.model.entities.Activities_List;
import com.example.android5777_4390_7178_01.model.entities.Business;
import com.example.android5777_4390_7178_01.model.entities.Manager;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by יונתן on 04/12/2016.
 */

public class ManagerFactory {

     static IDSManager instance = null;

      public static String mode = "ListDsManager";

    public final static IDSManager getDSManger(String mode) {
        IDSManager DSManager;

       /* switch (mode) {
            case "ListDsManager":
                DSManager = new ListDsManager();
                break;
            case "RemoteDsManager":
                DSManager = new RemoteDsManager();
                break;
            default:
                DSManager = null;
        }
        return DSManager;*/

        if (mode == "RemoteDsManager")
        {
            DSManager = new ListDsManager();
           if (instance == null)
                instance = new com.example.android5777_4390_7178_01.model.datasource.ListDsManager();
            return instance;
        }

        if (mode == "ListDsManager")
        {
            DSManager = new RemoteDsManager();
            if (instance == null)
                instance = new com.example.android5777_4390_7178_01.model.datasource.RemoteDsManager();
            return instance;
        }

        else return null;

    }
}
