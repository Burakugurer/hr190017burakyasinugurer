package com.hr190017.burak_yasin_ugurer_final.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.hr190017.burak_yasin_ugurer_final.Model.FilmModel;
import com.hr190017.burak_yasin_ugurer_final.R;
import com.hr190017.burak_yasin_ugurer_final.Utility.Constants;
import com.hr190017.burak_yasin_ugurer_final.Utility.ObjectUtil;

public class FilmDetayActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtBaslik;
    TextView txtTarih;
    TextView txtOyuncular;
    TextView txtYonetmen;
    TextView txtKonu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detay);

    init();

    }

    private void init()
    {
        String tasinanFilmString =getIntent().getStringExtra(Constants.TIKLANAN_FILM_TASINANIN_BASLIGI);
        FilmModel filmModel = ObjectUtil.jsonStringToFilm(tasinanFilmString);

        txtYonetmen=findViewById(R.id.txtYonetmen);
        imgKapak= findViewById(R.id.imgKapak);
        txtBaslik= findViewById(R.id.txtBaslik);
        txtTarih= findViewById(R.id.txtTarih);
        txtKonu= findViewById(R.id.txtKonu);
        txtOyuncular= findViewById(R.id.txtOyuncular);


        txtBaslik.setText(filmModel.getFilmAdi());
        txtTarih.setText(getResources().getString(R.string.filmDetayActivityCikisTarihi)+filmModel.getFilmCikisTarihi());
        txtOyuncular.setText(getResources().getString(R.string.filmDetayActivityOyuncuları)+filmModel.getFilmOyunculari());
        txtYonetmen.setText(getResources().getString(R.string.filmDetayActivityYönetmeni)+filmModel.getFilmYonetmeni());
        txtKonu.setText(Html.fromHtml(filmModel.getFilmKonusu()));
    }
}