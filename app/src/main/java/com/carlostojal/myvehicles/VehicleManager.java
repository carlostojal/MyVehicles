package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// VehicleManager.java
// MyVehicles
// github.com/carlostojal/MyVehicles
//

import android.content.Context;

import java.util.ArrayList;

public class VehicleManager {

    //Context is needed for opening file
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
