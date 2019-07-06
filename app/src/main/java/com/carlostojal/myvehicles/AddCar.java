package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// AddCar.java
// MyVehicles
// github.com/carlostojal/MyVehicles
//

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

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
        int displacement_value;
        if(displacement.getText().toString().equals(""))
            displacement_value = 0;
        else
            displacement_value = Integer.parseInt(displacement.getText().toString());
        int year_value;
        if(year.getText().toString().equals(""))
            year_value = 0;
        else
            year_value = Integer.parseInt(year.getText().toString());
        String registration_value = registration.getText().toString();

        InsuranceInspectionTaxRevision newInsurance;
        ArrayList<InsuranceInspectionTaxRevision> insurance = new ArrayList<>();
        Date insuranceDate = new Date(0,0,0);
        float insuranceValue = 0;
        newInsurance = new InsuranceInspectionTaxRevision(insuranceDate,insuranceValue);
        insurance.add(newInsurance);

        InsuranceInspectionTaxRevision newInspection;
        ArrayList<InsuranceInspectionTaxRevision> inspection = new ArrayList<>();
        Date inspectionDate = new Date(0,0,0);
        float inspectionValue = 0;
        newInspection = new InsuranceInspectionTaxRevision(inspectionDate,inspectionValue);
        inspection.add(newInspection);

        InsuranceInspectionTaxRevision newTax;
        ArrayList<InsuranceInspectionTaxRevision> tax = new ArrayList<>();
        Date taxDate = new Date(0,0,0);
        float taxValue = 0;
        newTax = new InsuranceInspectionTaxRevision(taxDate,taxValue);
        tax.add(newTax);

        InsuranceInspectionTaxRevision newRevision;
        ArrayList<InsuranceInspectionTaxRevision> revision = new ArrayList<>();
        Date revisionDate = new Date(0,0,0);
        float revisionValue = 0;
        newRevision = new InsuranceInspectionTaxRevision(revisionDate,revisionValue);
        tax.add(newRevision);

        Vehicle newVehicle = new Vehicle(1,brand_value,model_value,displacement_value,year_value,registration_value,insurance,inspection,tax,revision);
        Toast.makeText(getApplicationContext(), newVehicle.getType()+"\n"+newVehicle.getBrand()+"\n"+newVehicle.getModel(), Toast.LENGTH_SHORT).show();
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
