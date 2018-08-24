package com.txwgoogol.top.weather.todoapp.util;

import android.app.ProgressDialog;
import android.content.Context;

import com.txwgoogol.top.weather.todoapp.R;

/**
 * 进度工具类
 */
public class ProgressDialogUtils {

    public static ProgressDialog progressDialog;

    public static void showProgressDialog(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getResources().getString(R.string.loading));
        progressDialog.show();
    }

    public static ProgressDialog showProgressDialog(CharSequence message, Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        progressDialog.show();
        return progressDialog;
    }

    public static void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            // progressDialog.hide();会导致android.view.WindowLeaked
            progressDialog.dismiss();
        }
    }

}