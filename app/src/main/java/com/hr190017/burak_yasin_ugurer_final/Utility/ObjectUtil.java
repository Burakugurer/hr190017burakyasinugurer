package com.hr190017.burak_yasin_ugurer_final.Utility;

import com.google.gson.Gson;
import com.hr190017.burak_yasin_ugurer_final.Model.FilmModel;

public class ObjectUtil {
    public static String filmToJsonString(FilmModel filmModel)
    {
        Gson gson = new Gson();
        return gson.toJson(filmModel);
    }
    public static FilmModel jsonStringToFilm(String jsonString)
    {
        Gson gson= new Gson();
        return gson.fromJson(jsonString,FilmModel.class);
    }
}
