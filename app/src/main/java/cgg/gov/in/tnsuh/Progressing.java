package cgg.gov.in.tnsuh;

import android.app.ProgressDialog;
import android.content.Context;


/**
 * Created by Chetan on 07-09-2017.
 */

public class Progressing {

    public static ProgressDialog showProgressDialog(ProgressDialog pDialog, Context context) {
        pDialog.setMessage("Please Wait...");
        pDialog.setTitle(context.getResources().getString(R.string.app_name));
        pDialog.setCancelable(false);
        if (!pDialog.isShowing()) {
            pDialog.show();
        }
        return pDialog;
    }

    public static void hideProgressDialog(ProgressDialog pDialog) {
        if (pDialog.isShowing()) {
            pDialog.dismiss();
        }
        pDialog.hide();


    }
}
