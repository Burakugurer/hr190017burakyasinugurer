package com.hr190017.burak_yasin_ugurer_final.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;


import com.hr190017.burak_yasin_ugurer_final.Activity.ListeActivity;
import com.hr190017.burak_yasin_ugurer_final.R;
import com.hr190017.burak_yasin_ugurer_final.Utility.InternetKontrolUtil;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init(getBaseContext());
        splash();


    }

        private void init(Context context){
            CountDownTimer countDownTimer =new CountDownTimer(3000,1000) {
                @Override
                public void onTick(long l) {

                    Log.e("COUNTER","TİCK");
                }
                @Override
                public void onFinish() {
                    if (!InternetKontrolUtil.internetVarMi(context)) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
                        builder.setTitle(context.getResources().getString(R.string.title));
                        builder.setMessage(context.getResources().getString(R.string.cikisdiyalogu));
                        builder.setCancelable(true);
                        builder.setNegativeButton(context.getResources().getString(R.string.Kapat), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                System.exit(0);
                            }

                        });
                        builder.setPositiveButton(context.getResources().getString(R.string.Internetayarlarınagit), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }else {
                        nextActivity();

                    }
                }
            };
            countDownTimer.start();
        }
    private void splash()
    {
        Thread logoAnimation = new Thread(){
            @Override
            public void run(){
                ImageView logo = findViewById(R.id.GirisLogo);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_intro_logo);
                logo.startAnimation(animation);
            }
        };
        logoAnimation.start();
        Thread redirect = new Thread(){
            @Override
            public void run(){
                try {
                    sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        redirect.start();

    }
    private void nextActivity(){
        Intent i  = new Intent(getApplicationContext(), ListeActivity.class);
        startActivity(i);
        finish();
    }
}



















