package com.example.android5777_4390_7178_01.model.backend;

import com.example.android5777_4390_7178_01.model.datasource.MySQL_DSManager;

/**
 * Created by יונתן on 04/12/2016.
 */

public class ManagerFactory {

    /* static IDSManager instance = null;

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

     /*   if (mode == "RemoteDsManager")
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

    }*/

    static IDSManager manager = null;

    public static IDSManager getManager() {
        if (manager == null)
            manager = new MySQL_DSManager();
        return manager;
    }
}

