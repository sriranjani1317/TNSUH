package cgg.gov.in.tnsuh.internetcheck;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.util.logging.Logger;


/**
 * Created by Chetan on 07-07-2017.
 */

public class CheckInternet {
    public static NetworkChangeReceiver receiver;
    static Boolean  bl = true;

    //check net
    public static boolean checkInternet(Context context) {
        Activity  activity=(Activity)context;
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        receiver = new NetworkChangeReceiver(activity);

        registerBReceiver(receiver,filter,activity);
        bl = receiver.is_connected();
        Log.e("Boolean ", bl.toString());
        return bl;
    }

    //register broadcast
    public static void registerBReceiver(NetworkChangeReceiver receiver, IntentFilter filter, Activity activity){
        activity.registerReceiver(receiver, filter);
    }

    //unregister
    public static void unregisterBReceiver(Context context){
        Activity  activity=(Activity)context;
        try {
            activity.unregisterReceiver(receiver);
        } catch (Exception e) {

        }
    }
    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }
}
