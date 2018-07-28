package com.example.ewgengabruskiy.myweather.model;

import com.example.ewgengabruskiy.myweather.interfaces.OnComplete;


public class DataManager  {

    private String apiKey = "29fb8d6056fe0f462c0731feda71d342";

    public DataManager(String city, OnComplete onComplete) {

        NetworkManager networkManager = new NetworkManager(onComplete);
        networkManager.requestFromSite(city,apiKey);
    }




}
