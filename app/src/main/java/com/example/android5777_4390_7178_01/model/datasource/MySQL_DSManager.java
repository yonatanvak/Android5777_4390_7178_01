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
    private final String WEB_URL = "http://"+UserName+".vlab.jct.ac.il/Academy/";

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
    public void addBusiness(ContentValues values) {
        try {
            String result = PHPTools.POST(WEB_URL + "/Business.php", values);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addStudent:\n" + result);
        } catch (IOException e) {
            printLog("addStudent Exception:\n" + e);
        }
    }

    @Override
    public void addAttraction(ContentValues values) {
        try {
            String result = PHPTools.POST(WEB_URL + "/Attraction.php", values);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addLecturer:\n" +result);
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
            String str = PHPTools.GET(WEB_URL + "/Manager.php");
            JSONArray array = new JSONObject(str).getJSONArray("Manager");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = null;

                jsonObject = array.getJSONObject(i);

                matrixCursor.addRow(new Object[]{
                        jsonObject.getString(TravelContent.Manager.user_number),
                        jsonObject.getInt(TravelContent.Manager.user_name),
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

        MatrixCursor matrixCursor = new MatrixCursor(columns);
        try {
            String str = PHPTools.GET(WEB_URL + "/courses.php");
            JSONArray array = new JSONObject(str).getJSONArray("courses");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = null;

                jsonObject = array.getJSONObject(i);

                matrixCursor.addRow(new Object[]{
                        jsonObject.getInt(AcademyContract.Course.ID),
                        jsonObject.getString(AcademyContract.Course.NAME),
                        jsonObject.getInt(AcademyContract.Course.MIN_GRADE),
                        jsonObject.getBoolean(AcademyContract.Course.REQUIRED),
                        jsonObject.getInt(AcademyContract.Course.LECTURER_ID)
                });
            }
            return matrixCursor;
        } catch (Exception e) {
            return null;
        }


    }

    @Override
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
    }


    private void SetUpdate()
    {
        updateFlag = true;
    }

    @Override
    public boolean isUpdatet() {
        if(updateFlag)
        {
            updateFlag=false;
            return  true;
        }
        return  false;
    }
}
