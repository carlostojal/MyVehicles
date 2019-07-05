package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// CarAdapter.java
// MyVehicles
// github.com/carlostojal/MyVehicles
//

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CarAdapter extends ArrayAdapter<Vehicle> {

    private final Context context;
    private final ArrayList<Vehicle> cars;

    public CarAdapter(Context context, ArrayList<Vehicle> cars) {
        super(context,R.layout.vehicle,cars);
        this.context = context;
        this.cars = cars;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.vehicle,parent,false);

        TextView brand_model = (TextView) rowView.findViewById(R.id.brand_model);
        TextView registration = (TextView) rowView.findViewById(R.id.registration);

        StringBuilder brand_model_text = new StringBuilder();
        brand_model_text.append(cars.get(position).getBrand());
        brand_model_text.append(" ");
        brand_model_text.append(cars.get(position).getModel());
        brand_model.setText(brand_model_text);

        String registration_text = cars.get(position).getRegistration();
        registration.setText(registration_text);

        return rowView;
    }
}
