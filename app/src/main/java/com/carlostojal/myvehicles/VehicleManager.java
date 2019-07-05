package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// VehicleManager.java
// MyVehicles
// github.com/carlostojal/MyVehicles
//

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class VehicleManager {
    //Context is needed for opening file
    public boolean addVehicle(Context context,Vehicle newVehicle) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("vehicles.csv",Context.MODE_APPEND));
            outputStreamWriter.write(newVehicle.getType()); //type
            outputStreamWriter.write("; ");
            outputStreamWriter.write(newVehicle.getBrand()); //brand
            outputStreamWriter.write("; ");
            outputStreamWriter.write(newVehicle.getModel()); //model
            outputStreamWriter.write("; ");
            outputStreamWriter.write(newVehicle.getDisplacement()); //displacement
            outputStreamWriter.write("; ");
            outputStreamWriter.write(newVehicle.getYear()); //year
            outputStreamWriter.write("; ");
            outputStreamWriter.write(newVehicle.getRegistration()); //registration
            outputStreamWriter.write("; ");
            outputStreamWriter.write(newVehicle.getInsurance().size());
            for(int i=0;i<newVehicle.getInsurance().size();i++) { //insurance
                outputStreamWriter.write("; ");
                outputStreamWriter.write(String.valueOf(newVehicle.getInsurance().get(i).getDate().getDay()));
                outputStreamWriter.write("; ");
                outputStreamWriter.write(String.valueOf(newVehicle.getInsurance().get(i).getDate().getMonth()));
                outputStreamWriter.write("; ");
                outputStreamWriter.write(String.valueOf(newVehicle.getInsurance().get(i).getDate().getYear()));
                outputStreamWriter.write("; ");
                outputStreamWriter.write(String.valueOf(newVehicle.getInsurance().get(i).getValue()));
            }
            outputStreamWriter.write("; ");
            outputStreamWriter.write(newVehicle.getInspection().size());
            for(int i=0;i<newVehicle.getInspection().size();i++) { //inspection
                outputStreamWriter.write("; ");
                outputStreamWriter.write(String.valueOf(newVehicle.getInspection().get(i).getDate().getDay()));
                outputStreamWriter.write("; ");
                outputStreamWriter.write(String.valueOf(newVehicle.getInspection().get(i).getDate().getMonth()));
                outputStreamWriter.write("; ");
                outputStreamWriter.write(String.valueOf(newVehicle.getInspection().get(i).getDate().getYear()));
                outputStreamWriter.write("; ");
                outputStreamWriter.write(String.valueOf(newVehicle.getInspection().get(i).getValue()));
            }
            outputStreamWriter.write("; ");
            outputStreamWriter.write(newVehicle.getTax().size());
            for(int i=0;i<newVehicle.getTax().size();i++) { //tax
                outputStreamWriter.write("; ");
                outputStreamWriter.write(String.valueOf(newVehicle.getTax().get(i).getDate().getDay()));
                outputStreamWriter.write("; ");
                outputStreamWriter.write(String.valueOf(newVehicle.getTax().get(i).getDate().getMonth()));
                outputStreamWriter.write("; ");
                outputStreamWriter.write(String.valueOf(newVehicle.getTax().get(i).getDate().getYear()));
                outputStreamWriter.write("; ");
                outputStreamWriter.write(String.valueOf(newVehicle.getTax().get(i).getValue()));
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private ArrayList<Vehicle> loadCars(Context context) {
        ArrayList<Vehicle> cars = new ArrayList<>();
        return cars;
    }

    private ArrayList<Vehicle> loadMotorcycles(Context context) {
        ArrayList<Vehicle> motorcycles = new ArrayList<>();
        return motorcycles;
    }

    private ArrayList<Vehicle> loadOthers(Context context) {
        ArrayList<Vehicle> others = new ArrayList<>();
        return others;
    }

}
