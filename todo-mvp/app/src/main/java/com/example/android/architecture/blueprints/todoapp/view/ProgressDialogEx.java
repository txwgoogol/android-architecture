package com.example.android.architecture.blueprints.todoapp.view;

import android.app.ProgressDialog;
import android.content.Context;

import com.example.android.architecture.blueprints.todoapp.R;

/**
 * 自定义Dialog
 */
public class ProgressDialogEx {

    public static ProgressDialog progressDialog;

    public static ProgressDialog showProgressDialog(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getResources().getString(R.string.loading));
        progressDialog.show();
        return progressDialog;
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