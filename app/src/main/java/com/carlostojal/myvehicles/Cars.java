package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// Cars.java
// MyVehicles
// github.com/carlostojal/MyVehicles
//

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Cars extends Fragment {

    private ListView carList;
    private VehicleManager vehicleManager;
    private ArrayList<Vehicle> cars;
    private Button addCar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cars, container, false);

        vehicleManager = new VehicleManager();
        cars = vehicleManager.loadVehicles(getContext(),1);
        if(cars.size()==0)
            Toast.makeText(getContext(), "No cars were found.", Toast.LENGTH_SHORT).show();

        carList = view.findViewById(R.id.car_list);
        ArrayAdapter carAdapter = new CarAdapter(getContext(),cars);
        carList.setAdapter(carAdapter);

        addCar = (Button) view.findViewById(R.id.add_vehicle);
        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddCar();
            }
        });

        return view;
    }



    public void onAddCar() {
        Intent intent = new Intent(getContext(), AddVehicle.class);
        intent.putExtra("type",1);
        startActivity(intent);
    }
}