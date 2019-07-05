package com.carlostojal.myvehicles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class OtherAdapter {

    private final Context context;
    private final ArrayList<Vehicle> others;

    public OtherAdapter(Context context, ArrayList<Vehicle> others) {
        this.context = context;
        this.others = others;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.vehicle,parent,false);

        TextView brand_model = (TextView) rowView.findViewById(R.id.brand_model);
        TextView registration = (TextView) rowView.findViewById(R.id.registration);

        StringBuilder brand_model_text = new StringBuilder();
        brand_model_text.append(others.get(position).getBrand());
        brand_model_text.append(" ");
        brand_model_text.append(others.get(position).getModel());
        brand_model.setText(brand_model_text);

        String registration_text = others.get(position).getRegistration();
        registration.setText(registration_text);

        return rowView;
    }
}
