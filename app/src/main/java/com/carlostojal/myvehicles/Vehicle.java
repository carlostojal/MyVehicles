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
    private ArrayList<InsuranceInspectionTaxRevision> insurance;
    private ArrayList<InsuranceInspectionTaxRevision> inspection;
    private ArrayList<InsuranceInspectionTaxRevision> tax;
    private ArrayList<InsuranceInspectionTaxRevision> revision;

    public Vehicle(int type, String brand, String model, int displacement, int year, String registration, ArrayList<InsuranceInspectionTaxRevision> insurance, ArrayList<InsuranceInspectionTaxRevision> inspection, ArrayList<InsuranceInspectionTaxRevision> tax, ArrayList<InsuranceInspectionTaxRevision> revision) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.displacement = displacement;
        this.year = year;
        this.registration = registration;
        this.insurance = insurance;
        this.inspection = inspection;
        this.tax = tax;
        this.revision = revision;
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

    public ArrayList<InsuranceInspectionTaxRevision> getInsurance() {
        return insurance;
    }

    public void setInsurance(ArrayList<InsuranceInspectionTaxRevision> insurance) {
        this.insurance = insurance;
    }

    public ArrayList<InsuranceInspectionTaxRevision> getInspection() {
        return inspection;
    }

    public void setInspection(ArrayList<InsuranceInspectionTaxRevision> inspection) {
        this.inspection = inspection;
    }

    public ArrayList<InsuranceInspectionTaxRevision> getTax() {
        return tax;
    }

    public void setTax(ArrayList<InsuranceInspectionTaxRevision> tax) {
        this.tax = tax;
    }

    public ArrayList<InsuranceInspectionTaxRevision> getRevision() {
        return revision;
    }

    public void setRevision(ArrayList<InsuranceInspectionTaxRevision> revision) {
        this.revision = revision;
    }
}
