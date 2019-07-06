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
            outputStreamWriter.write(String.valueOf(newVehicle.getType())); //type
            outputStreamWriter.write("; ");
            outputStreamWriter.write(newVehicle.getBrand()); //brand
            outputStreamWriter.write("; ");
            outputStreamWriter.write(newVehicle.getModel()); //model
            outputStreamWriter.write("; ");
            outputStreamWriter.write(String.valueOf(newVehicle.getDisplacement())); //displacement
            outputStreamWriter.write("; ");
            outputStreamWriter.write(String.valueOf(newVehicle.getYear())); //year
            outputStreamWriter.write("; ");
            outputStreamWriter.write(newVehicle.getRegistration()); //registration
            outputStreamWriter.write("; ");
            outputStreamWriter.write(String.valueOf(newVehicle.getInsurance().size()));
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
            outputStreamWriter.write(String.valueOf(newVehicle.getInspection().size()));
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
            outputStreamWriter.write(String.valueOf(newVehicle.getTax().size()));
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
            outputStreamWriter.write("; ");
            outputStreamWriter.write(String.valueOf(newVehicle.getRevision().size()));
            for(int i=0;i<newVehicle.getRevision().size();i++) { //revision
                outputStreamWriter.write("; ");
                outputStreamWriter.write(String.valueOf(newVehicle.getRevision().get(i).getDate().getDay()));
                outputStreamWriter.write("; ");
                outputStreamWriter.write(String.valueOf(newVehicle.getRevision().get(i).getDate().getMonth()));
                outputStreamWriter.write("; ");
                outputStreamWriter.write(String.valueOf(newVehicle.getRevision().get(i).getDate().getYear()));
                outputStreamWriter.write("; ");
                outputStreamWriter.write(String.valueOf(newVehicle.getRevision().get(i).getValue()));
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
            ArrayList<InsuranceInspectionTaxRevision> insurance = new ArrayList<>();
            int ninspections;
            ArrayList<InsuranceInspectionTaxRevision> inspection = new ArrayList<>();
            int ntaxes;
            ArrayList<InsuranceInspectionTaxRevision> tax = new ArrayList<>();
            int nrevisions;
            ArrayList<InsuranceInspectionTaxRevision> revision = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            while((line=bufferedReader.readLine())!=null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
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
                    InsuranceInspectionTaxRevision newInsurance = new InsuranceInspectionTaxRevision(insuranceDate,value);
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
                    InsuranceInspectionTaxRevision newInspection = new InsuranceInspectionTaxRevision(inspectionDate,value);
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
                    InsuranceInspectionTaxRevision newTax = new InsuranceInspectionTaxRevision(taxDate,value);
                    tax.add(newTax);
                    j+=4;
                }
                nrevisions = Integer.parseInt(splitStr[j]);
                j++;
                for(i=0;i<nrevisions;i++) {
                    int dateDay, dateMonth, dateYear;
                    float value;
                    dateDay = Integer.parseInt(splitStr[j]);
                    dateMonth = Integer.parseInt(splitStr[j+1]);
                    dateYear = Integer.parseInt(splitStr[j+2]);
                    Date revisionDate = new Date(dateDay,dateMonth,dateYear);
                    value = Float.parseFloat(splitStr[j+3]);
                    InsuranceInspectionTaxRevision newRevision = new InsuranceInspectionTaxRevision(revisionDate,value);
                    tax.add(newRevision);
                    if(j+4<splitStr.length)
                        j+=4;
                    else break;
                }

                if(type==1) {
                    Vehicle vehicle = new Vehicle(type, brand, model, displacement, year, registration, insurance, inspection, tax, revision);
                    cars.add(vehicle);
                }
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
