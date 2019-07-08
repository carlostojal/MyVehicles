package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// Motorcycles.java
// MyVehicles
// github.com/carlostojal/MyVehicles
//

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Motorcycles extends Fragment {

    private ListView motorcycleList;
    private VehicleManager vehicleManager = new VehicleManager();
    private ArrayList<Vehicle> motorcycles;
    private Button addMotorcycle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_motorcycles, container, false);

        motorcycles = vehicleManager.loadVehicles(getContext(),2);
        if(motorcycles.size()==0)
            Toast.makeText(getContext(), "No motorcycles were found.", Toast.LENGTH_SHORT).show();

        motorcycleList = view.findViewById(R.id.motorcycles_list);
        ArrayAdapter motorcycleAdapter = new MotorcycleAdapter(getContext(),motorcycles);
        motorcycleList.setAdapter(motorcycleAdapter);

        addMotorcycle = (Button) view.findViewById(R.id.add_motorcycle);
        addMotorcycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddMotorcycle();
            }
        });

        motorcycleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Vehicle selectedVehicle = (Vehicle) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(Motorcycles.this.getActivity(), VehicleDetails.class);
                intent.putExtra("registration",selectedVehicle.getRegistration());
                intent.putExtra("type",2);
                startActivity(intent);
            }
        });

        return view;
    }

    public void onAddMotorcycle() {
        Intent intent = new Intent(getContext(), AddVehicle.class);
        intent.putExtra("type",2);
        startActivity(intent);
    }
}
