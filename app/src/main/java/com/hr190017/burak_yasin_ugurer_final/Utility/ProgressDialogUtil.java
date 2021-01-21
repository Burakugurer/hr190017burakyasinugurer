package com.hr190017.burak_yasin_ugurer_final.Utility;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Typeface;

import com.hr190017.burak_yasin_ugurer_final.Activity.ListeActivity;
import com.hr190017.burak_yasin_ugurer_final.R;

public class ProgressDialogUtil  {

    public static void kullan(Context context) {

        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage(context.getResources().getString(R.string.progressdialogutilmessage));
        progressDialog.show();
        final int totalTime = 100;
        final Thread t = new Thread() {
            @Override
            public void run() {
                int jumpTime = 0;

                while(jumpTime < totalTime) {
                    try {
                        sleep(50);
                        jumpTime += 1;
                        progressDialog.setProgress(jumpTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (jumpTime==100){
                    progressDialog.dismiss();
                }
            }
        };
        t.start();
    }


}
