package com.example.springbackend;

import android.os.Build;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private Retrofit retrofit;
    public RetrofitService(){
        initRetrofit();
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.18:8090")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }
    public Retrofit getRetrofit(){
        return retrofit;
    }

}
