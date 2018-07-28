package com.example.ewgengabruskiy.myweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//"rain":{"3h":3},
public class Rain {
    @SerializedName("3h")
    @Expose
    private int rain;


    public int getRain() {
        return rain;
    }

    public void setRain(int rain) {
        this.rain = rain;
    }

}
