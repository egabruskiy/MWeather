package com.example.ewgengabruskiy.myweather;


import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;
import static com.example.ewgengabruskiy.myweather.WeatherFragment.PARCEL;

public class CitiesFragment extends ListFragment {

    private SharedPreferences sharedPref;
    private View layout;
    Parcel currentParcel;

    // При создании фрагмента, укажем его макет
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_list, container, false);
//        sharedPref = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);

        FloatingActionButton fabSite =  layout.findViewById(R.id.fab);
        fabSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//             addCity(layout,"Sochi");
            }
        });

        return layout;


    }

    // Активити создана, можно к ней обращаться. Выполним начальные действия
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Cities,
                android.R.layout.simple_list_item_activated_1);
//        ArrayAdapter adapter = new ArrayAdapter(
//                getActivity(), android.R.layout.simple_list_item_1, cits);
        setListAdapter(adapter);

        if (savedInstanceState != null) {

            currentParcel = (Parcel) savedInstanceState.getSerializable("CurrentCity");
        } else {
            currentParcel = new Parcel(getResources().getTextArray(R.array.Cities)[0].toString());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("CurrentCity", currentParcel);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        TextView cityNameView = (TextView) v;
        currentParcel = new Parcel(cityNameView.getText().toString());
        sendCity(currentParcel);
    }

    private void sendCity(Parcel parcel) {

        Intent intent = new Intent();
        intent.setClass(getActivity(), WeatherActivity.class);
        intent.putExtra(PARCEL, parcel);
        startActivity(intent);
    }


}
