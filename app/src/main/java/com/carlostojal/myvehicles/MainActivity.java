package com.carlostojal.myvehicles;

//
// Copyright © Carlos Tojal (carlostojal)
// MainActivity.java
// MyVehicles
// github.com/carlostojal/MyVehicles
//

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.view_pager);
        setupViewPager(mViewPager);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        if(Locale.getDefault().getLanguage().equals("pt")) {
            adapter.addFragment(new Cars(), "Carros");
            adapter.addFragment(new Motorcycles(),"Motociclos");
            adapter.addFragment(new Other(),"Outros");
        }
        else {
            adapter.addFragment(new Cars(), "Cars");
            adapter.addFragment(new Motorcycles(), "Motorcycles");
            adapter.addFragment(new Other(), "Other");
        }
        viewPager.setAdapter(adapter);
    }

}