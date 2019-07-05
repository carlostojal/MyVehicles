package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// Cars.java
// MyVehicles
// github.com/carlostojal/MyVehicles
//

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class Cars extends Fragment {

    ArrayList<Vehicle> cars;
    Button addCar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cars, container, false);
        addCar = (Button) view.findViewById(R.id.add_car);
        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddCar();
            }
        });

        return view;
    }



    public void onAddCar() {
        Intent intent = new Intent(getContext(),AddCar.class);
        startActivity(intent);
    }
}