package com.byteshaft.broadcasttest;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                openApp();
            }
        }, 5000);
    }

    private void openApp() {
        String packageName = "com.tvt.superliveplus";
        if (isAppInstalled(MainActivity.this, packageName))
            startActivity(getPackageManager().getLaunchIntentForPackage(packageName));
        else Toast.makeText(MainActivity.this, "Super Live Plus not installed", Toast.LENGTH_SHORT).show();
    }

    public static boolean isAppInstalled(Activity activity, String packageName) {
        PackageManager pm = activity.getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
        }
        return false;
    }
}
