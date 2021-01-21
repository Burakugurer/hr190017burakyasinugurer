package com.hr190017.burak_yasin_ugurer_final.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.hr190017.burak_yasin_ugurer_final.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.hr190017.burak_yasin_ugurer_final.Utility.Constants;
import com.hr190017.burak_yasin_ugurer_final.Utility.GlideUtil;
import com.hr190017.burak_yasin_ugurer_final.Model.FilmModel;
import com.hr190017.burak_yasin_ugurer_final.Adaptor.FilmAdaptor;
import com.hr190017.burak_yasin_ugurer_final.Network.Service;
import com.hr190017.burak_yasin_ugurer_final.Utility.ObjectUtil;
import com.hr190017.burak_yasin_ugurer_final.Utility.ProgressDialogUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;



public class ListeActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        ProgressDialogUtil.kullan(ListeActivity.this);

        init();

    }

    private  void  init()
    {
        FilmleriGetir();
    }

    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(ListeActivity.this);
        builder.setTitle(getResources().getString(R.string.onbackpressedtitle));
        builder.setMessage(getResources().getString(R.string.onbackpressedmessage));
        builder.setNegativeButton(getResources().getString(R.string.onbackpressednegative), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ListeActivity.this.finish();
                System.exit(0);
            }
        });
        builder.setPositiveButton(getResources().getString(R.string.onbackpressedpositive),null).show();
    }



    void  FilmleriGetir()
    {

        new Service().getServiceApi().FilmleriGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<FilmModel>>() {

                    List<FilmModel> filmler=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<FilmModel> filmList) {
                        Log.e("RETROFIT","onNext : ");
                        filmler=filmList;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");

                        if(filmler.size()>0) {
                            initRecycleView(filmler);
                        }
                    }
                });
    }


    private  void  initRecycleView(List<FilmModel> filmList)
    {
        recyclerView =findViewById(R.id.rcvFilmler);
        FilmAdaptor filmAdaptor =new FilmAdaptor(filmList, getApplicationContext(), new FilmAdaptor.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                FilmModel tiklananFilm=filmList.get(position);
                nextActivity(tiklananFilm);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(filmAdaptor);
    }

    private void nextActivity(FilmModel tiklananFilm){
        Intent secondActivityIntent  = new Intent(getApplicationContext(), FilmDetayActivity.class);
        String tiklananFilmStrting= ObjectUtil.filmToJsonString((tiklananFilm));
        secondActivityIntent.putExtra(Constants.TIKLANAN_FILM_TASINANIN_BASLIGI,tiklananFilmStrting);
        startActivity(secondActivityIntent);

    }

}



