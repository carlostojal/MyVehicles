package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// VehicleDetails.java
// MyVehicles
// github.com/carlostojal/MyVehicles
//

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class VehicleDetails extends AppCompatActivity {

    ArrayList<Vehicle> vehicles;
    Vehicle vehicle;
    VehicleManager vehicleManager;

    int type;
    String registration_value;

    TextView brand;
    TextView model;
    TextView displacement;
    TextView year;
    TextView registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Locale.getDefault().getLanguage().equals("pt"))
            setContentView(R.layout.activity_vehicle_details_pt);
        else
            setContentView(R.layout.activity_vehicle_details);

        brand = (TextView) findViewById(R.id.brand_value_details);
        model = (TextView) findViewById(R.id.model_value_details);
        displacement = (TextView) findViewById(R.id.displacement_value_details);
        year = (TextView) findViewById(R.id.year_value_details);
        registration = (TextView) findViewById(R.id.registration_value_details);

        vehicleManager = new VehicleManager();

        Bundle extras = getIntent().getExtras();
        registration_value = extras.getString("registration");
        type = extras.getInt("type");
        vehicles = vehicleManager.loadVehicles(getApplicationContext(),type);
        for(int i=0;i<vehicles.size();i++) {
            //searches selected vehicle in the list
            if(vehicles.get(i).getRegistration().equals(registration_value)) {
                vehicle = vehicles.get(i);
                break;
            }
        }
        //sets car brand and model as activity title
        setTitle(vehicle.getBrand()+" "+vehicle.getModel());

        brand.setText(vehicle.getBrand().toString());
        model.setText(vehicle.getModel().toString());
        if(vehicle.getDisplacement()!=0)
            displacement.setText(String.valueOf(vehicle.getDisplacement()));
        else {
            if(Locale.getDefault().getLanguage().equals("pt"))
                displacement.setText("Sem informação.");
            else
                displacement.setText("No information.");
        }
        if(vehicle.getYear()!=0)
            year.setText(String.valueOf(vehicle.getYear()));
        else {
            if(Locale.getDefault().getLanguage().equals("pt"))
                year.setText("Sem informação.");
            else
                year.setText("No information.");
        }
        registration.setText(vehicle.getRegistration().toString());
    }

    public void onInsurances(View view) {
        Intent intent = new Intent(VehicleDetails.this,InsurancesInspectionsTaxesRevisions.class);
        intent.putExtra("vehicleType",type);
        intent.putExtra("registration",registration_value);
        intent.putExtra("type",1); //1 -> insurances
        startActivity(intent);
    }

    public void onInspections(View view) {
        Intent intent = new Intent(VehicleDetails.this,InsurancesInspectionsTaxesRevisions.class);
        intent.putExtra("vehicleType",type);
        intent.putExtra("registration",registration_value);
        intent.putExtra("type",2); //2 -> inspections
        startActivity(intent);
    }

    public void onTaxes(View view) {
        Intent intent = new Intent(VehicleDetails.this,InsurancesInspectionsTaxesRevisions.class);
        intent.putExtra("vehicleType",type);
        intent.putExtra("registration",registration_value);
        intent.putExtra("type",3); //3 -> taxes
        startActivity(intent);
    }

    public void onRevisions(View view) {
        Intent intent = new Intent(VehicleDetails.this,InsurancesInspectionsTaxesRevisions.class);
        intent.putExtra("vehicleType",type);
        intent.putExtra("registration",registration_value);
        intent.putExtra("type",4); //4 -> revisions
        startActivity(intent);
    }
}
