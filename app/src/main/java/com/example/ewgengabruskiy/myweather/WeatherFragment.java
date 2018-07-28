package com.example.ewgengabruskiy.myweather;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ewgengabruskiy.myweather.interfaces.OnComplete;
import com.example.ewgengabruskiy.myweather.model.CurrentTime;
import com.example.ewgengabruskiy.myweather.model.DataManager;
import com.squareup.picasso.Picasso;



public class WeatherFragment extends Fragment  {

    private Button button;
    private TextView textTemp;
    private TextView timeLabel;
    private TextView humidityValue;
    private TextView locationLabel;
    private TextView summaryLabel;
    private TextView descriptionLabel;
    private ImageView iconImageView;
    private SharedPreferences sharedPref;
    private ImageView refreshImageVew;
    private ProgressBar mProgressBar;
    private DataManager datamanager;
    private TextView cityNameView;
    private CurrentTime currentTime;
    public static final String PARCEL = "parcel";
    private String city;
    private View layout;



    public Parcel getParcel() {
        Parcel parcel = (Parcel) getArguments().getSerializable(PARCEL);
        return parcel;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         layout = inflater.inflate(R.layout.main_fragment, container, false);
         cityNameView = layout.findViewById(R.id.locationLabel);
        Parcel parcel = getParcel();
        city = parcel.getCityName();
        initGui();
        setDataToGui();
        return layout;

    }

    private void setDataToGui(){
        cityNameView.setText(city);

        datamanager = new DataManager(city,new OnComplete() {
            @Override
            public void onComplete(String temp, String humidity,
                                   String summary, String description,String icon) {
                textTemp.setText(temp);
                humidityValue.setText(humidity);
                descriptionLabel.setText(summary);
                summaryLabel.setText(description);
                Picasso.get().load("http://openweathermap.org/img/w/" + icon + ".png")
                        .resize(300,300)
                        .into(iconImageView);

            }
        });
        currentTime = new CurrentTime();
        timeLabel.setText(currentTime.getFormattedTime());

    }



    public void initGui(){
        timeLabel = layout.findViewById(R.id.timeLabel);
        iconImageView = layout.findViewById(R.id.iconImageView);
        textTemp = layout.findViewById(R.id.temperatureLabel);
        locationLabel = layout.findViewById(R.id.locationLabel);
        descriptionLabel = layout.findViewById(R.id.description);
        summaryLabel = layout.findViewById(R.id.summaryLabel);
        refreshImageVew = layout.findViewById(R.id.refreshImageView);
        humidityValue = layout.findViewById(R.id.humidityValue);
        button = layout.findViewById(R.id.buttonPanel);
        refreshImageVew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDataToGui();
            }
        });
    }

}