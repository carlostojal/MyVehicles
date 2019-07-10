package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// Cars.java
// MyVehicles
// github.com/carlostojal/MyVehicles
//

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Cars extends Fragment {

    private ListView carList;
    private VehicleManager vehicleManager = new VehicleManager();
    private ArrayList<Vehicle> cars;
    private Button addCar;
    private View view;
    private boolean isStarted = false;
    private boolean isVisible = false;

    @Override
    public void onStart() {
        super.onStart();
        vehicleManager = new VehicleManager();
        isStarted = true;
        if(isVisible&&isStarted) {
            cars = vehicleManager.loadVehicles(getContext(),1);
            if(cars.size()>0) {
                ArrayAdapter carAdapter = new CarAdapter(getContext(), cars);
                carList.setAdapter(carAdapter);
            }
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        vehicleManager = new VehicleManager();
        isVisible = isVisibleToUser;
        if (isStarted && isVisible) {
            cars = vehicleManager.loadVehicles(getContext(),1);
            if(cars.size()>0) {
                ArrayAdapter carAdapter = new CarAdapter(getContext(), cars);
                carList.setAdapter(carAdapter);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vehicleManager = new VehicleManager();
        cars = vehicleManager.loadVehicles(getContext(),1);
        if(cars.size()==0) {
            view = inflater.inflate(R.layout.empty_list, container, false);
            TextView label = (TextView) view.findViewById(R.id.textView);
            if(Locale.getDefault().getLanguage().equals("pt"))
                label.setText("Não foram encontrados carros.");
            else
                label.setText("No cars were found.");
            addCar = (Button) view.findViewById(R.id.button);
            if(Locale.getDefault().getLanguage().equals("pt"))
                addCar.setText("Adicionar Carro");
            else
                addCar.setText("Add Car");
            addCar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onAddCar();
                }
            });
        }
        else {
            if(Locale.getDefault().getLanguage().equals("pt"))
                view = inflater.inflate(R.layout.fragment_cars_pt, container, false);
            else
                view = inflater.inflate(R.layout.fragment_cars, container, false);

            carList = view.findViewById(R.id.car_list);
            ArrayAdapter carAdapter = new CarAdapter(getContext(), cars);
            carList.setAdapter(carAdapter);

            addCar = (Button) view.findViewById(R.id.add_vehicle);
            addCar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onAddCar();
                }
            });

            carList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Vehicle selectedVehicle = (Vehicle) adapterView.getItemAtPosition(i);
                    Intent intent = new Intent(Cars.this.getActivity(), VehicleDetails.class);
                    intent.putExtra("registration", selectedVehicle.getRegistration());
                    intent.putExtra("type", 1);
                    startActivity(intent);
                }
            });
        }
        return view;
    }

    public void onAddCar() {
        Intent intent = new Intent(getContext(), AddVehicle.class);
        intent.putExtra("type",1);
        startActivity(intent);
        getActivity().finish();
    }
}