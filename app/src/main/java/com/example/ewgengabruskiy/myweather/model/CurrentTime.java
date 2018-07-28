package com.example.ewgengabruskiy.myweather.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CurrentTime {


    public String getFormattedTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        Date currentTime = Calendar.getInstance().getTime();
        Date dateTime = new Date(String.valueOf(currentTime));
        String timeString = formatter.format(dateTime);

        return timeString;
    }
}
