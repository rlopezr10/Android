package com.example.frutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.frutapp.classes.Fruta;
import com.example.frutapp.classes.FrutaAdapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private List<Fruta> frutas = new ArrayList<>();
    private FrutaAdapter adapter;
    private iFruta service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView lista = (RecyclerView)findViewById(R.id.recyclerList);
        adapter = new FrutaAdapter(frutas);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.fruityvice.com/api/fruit/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        service = retrofit.create(iFruta.class);

        getFruits();
        //getSpecificFruit();
    }

    private void getFruits() {
        service.getFrutas()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMapIterable(x -> x)
                .map(x -> frutas.add(x))
                .subscribe(x -> adapter.notifyDataSetChanged());
    }

    private void getSpecificFruit() {
        service.getFruitGenus("Citrus")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMapIterable(x -> x)
                .map(x -> frutas.add(x))
                .subscribe(x -> adapter.notifyDataSetChanged());
    }
}

