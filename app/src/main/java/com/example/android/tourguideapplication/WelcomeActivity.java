package com.example.android.tourguideapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        /** Set OnClickListener on the TextView to start another activity */
        TextView start = (TextView) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent attractionsIntent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(attractionsIntent);
            }
        });

        /** Set OnClickListener on the ImageView to start another activity */
        ImageView plane = (ImageView) findViewById(R.id.plane);
        plane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent attractionsIntent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(attractionsIntent);
            }
        });
    }
}
