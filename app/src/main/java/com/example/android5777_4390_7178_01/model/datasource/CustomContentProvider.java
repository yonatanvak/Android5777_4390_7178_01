package com.example.android5777_4390_7178_01.model.datasource;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.android5777_4390_7178_01.model.backend.IDSManager;

import java.util.HashMap;

public class CustomContentProvider extends ContentProvider {
    public CustomContentProvider() {
    }

    public static IDSManager dsManager = ManagerFactory.getDSManger("ListDsManager");

    static final String PROVIDER_NAME = "com.example.android5777_4390_7178_01.model.datasource";
  //  static final String URL = "content://" + PROVIDER_NAME + "/cte";
    static final Uri MANAGER_CONTENT_URL = Uri.parse("content://" + PROVIDER_NAME + "/manager");
    static final Uri BUSINESS_CONTENT_URL = Uri.parse("content://" + PROVIDER_NAME + "/business");
    static final Uri ACTIVITIES_CONTENT_URL = Uri.parse("content://" + PROVIDER_NAME + "/activities");

    static final int URI_MANAGER = 1;
    static final int URI_BUSINESS = 2;
    static final int URI_ACTIVITIES = 3;

    static final String user_name = "user_name";
    static final String user_number = "user_number";
    static final String user_password = "user_password";

    static final String business_name = "business_name";
    static final String business_id = "business_id";
    static final String business_street = "business_street";
    static final String business_country = "business_country";
    static final String business_city = "business_city";
    static final String business_phone = "business_phone";
    static final String business_email = "business_email";
    static final String business_webSite = "business_webSite";

    static final String activity_type = "activity_type";
    static final String activity_country = "activity_country";
    static final String activity_TStart = "activity_TStart";
    static final String activity_TEnd = "activity_TEnd";
    static final String activity_price = "activity_price";
    static final String activity_description = "activity_description";
    static final String activity_id = "activity_id";

   // private static HashMap <String , String> valuse;

    static final UriMatcher uriMatcher;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME,"manager",URI_MANAGER);
        uriMatcher.addURI(PROVIDER_NAME,"business",URI_BUSINESS);
        uriMatcher.addURI(PROVIDER_NAME,"activities",URI_ACTIVITIES);
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
   switch (uriMatcher.match(uri))
   {
       case URI_MANAGER:
           dsManager.addManager(values);
           break;
       case URI_BUSINESS:
           dsManager.addBusiness(values);
           break;
       case URI_ACTIVITIES:
           dsManager.addActivity(values);
           break;
   }
        // TODO: Implement this to handle requests to insert a new row.
     //   throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
     /*Cursor result = null;
        switch (uriMatcher.match(uri))
        {
            case URI_MANAGER:
        }*/
        // TODO: Implement this to handle query requests from clients.
       throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        return null;
        //  throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        //  throw new UnsupportedOperationException("Not yet implemented");
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
    //    throw new UnsupportedOperationException("Not yet implemented");
        return 0;
    }
}
