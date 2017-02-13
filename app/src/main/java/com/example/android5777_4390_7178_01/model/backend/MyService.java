package com.example.android5777_4390_7178_01.model.backend;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.example.android5777_4390_7178_01.model.datasource.ListDsManager;
import com.example.android5777_4390_7178_01.model.datasource.TravelContent;

public class MyService extends Service {

        final String TAG = "myservice";

        static boolean ServiceRun = false;

        static final String ACTION_SERVICE = "com.example.android5777_4390_7178_01.ACTION_SERVICE";
        IDSManager manager = ManagerFactory.getManager();

        public MyService() {
        }

        @Override
        public void onCreate() {


            ServiceRun = true;

            Log.d(TAG, "onCreate");

        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {

            Log.i(TAG, "Service onStartCommand");

            //Creating new thread for my service
            //Always write your long running tasks in a separate thread, to avoid ANR
            new Thread(new Runnable() {
                @Override
                public void run() {


                    //Your logic that service will perform will be placed here
                    //In this example we are just looping and waits for 1000 milliseconds in each loop.
                    while (true) {
                        try {
                            ServiceRun = true;
                            try {

                                //CHECKING IF ACTIVITUES AND BUSINESS UPDATED:
                                Thread.sleep(1000);

                                if (manager.checkChanges()) {
                                    Log.d("SERVICE", "-----------Activity updated----------");
                                    //SEND message to second app
                                    Intent intent = new Intent("MyCustomIntent");
                                    // add data to the Intent
                                    intent.putExtra("message", "NEW ACTIVITY ADDED TO DATA BASE");
                                    intent.setAction("HAGER.VAKNIN.ACTION_SERVICE.ACT");
                                    sendBroadcast(intent);
                                } else {
                                    Log.d("SERVICE", "Activity not updated");
                                }
                                Thread.sleep(1000);
                                if (manager.checkChanges()) {
                                    Log.d("SERVICE", "-----------Business updated----------");
                                    //SEND message to second app
                                    Intent intent = new Intent("MyCustomIntent");
                                    // add data to the Intent
                                    intent.putExtra("message", "NEW Business ADDED TO DATA BASE");
                                    intent.setAction("HAGER.VAKNIN.ACTION_SERVICE.BUS");
                                    sendBroadcast(intent);
                                } else {
                                    Log.d("SERVICE", "Business not updated");
                                }

                            } catch (Exception e) {
                                Log.d("SERVICE", "checking if updated NOT WORKING " + e.getMessage());
                            }
                            //SLEEP FOR 30 SEC BEFORE YOU CHECK AGAIN
                            ServiceRun = false;
                            Thread.sleep(60000);

                        } catch (Exception e) {
                            Log.d("SERVICE", "SERVICE NOT WORKING " + e.getMessage());
                        }

                        if (ServiceRun) {
                            Log.i(TAG, "Service running");
                        }
                    }

                    //Stop service once it finishes its task
                    //  stopSelf();
                }
            }).start();

            return Service.START_STICKY;
        }

        @Override
        public IBinder onBind(Intent intent) {
            Log.d(TAG, "onBind");
            // TODO: Return the communication channel to the service.
            return null;
            //throw new UnsupportedOperationException("Not yet implemented");
        }
    }
