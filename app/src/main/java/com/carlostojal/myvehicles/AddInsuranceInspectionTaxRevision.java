package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// AddInsuranceInspectionTaxRevision.java
// MyVehicles
// github.com/carlostojal/MyVehicles
//

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class AddInsuranceInspectionTaxRevision extends AppCompatActivity {

    ArrayList<Vehicle> vehicles;
    Vehicle vehicle;
    VehicleManager vehicleManager;
    int type;

    TextView label;
    EditText value;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_insurance_inspection_tax_revision);

        label = findViewById(R.id.value_add);
        value = findViewById(R.id.value_value_add);
        add = findViewById(R.id.add);

        Bundle extras = getIntent().getExtras();
        type = extras.getInt("type");

        vehicleManager = new VehicleManager();
        vehicles = vehicleManager.loadVehicles(getApplicationContext(),extras.getInt("vehicleType"));

        for(int i=0;i<vehicles.size();i++) {
            if(vehicles.get(i).getRegistration().equals(extras.getString("registration"))) {
                vehicle = vehicles.get(i);
                break;
            }
        }

        if(type==1) {
            label.setText("Insurance value:");
            add.setText("Register insurance");
        }

        else if(type==2) {
            label.setText("Inspection value:");
            add.setText("Register inspection");
        }

        else if(type==3) {
            label.setText("Tax value:");
            add.setText("Register tax");
        }

        else {
            label.setText("Revision value:");
            add.setText("Register revision");
        }
    }

    public void onAdd(View view) {
        ArrayList<InsuranceInspectionTaxRevision> list;
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR));
        InsuranceInspectionTaxRevision newRegister = new InsuranceInspectionTaxRevision(date, Integer.parseInt(value.getText().toString()));

        if (type == 1) {
            list = vehicle.getInsurance();
            list.add(newRegister);
            vehicle.setInsurance(list);
        }
        else if (type == 2) {
            list = vehicle.getInspection();
            list.add(newRegister);
            vehicle.setInspection(list);
        }
        else if (type == 3) {
            list = vehicle.getTax();
            list.add(newRegister);
            vehicle.setTax(list);
        }
        else {
            list = vehicle.getRevision();
            list.add(newRegister);
            vehicle.setRevision(list);
        }

        vehicleManager.cleanVehicles(getApplicationContext());
        vehicleManager.addVehicle(getApplicationContext(),vehicle);

        for(int i=0;i<vehicles.size();i++) {
            if(!vehicles.get(i).getRegistration().equals(vehicle.getRegistration()))
                vehicleManager.addVehicle(getApplicationContext(),vehicles.get(i));
        }

        if(type == 1)
            Toast.makeText(getApplicationContext(), "Insurance registered successfully.", Toast.LENGTH_SHORT).show();
        if(type == 2)
            Toast.makeText(getApplicationContext(), "Inspection registered successfully.", Toast.LENGTH_SHORT).show();
        if(type == 3)
            Toast.makeText(getApplicationContext(), "Tax registered successfully.", Toast.LENGTH_SHORT).show();
        if(type == 4)
            Toast.makeText(getApplicationContext(), "Revision registered successfully.", Toast.LENGTH_SHORT).show();
        finish();
    }
}