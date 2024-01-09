package com.example.frutapp;

import com.example.frutapp.classes.Fruta;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface iFruta {

    /// https://www.fruityvice.com/api/fruit/all
    @GET("all")
    Observable<List<Fruta>> getFrutas();

    /// https://www.fruityvice.com/api/fruit/genus/{genus}
    @GET("genus/{genus}")
    Observable<List<Fruta>> getFruitGenus(@Path("genus") String genus);
}
