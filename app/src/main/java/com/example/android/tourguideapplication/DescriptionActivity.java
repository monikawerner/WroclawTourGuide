package com.example.android.tourguideapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DescriptionActivity extends AppCompatActivity {

    String attractionNameDescription;
    int attractionImageDescription;
    String attractionContactDescription;
    String attractionDescriptionDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        attractionNameDescription = getIntent().getStringExtra("CLICKED_ITEM_NAME");
        attractionImageDescription = getIntent().getIntExtra("CLICKED_ITEM_IMAGE", R.drawable.market_square);
        attractionContactDescription = getIntent().getStringExtra("CLICKED_ITEM_CONTACT");
        attractionDescriptionDescription = getIntent().getStringExtra("CLICKED_ITEM_DESCRIPTION");

        TextView attractionName = findViewById(R.id.attraction_name);
        attractionName.setText(attractionNameDescription);
        ImageView attractionImage = findViewById(R.id.attraction_image);
        attractionImage.setImageResource(attractionImageDescription);
        TextView attractionContact = findViewById(R.id.attraction_contact);
        attractionContact.setText(attractionContactDescription);
        TextView attractionDescription = findViewById(R.id.attraction_description);
        attractionDescription.setText(attractionDescriptionDescription);

    }
}
