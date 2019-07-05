package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// Vehicle.java
// MyVehicles
// github.com/carlostojal/MyVehicles
//

import java.util.ArrayList;

public class Vehicle {
    private int type; //1 - Car; 2 - Motorcycle; 3 - Other
    private String brand;
    private String model;
    private int displacement;
    private int year;
    private String registration;
    private ArrayList<InsuranceInspectionTax> insurance;
    private ArrayList<InsuranceInspectionTax> inspection;
    private ArrayList<InsuranceInspectionTax> tax;

    public Vehicle(int type, String brand, String model, int displacement, int year, String registration, ArrayList<InsuranceInspectionTax> insurance, ArrayList<InsuranceInspectionTax> inspection, ArrayList<InsuranceInspectionTax> tax) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.displacement = displacement;
        this.year = year;
        this.registration = registration;
        this.insurance = insurance;
        this.inspection = inspection;
        this.tax = tax;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public ArrayList<InsuranceInspectionTax> getInsurance() {
        return insurance;
    }

    public void setInsurance(ArrayList<InsuranceInspectionTax> insurance) {
        this.insurance = insurance;
    }

    public ArrayList<InsuranceInspectionTax> getInspection() {
        return inspection;
    }

    public void setInspection(ArrayList<InsuranceInspectionTax> inspection) {
        this.inspection = inspection;
    }

    public ArrayList<InsuranceInspectionTax> getTax() {
        return tax;
    }

    public void setTax(ArrayList<InsuranceInspectionTax> tax) {
        this.tax = tax;
    }
}
