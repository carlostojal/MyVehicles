package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// VehicleDetails.java
// MyVehicles
// github.com/carlostojal/MyVehicles
//

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class VehicleDetails extends AppCompatActivity {

    ArrayList<Vehicle> vehicles;
    Vehicle vehicle;
    VehicleManager vehicleManager;

    TextView brand;
    TextView model;
    TextView displacement;
    TextView year;
    TextView registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_details);

        brand = (TextView) findViewById(R.id.brand_value_details);
        model = (TextView) findViewById(R.id.model_value_details);
        displacement = (TextView) findViewById(R.id.displacement_value_details);
        year = (TextView) findViewById(R.id.year_value_details);
        registration = (TextView) findViewById(R.id.registration_value_details);

        vehicleManager = new VehicleManager();

        Bundle extras = getIntent().getExtras();
        String searchedRegistration = extras.getString("registration");
        int searchedType = extras.getInt("type");
        vehicles = vehicleManager.loadVehicles(getApplicationContext(),searchedType);
        for(int i=0;i<vehicles.size();i++) {
            //searches selected vehicle in the list
            if(vehicles.get(i).getRegistration().equals(searchedRegistration)) {
                vehicle = vehicles.get(i);
                break;
            }
        }
        //sets car brand and model as activity title
        setTitle(vehicle.getBrand()+" "+vehicle.getModel());

        brand.setText(vehicle.getBrand().toString());
        model.setText(vehicle.getModel().toString());
        displacement.setText(String.valueOf(vehicle.getDisplacement()));
        year.setText(String.valueOf(vehicle.getYear()));
        registration.setText(vehicle.getRegistration().toString());
    }
}
