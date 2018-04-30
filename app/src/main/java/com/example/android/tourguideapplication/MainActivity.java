package com.example.android.tourguideapplication;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /** Find the view pager that will allow the user to swipe between fragments */
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        /** Create an adapter that knows which fragment should be shown on each page */
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());
        /** Set the adapter onto the view pager */
        viewPager.setAdapter(adapter);
        /** Find the tab layout that shows the tabs */
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        /** Connect the tab layout with the view pager */
        tabLayout.setupWithViewPager(viewPager);

    }
}
