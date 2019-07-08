package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// InsurancesInspectionsTaxesRevisions.java
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
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class InsurancesInspectionsTaxesRevisions extends AppCompatActivity {

    ArrayList<Vehicle> vehicles;
    Vehicle vehicle;

    TextView label;
    TextView history;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurances_inspections_taxes_revisions);

        label = findViewById(R.id.label);
        history = findViewById(R.id.history);
        add = findViewById(R.id.addInsuranceInspectionTaxRevision);

        StringBuilder insurancesInspectionsTaxesRevisions = new StringBuilder();
        VehicleManager vehicleManager = new VehicleManager();
        Bundle extras = getIntent().getExtras();
        String registration = extras.getString("registration"); //vehicle registration
        int vehicleType = extras.getInt("vehicleType");
        int type = extras.getInt("type");
        vehicles = vehicleManager.loadVehicles(getApplicationContext(),vehicleType);
        for(int i=0;i<vehicles.size();i++) {
            if(vehicles.get(i).getRegistration().equals(registration))
                vehicle = vehicles.get(i);
        }
        if(type==1) { //insurance
            setTitle("Insurances");
            label.setText("Vehicle insurance history:");
            add.setText("Register insurance");

            for(int i=0;i<vehicle.getInsurance().size();i++) {
                if(vehicle.getInsurance().get(i).getDate().getDay()!=0) {
                    insurancesInspectionsTaxesRevisions.append("• ");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getInsurance().get(i).getDate().getDay()));
                    insurancesInspectionsTaxesRevisions.append("/");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getInsurance().get(i).getDate().getMonth()));
                    insurancesInspectionsTaxesRevisions.append("/");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getInsurance().get(i).getDate().getYear()));
                    insurancesInspectionsTaxesRevisions.append(" - ");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getInsurance().get(i).getValue()));
                }
            }
            if(vehicle.getInsurance().size()==1&&vehicle.getInsurance().get(0).getDate().getDay()==0) {
                insurancesInspectionsTaxesRevisions.append("No information.");
            }

            history.setText(insurancesInspectionsTaxesRevisions);
        }
        else if(type==2) { //inspection
            setTitle("Inspections");
            label.setText("Vehicle inspection history:");
            add.setText("Register inspection");

            for(int i=0;i<vehicle.getInsurance().size();i++) {
                if(vehicle.getInsurance().get(i).getDate().getDay()!=0) {
                    insurancesInspectionsTaxesRevisions.append("• ");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getInspection().get(i).getDate().getDay()));
                    insurancesInspectionsTaxesRevisions.append("/");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getInspection().get(i).getDate().getMonth()));
                    insurancesInspectionsTaxesRevisions.append("/");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getInspection().get(i).getDate().getYear()));
                    insurancesInspectionsTaxesRevisions.append(" - ");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getInspection().get(i).getValue()));
                }
            }
            if(vehicle.getInspection().size()==1&&vehicle.getInspection().get(0).getDate().getDay()==0) {
                insurancesInspectionsTaxesRevisions.append("No information.");
            }

            history.setText(insurancesInspectionsTaxesRevisions);
        }
        else if(type==3) { //tax
            setTitle("Taxes");
            label.setText("Vehicle tax history:");
            add.setText("Register tax");

            for(int i=0;i<vehicle.getInsurance().size();i++) {
                if(vehicle.getInsurance().get(i).getDate().getDay()!=0) {
                    insurancesInspectionsTaxesRevisions.append("• ");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getTax().get(i).getDate().getDay()));
                    insurancesInspectionsTaxesRevisions.append("/");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getTax().get(i).getDate().getMonth()));
                    insurancesInspectionsTaxesRevisions.append("/");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getTax().get(i).getDate().getYear()));
                    insurancesInspectionsTaxesRevisions.append(" - ");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getTax().get(i).getValue()));
                }
            }
            if(vehicle.getTax().size()==1&&vehicle.getTax().get(0).getDate().getDay()==0) {
                insurancesInspectionsTaxesRevisions.append("No information.");
            }

            history.setText(insurancesInspectionsTaxesRevisions);
        }
        else if(type==4) { //revision
            setTitle("Revisions");
            label.setText("Vehicle revision history:");
            add.setText("Register revision");

            for(int i=0;i<vehicle.getInsurance().size();i++) {
                if(vehicle.getInsurance().get(i).getDate().getDay()!=0) {
                    insurancesInspectionsTaxesRevisions.append("• ");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getRevision().get(i).getDate().getDay()));
                    insurancesInspectionsTaxesRevisions.append("/");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getRevision().get(i).getDate().getMonth()));
                    insurancesInspectionsTaxesRevisions.append("/");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getRevision().get(i).getDate().getYear()));
                    insurancesInspectionsTaxesRevisions.append(" - ");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getRevision().get(i).getValue()));
                }
            }
            if(vehicle.getRevision().size()==1&&vehicle.getRevision().get(0).getDate().getDay()==0) {
                insurancesInspectionsTaxesRevisions.append("No information.");
            }

            history.setText(insurancesInspectionsTaxesRevisions);
        }
    }

    public void onRegister(View view) {
        Intent intent = new Intent(InsurancesInspectionsTaxesRevisions.this,AddInsuranceInspectionTaxRevision.class);
        startActivity(intent);
    }
}
