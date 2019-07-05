package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// VehicleManager.java
// MyVehicles
// github.com/carlostojal/MyVehicles
//

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class VehicleManager {
    //Context is needed for opening file
    public void cleanVehicles(Context context) {
        File file = new File(context.getFilesDir(),"vehicles.csv");
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.print("");
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

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
            outputStreamWriter.write("\n");
            outputStreamWriter.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Vehicle> loadCars(Context context) {
        ArrayList<Vehicle> cars = new ArrayList<>();
        File file = new File(context.getFilesDir(),"vehicles.csv");

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            int i;
            int j;
            int type;
            String brand;
            String model;
            int displacement;
            int year;
            String registration;
            int ninsurances;
            ArrayList<InsuranceInspectionTax> insurance = new ArrayList<>();
            int ninspections;
            ArrayList<InsuranceInspectionTax> inspection = new ArrayList<>();
            int ntaxes;
            ArrayList<InsuranceInspectionTax> tax = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            while((line=bufferedReader.readLine())!=null) {
                stringBuilder.append(line);
                /*
                String[] splitStr = line.split("; ");
                type = Integer.parseInt(splitStr[0]);
                brand = splitStr[1];
                model = splitStr[2];
                displacement = Integer.parseInt(splitStr[3]);
                year = Integer.parseInt(splitStr[4]);
                registration = splitStr[5];
                ninsurances = Integer.parseInt(splitStr[6]);
                j=7;
                for(i=0;i<ninsurances;i++) {
                    int dateDay, dateMonth, dateYear;
                    float value;
                    dateDay = Integer.parseInt(splitStr[j]);
                    dateMonth = Integer.parseInt(splitStr[j+1]);
                    dateYear = Integer.parseInt(splitStr[j+2]);
                    Date insuranceDate = new Date(dateDay,dateMonth,dateYear);
                    value = Float.parseFloat(splitStr[j+3]);
                    InsuranceInspectionTax newInsurance = new InsuranceInspectionTax(insuranceDate,value);
                    insurance.add(newInsurance);
                    j+=4;
                }
                ninspections = Integer.parseInt(splitStr[j]);
                j++;
                for(i=0;i<ninspections;i++) {
                    int dateDay, dateMonth, dateYear;
                    float value;
                    dateDay = Integer.parseInt(splitStr[j]);
                    dateMonth = Integer.parseInt(splitStr[j+1]);
                    dateYear = Integer.parseInt(splitStr[j+2]);
                    Date inspectionDate = new Date(dateDay,dateMonth,dateYear);
                    value = Float.parseFloat(splitStr[j+3]);
                    InsuranceInspectionTax newInspection = new InsuranceInspectionTax(inspectionDate,value);
                    inspection.add(newInspection);
                    j+=4;
                }
                ntaxes = Integer.parseInt(splitStr[j]);
                j++;
                for(i=0;i<ntaxes;i++) {
                    int dateDay, dateMonth, dateYear;
                    float value;
                    dateDay = Integer.parseInt(splitStr[j]);
                    dateMonth = Integer.parseInt(splitStr[j+1]);
                    dateYear = Integer.parseInt(splitStr[j+2]);
                    Date taxDate = new Date(dateDay,dateMonth,dateYear);
                    value = Float.parseFloat(splitStr[j+3]);
                    InsuranceInspectionTax newTax = new InsuranceInspectionTax(taxDate,value);
                    tax.add(newTax);
                    if(j+4<splitStr.length)
                        j+=4;
                    else break;
                }

                if(type==1) {
                    Vehicle vehicle = new Vehicle(type, brand, model, displacement, year, registration, insurance, inspection, tax);
                    cars.add(vehicle);
                }*/
                Toast.makeText(context, stringBuilder, Toast.LENGTH_SHORT).show();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public ArrayList<Vehicle> loadMotorcycles(Context context) {
        ArrayList<Vehicle> motorcycles = new ArrayList<>();
        return motorcycles;
    }

    public ArrayList<Vehicle> loadOthers(Context context) {
        ArrayList<Vehicle> others = new ArrayList<>();
        return others;
    }

}
