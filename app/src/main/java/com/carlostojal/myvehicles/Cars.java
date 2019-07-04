package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// Cars.java
// MyVehicles
// github.com/carlostojal/MyVehicles
//

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Cars extends Fragment {

    ArrayList<Vehicle> cars;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cars, container, false);

        return view;
    }
}