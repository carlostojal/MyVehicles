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
import java.util.Locale;

public class InsurancesInspectionsTaxesRevisions extends AppCompatActivity {

    ArrayList<Vehicle> vehicles;
    Vehicle vehicle;
    int type;

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
        type = extras.getInt("type");
        vehicles = vehicleManager.loadVehicles(getApplicationContext(),vehicleType);
        for(int i=0;i<vehicles.size();i++) {
            if(vehicles.get(i).getRegistration().equals(registration))
                vehicle = vehicles.get(i);
        }
        if(type==1) { //insurance
            if(Locale.getDefault().getLanguage().equals("pt")) {
                setTitle("Seguros");
                label.setText("Histórico de seguro do veículo:");
                add.setText("Registar seguro");
            }
            else {
                setTitle("Insurances");
                label.setText("Vehicle insurance history:");
                add.setText("Register insurance");
            }

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
                    insurancesInspectionsTaxesRevisions.append("\n");
                }
            }
            if(vehicle.getInsurance().size()==1&&vehicle.getInsurance().get(0).getDate().getDay()==0) {
                if(Locale.getDefault().getLanguage().equals("pt"))
                    insurancesInspectionsTaxesRevisions.append("Sem informação.");
                else
                    insurancesInspectionsTaxesRevisions.append("No information.");
            }

            history.setText(insurancesInspectionsTaxesRevisions);
        }
        else if(type==2) { //inspection
            if(Locale.getDefault().getLanguage().equals("pt")) {
                setTitle("Inspeções");
                label.setText("Histórico de inspeções do veículo:");
                add.setText("Registar inspeção");
            }
            else {
                setTitle("Inspections");
                label.setText("Vehicle inspection history:");
                add.setText("Register inspection");
            }

            for(int i=0;i<vehicle.getInspection().size();i++) {
                if(vehicle.getInspection().get(i).getDate().getDay()!=0) {
                    insurancesInspectionsTaxesRevisions.append("• ");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getInspection().get(i).getDate().getDay()));
                    insurancesInspectionsTaxesRevisions.append("/");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getInspection().get(i).getDate().getMonth()));
                    insurancesInspectionsTaxesRevisions.append("/");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getInspection().get(i).getDate().getYear()));
                    insurancesInspectionsTaxesRevisions.append(" - ");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getInspection().get(i).getValue()));
                    insurancesInspectionsTaxesRevisions.append("\n");
                }
            }
            if(vehicle.getInspection().size()==1&&vehicle.getInspection().get(0).getDate().getDay()==0) {
                if(Locale.getDefault().getLanguage().equals("pt"))
                    insurancesInspectionsTaxesRevisions.append("Sem informação.");
                else
                    insurancesInspectionsTaxesRevisions.append("No information.");
            }

            history.setText(insurancesInspectionsTaxesRevisions);
        }
        else if(type==3) { //tax
            if(Locale.getDefault().getLanguage().equals("pt")) {
                setTitle("Impostos");
                label.setText("Histórico de impostos do veículo:");
                add.setText("Registar imposto");
            }
            else {
                setTitle("Taxes");
                label.setText("Vehicle tax history:");
                add.setText("Register tax");
            }

            for(int i=0;i<vehicle.getTax().size();i++) {
                if(vehicle.getTax().get(i).getDate().getDay()!=0) {
                    insurancesInspectionsTaxesRevisions.append("• ");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getTax().get(i).getDate().getDay()));
                    insurancesInspectionsTaxesRevisions.append("/");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getTax().get(i).getDate().getMonth()));
                    insurancesInspectionsTaxesRevisions.append("/");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getTax().get(i).getDate().getYear()));
                    insurancesInspectionsTaxesRevisions.append(" - ");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getTax().get(i).getValue()));
                    insurancesInspectionsTaxesRevisions.append("\n");

                }
            }
            if(vehicle.getTax().size()==1&&vehicle.getTax().get(0).getDate().getDay()==0) {
                if(Locale.getDefault().getLanguage().equals("pt"))
                    insurancesInspectionsTaxesRevisions.append("Sem informação.");
                else
                    insurancesInspectionsTaxesRevisions.append("No information.");
            }

            history.setText(insurancesInspectionsTaxesRevisions);
        }
        else if(type==4) { //revision
            if(Locale.getDefault().getLanguage().equals("pt")) {
                setTitle("Revisões");
                label.setText("Histórico de revisões do veículo:");
                add.setText("Registar revisão");
            }
            setTitle("Revisions");
            label.setText("Vehicle revision history:");
            add.setText("Register revision");

            for(int i=0;i<vehicle.getRevision().size();i++) {
                if(vehicle.getRevision().get(i).getDate().getDay()!=0) {
                    insurancesInspectionsTaxesRevisions.append("• ");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getRevision().get(i).getDate().getDay()));
                    insurancesInspectionsTaxesRevisions.append("/");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getRevision().get(i).getDate().getMonth()));
                    insurancesInspectionsTaxesRevisions.append("/");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getRevision().get(i).getDate().getYear()));
                    insurancesInspectionsTaxesRevisions.append(" - ");
                    insurancesInspectionsTaxesRevisions.append(String.valueOf(vehicle.getRevision().get(i).getValue()));
                    insurancesInspectionsTaxesRevisions.append("\n");
                }
            }
            if(vehicle.getRevision().size()==1&&vehicle.getRevision().get(0).getDate().getDay()==0) {
                if(Locale.getDefault().getLanguage().equals("pt"))
                    insurancesInspectionsTaxesRevisions.append("Sem informação.");
                else
                    insurancesInspectionsTaxesRevisions.append("No information.");
            }

            history.setText(insurancesInspectionsTaxesRevisions);
        }
    }

    public void onRegister(View view) {
        Intent intent = new Intent(InsurancesInspectionsTaxesRevisions.this,AddInsuranceInspectionTaxRevision.class);
        intent.putExtra("registration",vehicle.getRegistration());
        intent.putExtra("vehicleType",vehicle.getType());
        intent.putExtra("type",type);
        startActivity(intent);
        finish();
    }
}
