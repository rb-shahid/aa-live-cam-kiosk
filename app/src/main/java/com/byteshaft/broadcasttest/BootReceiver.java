package com.byteshaft.broadcasttest;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;

/**
 * Created by shahid on 07/01/2018.
 */

public class BootReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("ok", "Received action: " + intent.getAction());
//        openApp(context, "com.tvt.superliveplus");
        openApp(context, "com.byteshaft.broadcasttest");
//        Intent myIntent = new Intent(context, MainActivity.class);
//        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(myIntent);
    }

    public static boolean openApp(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();
        try {
            Intent i = manager.getLaunchIntentForPackage(packageName);
            if (i == null) {
                return false;
                //throw new ActivityNotFoundException();
            }
            i.addCategory(Intent.CATEGORY_LAUNCHER);
            context.startActivity(i);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }
}
