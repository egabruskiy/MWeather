package com.example.ewgengabruskiy.myweather.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import com.example.ewgengabruskiy.myweather.model.WeatherRequest;

public interface RetrofitRequest {
    @GET("data/2.5/weather")
    Call<WeatherRequest> loadWeather(@Query("q") String cityCountry,
                                     @Query("appid") String keyApi);
}
