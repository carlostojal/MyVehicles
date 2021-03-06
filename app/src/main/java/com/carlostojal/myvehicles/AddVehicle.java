package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// AddVehicle.java
// MyVehicles
// github.com/carlostojal/MyVehicles
//

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class AddVehicle extends AppCompatActivity {

    int type;
    EditText brand;
    EditText model;
    EditText displacement;
    EditText year;
    EditText registration;
    Button addVehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Locale.getDefault().getLanguage().equals("pt"))
            setContentView(R.layout.activity_add_vehicle_pt);
        else
            setContentView(R.layout.activity_add_vehicle);

        brand = (EditText) findViewById(R.id.brand_field);
        model = (EditText) findViewById(R.id.model_field);
        displacement = (EditText) findViewById(R.id.displacement_field);
        year = (EditText) findViewById(R.id.year_field);
        registration = (EditText) findViewById(R.id.registration_field);
        addVehicle = (Button) findViewById(R.id.add_vehicle);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
            type = extras.getInt("type");

        if(type==1) {
            if(Locale.getDefault().getLanguage().equals("pt")) {
                setTitle("Adicionar Carro");
                addVehicle.setText("Adicionar Carro");
            }
            else {
                setTitle("Add Car");
                addVehicle.setText("Add Car");
            }
        }
        else if(type==2) {
            if(Locale.getDefault().getLanguage().equals("pt")) {
                setTitle("Adicionar Motociclo");
                addVehicle.setText("Adicionar Motociclo");
            }
            else {
                setTitle("Add Motorcycle");
                addVehicle.setText("Add Motorcycle");
            }
        }
        else {
            if(Locale.getDefault().getLanguage().equals("pt")) {
                setTitle("Adicionar Veículo");
                addVehicle.setText("Adicionar Veículo");
            }
            else {
                setTitle("Add Vehicle");
                addVehicle.setText("Add Vehicle");
            }
        }
    }

    public void onAddVehicle(View view) {
        VehicleManager vehicleManager = new VehicleManager();

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
        revision.add(newRevision);

        Vehicle newVehicle = new Vehicle(type,brand_value,model_value,displacement_value,year_value,registration_value,insurance,inspection,tax,revision);
        //Toast.makeText(getApplicationContext(), newVehicle.getType()+"\n"+newVehicle.getBrand()+"\n"+newVehicle.getModel(), Toast.LENGTH_SHORT).show();
        if(!brand_value.equals("")&&!model_value.equals("")&&!registration_value.equals("")) {
            if (vehicleManager.addVehicle(getApplicationContext(), newVehicle)) {
                if(type==1) {
                    if(Locale.getDefault().getLanguage().equals("pt"))
                        Toast.makeText(getApplicationContext(), "Carro adicionado com sucesso.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), "Car added successfully.", Toast.LENGTH_SHORT).show();
                }
                else if(type==2) {
                    if(Locale.getDefault().getLanguage().equals("pt"))
                        Toast.makeText(getApplicationContext(), "Motociclo adicionado com sucesso.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), "Motorcycle added successfully.", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(Locale.getDefault().getLanguage().equals("pt"))
                        Toast.makeText(getApplicationContext(), "Veículo adicionado com sucesso.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), "Vehicle added successfully.", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(AddVehicle.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
            else {
                if(Locale.getDefault().getLanguage().equals("pt"))
                    Toast.makeText(getApplicationContext(), "Erro. Por favor tente novamente.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Error. Please try again.", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            if(Locale.getDefault().getLanguage().equals("pt"))
                Toast.makeText(getApplicationContext(), "Campos obrigatórios não podem ser deixados em branco.", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(), "Obligatory field's can't be left empty.", Toast.LENGTH_SHORT).show();
        }
    }

}
