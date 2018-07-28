package com.example.ewgengabruskiy.myweather;

import java.io.Serializable;

public class Parcel implements Serializable {
    private String cityName;


    public String getCityName() {
        return cityName;
    }

    public Parcel(String cityName) {
        this.cityName = cityName;
    }
}
