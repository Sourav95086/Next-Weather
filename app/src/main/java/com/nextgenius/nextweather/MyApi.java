package com.nextgenius.nextweather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApi {

    @GET("weather")
    Call<ModalClass> getapi(

            @Query("q") String cityname,
            @Query("appid") String apikey,
            @Query("units") String unit


            );



}
