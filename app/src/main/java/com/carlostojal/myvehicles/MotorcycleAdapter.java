package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// MotorcycleAdapter.java
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

public class MotorcycleAdapter extends ArrayAdapter<Vehicle> {

    private final Context context;
    private final ArrayList<Vehicle> motorcycles;

    public MotorcycleAdapter(Context context, ArrayList<Vehicle> motorcycles) {
        super(context,R.layout.vehicle,motorcycles);
        this.context = context;
        this.motorcycles = motorcycles;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.vehicle,parent,false);

        TextView brand_model = (TextView) rowView.findViewById(R.id.brand_model);
        TextView registration = (TextView) rowView.findViewById(R.id.registration);
        TextView lastInsurance = (TextView) rowView.findViewById(R.id.lastInsurance);
        TextView lastInspection = (TextView) rowView.findViewById(R.id.lastInspection);
        TextView lastTax = (TextView) rowView.findViewById(R.id.lastTax);
        TextView lastRevision = (TextView) rowView.findViewById(R.id.lastRevision);

        StringBuilder brand_model_text = new StringBuilder();
        brand_model_text.append(motorcycles.get(position).getBrand());
        brand_model_text.append(" ");
        brand_model_text.append(motorcycles.get(position).getModel());
        brand_model.setText(brand_model_text);

        String registration_text = motorcycles.get(position).getRegistration();
        registration.setText(registration_text);

        StringBuilder insurance_text = new StringBuilder();
        insurance_text.append("Last insurance: ");
        if (motorcycles.get(position).getInsurance().get(motorcycles.get(position).getInsurance().size() - 1).getDate().getDay() != 0) {
            insurance_text.append(String.valueOf(motorcycles.get(position).getInsurance().get(motorcycles.get(position).getInsurance().size() - 1).getDate().getDay()));
            insurance_text.append("/");
            insurance_text.append(String.valueOf(motorcycles.get(position).getInsurance().get(motorcycles.get(position).getInsurance().size() - 1).getDate().getMonth()));
            insurance_text.append("/");
            insurance_text.append(String.valueOf(motorcycles.get(position).getInsurance().get(motorcycles.get(position).getInsurance().size() - 1).getDate().getYear()));
            insurance_text.append(" - ");
            insurance_text.append(String.valueOf(motorcycles.get(position).getInsurance().get(motorcycles.get(position).getInsurance().size() - 1).getValue()));
        }
        else
            insurance_text.append("No information.");
        lastInsurance.setText(insurance_text);

        StringBuilder inspection_text = new StringBuilder();
        inspection_text.append("Last inspection: ");
        if(motorcycles.get(position).getInspection().get(motorcycles.get(position).getInspection().size()-1).getDate().getDay()!=0) {
            inspection_text.append(String.valueOf(motorcycles.get(position).getInspection().get(motorcycles.get(position).getInspection().size() - 1).getDate().getDay()));
            inspection_text.append("/");
            inspection_text.append(String.valueOf(motorcycles.get(position).getInspection().get(motorcycles.get(position).getInspection().size() - 1).getDate().getMonth()));
            inspection_text.append("/");
            inspection_text.append(String.valueOf(motorcycles.get(position).getInspection().get(motorcycles.get(position).getInspection().size() - 1).getDate().getYear()));
            inspection_text.append(" - ");
            inspection_text.append(String.valueOf(motorcycles.get(position).getInspection().get(motorcycles.get(position).getInspection().size() - 1).getValue()));
        }
        else
            inspection_text.append("No information.");
        lastInspection.setText(inspection_text);

        StringBuilder tax_text = new StringBuilder();
        tax_text.append("Last tax: ");
        if(motorcycles.get(position).getTax().get(motorcycles.get(position).getTax().size()-1).getDate().getDay()!=0) {
            tax_text.append(String.valueOf(motorcycles.get(position).getTax().get(motorcycles.get(position).getTax().size() - 1).getDate().getDay()));
            tax_text.append("/");
            tax_text.append(String.valueOf(motorcycles.get(position).getTax().get(motorcycles.get(position).getTax().size() - 1).getDate().getMonth()));
            tax_text.append("/");
            tax_text.append(String.valueOf(motorcycles.get(position).getTax().get(motorcycles.get(position).getTax().size() - 1).getDate().getYear()));
            tax_text.append(" - ");
            tax_text.append(String.valueOf(motorcycles.get(position).getTax().get(motorcycles.get(position).getTax().size() - 1).getValue()));
        }
        else
            tax_text.append("No information.");
        lastTax.setText(tax_text);

        StringBuilder revision_text = new StringBuilder();
        revision_text.append("Last revision: ");
        if(motorcycles.get(position).getRevision().get(motorcycles.get(position).getRevision().size()-1).getDate().getDay()!=0) {
            revision_text.append(String.valueOf(motorcycles.get(position).getRevision().get(motorcycles.get(position).getRevision().size() - 1).getDate().getDay()));
            revision_text.append("/");
            revision_text.append(String.valueOf(motorcycles.get(position).getRevision().get(motorcycles.get(position).getRevision().size() - 1).getDate().getMonth()));
            revision_text.append("/");
            revision_text.append(String.valueOf(motorcycles.get(position).getRevision().get(motorcycles.get(position).getRevision().size() - 1).getDate().getYear()));
            revision_text.append(" - ");
            revision_text.append(String.valueOf(motorcycles.get(position).getRevision().get(motorcycles.get(position).getRevision().size() - 1).getValue()));
        }
        else
            revision_text.append("No information.");
        lastRevision.setText(revision_text);

        return rowView;
    }
}
