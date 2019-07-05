package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// AddCar.java
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
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddCar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        setTitle("Add Car");
    }

    public void onAddCar(View view) {
        VehicleManager vehicleManager = new VehicleManager();

        EditText brand = (EditText) findViewById(R.id.brand_field);
        EditText model = (EditText) findViewById(R.id.model_field);
        EditText displacement = (EditText) findViewById(R.id.displacement_field);
        EditText year = (EditText) findViewById(R.id.year_field);
        EditText registration = (EditText) findViewById(R.id.registration_field);

        String brand_value = brand.getText().toString();
        String model_value = model.getText().toString();
        int displacement_value = Integer.parseInt(displacement.getText().toString());
        if(String.valueOf(displacement_value).equals(""))
            displacement_value = 0;
        int year_value = Integer.parseInt(year.getText().toString());
        if(String.valueOf(year_value).equals(""))
            year_value = 0;
        String registration_value = registration.getText().toString();

        InsuranceInspectionTax newInsurance;
        ArrayList<InsuranceInspectionTax> insurance = new ArrayList<>();
        Date insuranceDate = new Date(0,0,0);
        float insuranceValue = 0;
        newInsurance = new InsuranceInspectionTax(insuranceDate,insuranceValue);
        insurance.add(newInsurance);

        InsuranceInspectionTax newInspection;
        ArrayList<InsuranceInspectionTax> inspection = new ArrayList<>();
        Date inspectionDate = new Date(0,0,0);
        float inspectionValue = 0;
        newInspection = new InsuranceInspectionTax(inspectionDate,inspectionValue);
        inspection.add(newInspection);

        InsuranceInspectionTax newTax;
        ArrayList<InsuranceInspectionTax> tax = new ArrayList<>();
        Date taxDate = new Date(0,0,0);
        float taxValue = 0;
        newTax = new InsuranceInspectionTax(taxDate,taxValue);
        tax.add(newTax);

        Vehicle newVehicle = new Vehicle(1,brand_value,model_value,displacement_value,year_value,registration_value,insurance,inspection,tax);
        if(!brand_value.equals("")&&!model_value.equals("")&&!registration_value.equals("")) {
            if (vehicleManager.addVehicle(getApplicationContext(), newVehicle)) {
                Toast.makeText(getApplicationContext(), "Car added successfully.", Toast.LENGTH_SHORT).show();
                finish();
            }
            else
                Toast.makeText(getApplicationContext(), "Error. Please try again.", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(), "No obligatory field can be left empty.", Toast.LENGTH_SHORT).show();
    }

}
