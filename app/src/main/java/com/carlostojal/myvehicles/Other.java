package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// Other.java
// MyVehicles
// github.com/carlostojal/MyVehicles
//

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

public class Other extends Fragment {

    private ListView otherList;
    private VehicleManager vehicleManager = new VehicleManager();
    private ArrayList<Vehicle> others;
    private Button addOther;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_other, container, false);

        others = vehicleManager.loadVehicles(getContext(),3);
        if(others.size()==0)
            Toast.makeText(getContext(), "No vehicles were found.", Toast.LENGTH_SHORT).show();

        otherList = view.findViewById(R.id.other_list);
        ArrayAdapter otherAdapter = new OtherAdapter(getContext(),others);
        otherList.setAdapter(otherAdapter);

        addOther = (Button) view.findViewById(R.id.add_other);
        addOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddOther();
            }
        });

        otherList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Vehicle selectedVehicle = (Vehicle) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(Other.this.getActivity(), VehicleDetails.class);
                intent.putExtra("registration",selectedVehicle.getRegistration());
                intent.putExtra("type",3);
                startActivity(intent);
            }
        });

        return view;
    }

    public void onAddOther() {
        Intent intent = new Intent(getContext(), AddVehicle.class);
        intent.putExtra("type",3);
        startActivity(intent);
    }
}
