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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Other extends Fragment {

    private ListView otherList;
    private VehicleManager vehicleManager = new VehicleManager();
    private ArrayList<Vehicle> others;
    private Button addOther;
    private boolean isStarted = false;
    private boolean isVisible = false;


    @Override
    public void onStart() {
        super.onStart();
        vehicleManager = new VehicleManager();
        isStarted = true;
        if(isVisible&&isStarted) {
            others = vehicleManager.loadVehicles(getContext(),3);
            if(others.size()>0) {
                ArrayAdapter otherAdapter = new OtherAdapter(getContext(), others);
                otherList.setAdapter(otherAdapter);
            }
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        vehicleManager = new VehicleManager();
        isVisible = isVisibleToUser;
        if (isStarted && isVisible) {
            others = vehicleManager.loadVehicles(getContext(),3);
            if(others.size()>0) {
                ArrayAdapter otherAdapter = new OtherAdapter(getContext(), others);
                otherList.setAdapter(otherAdapter);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        others = vehicleManager.loadVehicles(getContext(),3);
        if(others.size()==0) {
            view = inflater.inflate(R.layout.empty_list, container, false);
            TextView label = (TextView) view.findViewById(R.id.textView);
            if(Locale.getDefault().getLanguage().equals("pt"))
                label.setText("Não foram encontrados veículos.");
            else
                label.setText("No vehicles were found.");
            addOther = (Button) view.findViewById(R.id.button);
            if(Locale.getDefault().getLanguage().equals("pt"))
                addOther.setText("Adicionar Veículo");
            else
                addOther.setText("Add Vehicle");
            addOther.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onAddOther();
                }
            });
        }
        else {
            if(Locale.getDefault().getLanguage().equals("pt"))
                view = inflater.inflate(R.layout.fragment_other_pt, container, false);
            else
                view = inflater.inflate(R.layout.fragment_other, container, false);
            otherList = view.findViewById(R.id.other_list);
            ArrayAdapter otherAdapter = new OtherAdapter(getContext(), others);
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
                    intent.putExtra("registration", selectedVehicle.getRegistration());
                    intent.putExtra("type", 3);
                    startActivity(intent);
                }
            });
        }
        return view;
    }

    public void onAddOther() {
        Intent intent = new Intent(getContext(), AddVehicle.class);
        intent.putExtra("type",3);
        startActivity(intent);
        getActivity().finish();
    }
}
