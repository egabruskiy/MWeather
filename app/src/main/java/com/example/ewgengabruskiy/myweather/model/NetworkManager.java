package com.example.ewgengabruskiy.myweather.model;

import android.util.Log;
import com.example.ewgengabruskiy.myweather.MainActivity;
import com.example.ewgengabruskiy.myweather.interfaces.OnComplete;
import com.example.ewgengabruskiy.myweather.interfaces.RetrofitRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NetworkManager {

    private final String base_url = "https://api.openweathermap.org/";
    private Retrofit retrofitClient;
    private RetrofitRequest retrofitRequest;
    private static WeatherRequest weatherRequest;
    OnComplete onComplete;


 public NetworkManager(OnComplete onComplete){
        retrofitClient = RetrofitClient.getClient(base_url);
        retrofitRequest = retrofitClient.create(RetrofitRequest.class);
        this.onComplete = onComplete;

    }



    public void requestFromSite(String city, String keyApi){
        weatherRequest = new WeatherRequest();

        retrofitRequest.loadWeather(city, keyApi)
                .enqueue(new Callback<WeatherRequest>() {
                    @Override
                     public void onResponse(Call<WeatherRequest> call, Response<WeatherRequest> response) {
                        if (response.body() != null) {
                            weatherRequest = response.body();
                            float temp = weatherRequest.getMain().getTemp();
                          int humidity =   weatherRequest.getMain().getHumidity();
                            String summary = weatherRequest.getWeather().getMain();
                            String description = weatherRequest.getWeather().getDescription();
                            String icon = weatherRequest.getWeather().getIcon();
                            onComplete.onComplete(String.valueOf(Math.round(temp - 273F)),
                                    String.valueOf(humidity),
                                    summary,
                                    description,
                                    icon);
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherRequest> call, Throwable t) {
//                        textTemp.setText("Error");

                    }
                });
    }






}
