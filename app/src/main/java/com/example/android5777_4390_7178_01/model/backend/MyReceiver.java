package com.example.android5777_4390_7178_01.model.backend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by יונתן on 08/01/2017.
 */

public class MyReceiver extends BroadcastReceiver{

    public MyReceiver() {
    }

    @Override
    public void onReceive(final Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        Log.d("my service" , "onReceive");

        Toast.makeText(context,intent.getAction(),Toast.LENGTH_LONG).show();

        //    throw new UnsupportedOperationException("Not yet implemented");
    }
}
