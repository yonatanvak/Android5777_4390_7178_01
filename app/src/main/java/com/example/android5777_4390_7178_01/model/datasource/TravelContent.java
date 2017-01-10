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

        public static final String business_name = "nameBusines";
        public static final String business_id = "businessID";
        public static final String business_street = "Ad_street";
        public static final String business_country = "Ad_country";
        public static final String business_city = "Ad_city";
        public static final String business_phone = "phone";
        public static final String business_email = "Email";
        public static final String business_webSite = "webSite";
        /**
         * The content:// style URI for this table
         */
        public static final Uri BUSINESS_URI = Uri.withAppendedPath(AUTHORITY_URI, "business");
    }

    public static class Attraction {

        public static final String activity_type = "types";
        public static final String activity_country = "country";
        public static final String activity_TStart = "activityStart";
        public static final String activity_TEnd = "activityEnd";
        public static final String activity_price = "price";
        public static final String activity_description = "description";
        public static final String activity_id = "IDbussiness";
        /**
         * The content:// style URI for this table
         */
        public static final Uri ATTRACTION_URI = Uri.withAppendedPath(AUTHORITY_URI, "attraction");
    }
}


