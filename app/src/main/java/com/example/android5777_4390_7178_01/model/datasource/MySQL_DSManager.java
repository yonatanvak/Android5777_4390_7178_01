package com.example.android5777_4390_7178_01.model.datasource;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.util.Log;

import com.example.android5777_4390_7178_01.model.backend.IDSManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by יונתן on 08/01/2017.
 */

public class MySQL_DSManager implements IDSManager {

    private final String UserName = "benaya";
    private final String WEB_URL = "http://"+UserName+".vlab.jct.ac.il";

    private boolean updateFlag = false;

    public void printLog(String message)
    {
        Log.d(this.getClass().getName(),"\n"+message);
    }

    public void printLog(Exception message)
    {
        Log.d(this.getClass().getName(),"Exception-->\n"+message);
    }

    @Override
    public void addManager(ContentValues values) {
        try {
            String result = PHPTools.POST(WEB_URL + "/Manager.php", values);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addManager:\n" + result);
        } catch (IOException e) {
            printLog("addStudent Exception:\n" + e);
        }
    }

    @Override
    public void addBusiness(ContentValues values) {
        try {
            String result = PHPTools.POST(WEB_URL + "/businesss.php", values);
          //  long id = Long.parseLong(result);
         //   if (id > 0)
          //      SetUpdate();
          printLog("addBusiness:\n" + result);
        } catch (IOException e) {
            printLog("addStudent Exception:\n" + e);
        }
    }

    @Override
    public void addAttraction(ContentValues values) {
        try {
            String result = PHPTools.POST(WEB_URL + "/attraction.php", values);
         //   long id = Long.parseLong(result);
         //   if (id > 0)
            //    SetUpdate();
            Log.d("TAG", "php att good");
            printLog("addAttraction:\n" +result);
        } catch (IOException e) {
            printLog("addLecturer:\n" +e);
        }
    }

    @Override
    public Cursor getManager() {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]
                    {
                            TravelContent.Manager.user_name,
                            TravelContent.Manager.user_number,
                            TravelContent.Manager.user_password,
                    });
            String str = PHPTools.GET(WEB_URL + "/get_manager.php");
            JSONArray array = new JSONObject(str).getJSONArray("manager");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = null;

                jsonObject = array.getJSONObject(i);

                matrixCursor.addRow(new Object[]{
                        jsonObject.getString(TravelContent.Manager.user_number),
                        jsonObject.getString(TravelContent.Manager.user_name),
                        jsonObject.getString(TravelContent.Manager.user_password),
                });
            }
            return matrixCursor;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Cursor getBusiness() {
        String[] columns = new String[]
                {
                        TravelContent.Business.business_id,
                        TravelContent.Business.business_name,
                        TravelContent.Business.business_street,
                        TravelContent.Business.business_country,
                        TravelContent.Business.business_city,
                        TravelContent.Business.business_phone,
                        TravelContent.Business.business_email,
                        TravelContent.Business.business_webSite,
                };
        Log.d("TAG","get business1");

        MatrixCursor matrixCursor = new MatrixCursor(columns);

        try {
            String str = PHPTools.GET(WEB_URL + "/get_business.php");
            JSONArray array = new JSONObject(str).getJSONArray("business");

            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = null;

                jsonObject = array.getJSONObject(i);
                Log.d("TAG","get business2");
                matrixCursor.addRow(new Object[]{
                        jsonObject.getLong(TravelContent.Business.business_id),
                        Log.d("TAG","get business3"),
                        jsonObject.getString(TravelContent.Business.business_name),
                        jsonObject.getString(TravelContent.Business.business_street),
                        Log.d("TAG","get business4"),
                        jsonObject.getString(TravelContent.Business.business_country),
                        jsonObject.getString(TravelContent.Business.business_city),
                        jsonObject.getInt(TravelContent.Business.business_phone),
                        jsonObject.getString(TravelContent.Business.business_email),
                        jsonObject.getString(TravelContent.Business.business_webSite),
                        Log.d("TAG","get business5")
                });
            }
            Log.d("TAG","get business6");
            return matrixCursor;
        } catch (Exception e) {
            Log.d("TAG","ex get business");
            return null;
        }
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
        try {
            String str = PHPTools.GET(WEB_URL + "/get_attraction.php");
            JSONArray array = new JSONObject(str).getJSONArray("attractions");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = null;

                jsonObject = array.getJSONObject(i);

                matrixCursor.addRow(new Object[]{

                        jsonObject.getString(TravelContent.Attraction.activity_type),
                        jsonObject.getString(TravelContent.Attraction.activity_country),
                        jsonObject.getString(TravelContent.Attraction.activity_TStart),
                        jsonObject.getString(TravelContent.Attraction.activity_TEnd),
                        jsonObject.getInt(TravelContent.Attraction.activity_price),
                        jsonObject.getString(TravelContent.Attraction.activity_description),
                        jsonObject.getLong(TravelContent.Attraction.activity_id),
                        Log.d("TAG"," get att")
                });
            }
            return matrixCursor;
        } catch (Exception e) {
            Log.d("TAG","ex get att");

            return null;
        }
    }

 /*   @Override
    public boolean updateLecturer(ContentValues values) {
        return false;
    }

    @Override
    public boolean updateStudent(long id, ContentValues values) {
        return false;
    }

    @Override
    public boolean updateCourse(long id, ContentValues values) {
        return false;
    }*/


    private void SetUpdate()
    {
        updateFlag = true;
    }

    @Override
    public boolean checkChanges() {
        if (updateFlag) {
            updateFlag = false;
            return true;
        }
        return false;
    }
}
