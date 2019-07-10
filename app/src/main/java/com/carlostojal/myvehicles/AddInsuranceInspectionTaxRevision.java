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
import java.util.Locale;

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
        if(Locale.getDefault().getLanguage().equals("pt"))
            setContentView(R.layout.activity_add_insurance_inspection_tax_revision_pt);
        else
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
            if(Locale.getDefault().getLanguage().equals("pt")) {
                label.setText("Custo do seguro:");
                add.setText("Registar seguro");
            }
            else {
                label.setText("Insurance cost:");
                add.setText("Register insurance");
            }
        }

        else if(type==2) {
            if(Locale.getDefault().getLanguage().equals("pt")) {
                label.setText("Custo da inspeção:");
                add.setText("Registar inspeção");
            }
            else {
                label.setText("Inspection cost:");
                add.setText("Register inspection");
            }
        }

        else if(type==3) {
            if(Locale.getDefault().getLanguage().equals("pt")) {
                label.setText("Custo do imposto:");
                add.setText("Registar imposto");
            }
            else {
                label.setText("Tax cost:");
                add.setText("Register tax");
            }
        }

        else {
            if(Locale.getDefault().getLanguage().equals("pt")) {
                label.setText("Custo da revisão:");
                add.setText("Registar revisão");
            }
            else {
                label.setText("Revision cost:");
                add.setText("Register revision");
            }
        }
    }

    public void onAdd(View view) {
        ArrayList<InsuranceInspectionTaxRevision> list;
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR));
        if(!value.getText().toString().equals("")) {
            InsuranceInspectionTaxRevision newRegister = new InsuranceInspectionTaxRevision(date, Float.parseFloat(value.getText().toString()));

            if (type == 1) {
                list = vehicle.getInsurance();
                list.add(newRegister);
                vehicle.setInsurance(list);
            } else if (type == 2) {
                list = vehicle.getInspection();
                list.add(newRegister);
                vehicle.setInspection(list);
            } else if (type == 3) {
                list = vehicle.getTax();
                list.add(newRegister);
                vehicle.setTax(list);
            } else {
                list = vehicle.getRevision();
                list.add(newRegister);
                vehicle.setRevision(list);
            }

            vehicleManager.cleanVehicles(getApplicationContext());
            vehicleManager.addVehicle(getApplicationContext(), vehicle);

            for (int i = 0; i < vehicles.size(); i++) {
                if (!vehicles.get(i).getRegistration().equals(vehicle.getRegistration()))
                    vehicleManager.addVehicle(getApplicationContext(), vehicles.get(i));
            }

            if (type == 1) {
                if(Locale.getDefault().getLanguage().equals("pt"))
                    Toast.makeText(getApplicationContext(), "Seguro registado com sucesso.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Insurance registered successfully.", Toast.LENGTH_SHORT).show();
            }
            else if (type == 2) {
                if(Locale.getDefault().getLanguage().equals("pt"))
                    Toast.makeText(getApplicationContext(), "Inspeção registada com sucesso.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Inspection registered successfully.", Toast.LENGTH_SHORT).show();
            }
            else if (type == 3) {
                if(Locale.getDefault().getLanguage().equals("pt"))
                    Toast.makeText(getApplicationContext(), "Imposto registado com sucesso.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Tax registered successfully.", Toast.LENGTH_SHORT).show();
            }
            else {
                if(Locale.getDefault().getLanguage().equals("pt"))
                    Toast.makeText(getApplicationContext(), "Revisão registada com sucesso.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Revision registered successfully.", Toast.LENGTH_SHORT).show();
            }
            finish();
        }
        else {
            if(Locale.getDefault().getLanguage().equals("pt"))
                Toast.makeText(getApplicationContext(), "O campo do custo não pode ser deixado vazio.", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(), "Cost field can't be left empty.", Toast.LENGTH_SHORT).show();
        }
    }
}