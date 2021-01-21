package com.hr190017.burak_yasin_ugurer_final.Network;

import com.hr190017.burak_yasin_ugurer_final.Model.FilmModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface ServiceApi {

    @GET("filmler.json")
    Observable<List<FilmModel>> FilmleriGetir();
}
