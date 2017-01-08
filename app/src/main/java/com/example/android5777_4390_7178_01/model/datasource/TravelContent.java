package com.example.android5777_4390_7178_01.model.datasource;

import android.net.Uri;

/**
 * Created by יונתן on 08/01/2017.
 */

public class TravelContent {

    public static final String AUTHORITY = "com.example.android5777_4390_7178_01";
    /**
     * A content:// style uri to the authority for the contacts provider
     */
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);

    public static class Manager {

        static final String user_name = "user_name";
        static final String user_number = "user_number";
        static final String user_password = "user_password";
        /**
         * The content:// style URI for this table
         */
        public static final Uri MANAGER_URI = Uri.withAppendedPath(AUTHORITY_URI, "manager");
    }

    public static class Business {

        static final String business_name = "business_name";
        static final String business_id = "business_id";
        static final String business_street = "business_street";
        static final String business_country = "business_country";
        static final String business_city = "business_city";
        static final String business_phone = "business_phone";
        static final String business_email = "business_email";
        static final String business_webSite = "business_webSite";
        /**
         * The content:// style URI for this table
         */
        public static final Uri BUSINESS_URI = Uri.withAppendedPath(AUTHORITY_URI, "business");
    }

    public static class Attraction {

        static final String activity_type = "activity_type";
        static final String activity_country = "activity_country";
        static final String activity_TStart = "activity_TStart";
        static final String activity_TEnd = "activity_TEnd";
        static final String activity_price = "activity_price";
        static final String activity_description = "activity_description";
        static final String activity_id = "activity_id";
        /**
         * The content:// style URI for this table
         */
        public static final Uri ATTRACTION_URI = Uri.withAppendedPath(AUTHORITY_URI, "attraction");
    }
}


