package com.autolink.hmi.crosscountry.utils.networkutils;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/* loaded from: classes.dex */
public class NetworkUtils {
    private static final String TAG = "NetworkUtils";

    public static boolean isNetworkAvailable(Activity activity) {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null && allNetworkInfo.length > 0) {
            for (int i = 0; i < allNetworkInfo.length; i++) {
                String str = TAG;
                Log.i(str, "===状态=== " + allNetworkInfo[i].getState());
                Log.i(str, "===类型=== " + allNetworkInfo[i].getTypeName());
                if (allNetworkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }
}
