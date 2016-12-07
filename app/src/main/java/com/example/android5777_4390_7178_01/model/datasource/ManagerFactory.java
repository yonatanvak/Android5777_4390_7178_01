package com.example.android5777_4390_7178_01.model.datasource;

import android.content.Context;

import com.example.android5777_4390_7178_01.model.backend.IDSManager;

/**
 * Created by יונתן on 04/12/2016.
 */

public class ManagerFactory {
    static IDSManager instance = null;

    public static String mode = "ListDsManager";

    public final static IDSManager getInstance(Context context)
    {
        if (mode == "RemoteDsManager")
        {
            if (instance == null)
                instance = new com.example.android5777_4390_7178_01.model.datasource.ListDsManager(context);
            return instance;
        }

        if (mode == "ListDsManager")
        {
            if (instance == null)
                instance = new com.example.android5777_4390_7178_01.model.datasource.ListDsManager(context);
            return instance;
        }

        else return null;
    }
}
