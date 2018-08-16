package com.example.android.tourguideapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MonumentsFragment extends Fragment {

    public MonumentsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        /** Create a list of attractions */
        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(getString(R.string.four_denominations_district), R.drawable.four_denominations_district, getString(R.string.four_denominations_district_contact), getString(R.string.four_denominations_district_description)));
        attractions.add(new Attraction(getString(R.string.cathedral), R.drawable.cathedral, getString(R.string.cathedral_contact), getString(R.string.cathedral_description)));
        attractions.add(new Attraction(getString(R.string.market_hall), R.drawable.market_hall, getString(R.string.market_hall_contact), getString(R.string.market_hall_description)));
        attractions.add(new Attraction(getString(R.string.four_domes_pavilion), R.drawable.four_domes_pavillion, getString(R.string.four_domes_pavilion_contact), getString(R.string.four_domes_pavilion_description)));
        attractions.add(new Attraction(getString(R.string.synagogue), R.drawable.synagogue, getString(R.string.synagogue_contact), getString(R.string.synagogue_description)));
        attractions.add(new Attraction(getString(R.string.centennial_hall), R.drawable.centennial_hall, getString(R.string.centennial_hall_contact), getString(R.string.centennial_hall_description)));
        attractions.add(new Attraction(getString(R.string.panorama), R.drawable.panorama, getString(R.string.panorama_contact), getString(R.string.panorama_description)));
        attractions.add(new Attraction(getString(R.string.national_museum), R.drawable.national_museum, getString(R.string.national_museum_contact), getString(R.string.national_museum_description)));
        attractions.add(new Attraction(getString(R.string.old_town_hall), R.drawable.old_town_hall, getString(R.string.old_town_hall_contact), getString(R.string.old_town_hall_description)));
        attractions.add(new Attraction(getString(R.string.market_square), R.drawable.market_square, getString(R.string.market_square_contact), getString(R.string.market_square_description)));
        attractions.add(new Attraction(getString(R.string.ossolineum), R.drawable.ossolineum, getString(R.string.ossolineum_contact), getString(R.string.ossolineum_description)));

        /** Create an AttractionAdapter, whose data source is a list of Attractions */
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions);
        /** Find the ListView object in the view hierarchy of the Activity */
        ListView listView = rootView.findViewById(R.id.list);
        /** Set the adapter on the ListView */
        listView.setAdapter(adapter);

        /** Set onItemClickListener on ListView and get some data to send them to another activity */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent descriptionIntent = new Intent(getActivity(), DescriptionActivity.class);
                String attractionName = attractions.get(position).getAttractionName();
                String attractionContact = attractions.get(position).getAttractionContact();
                int attractionImage = attractions.get(position).getImageResourceId();
                String attractionDescription = attractions.get(position).getAttractionDescription();
                descriptionIntent.putExtra("CLICKED_ITEM_NAME", attractionName);
                descriptionIntent.putExtra("CLICKED_ITEM_CONTACT", attractionContact);
                descriptionIntent.putExtra("CLICKED_ITEM_IMAGE", attractionImage);
                descriptionIntent.putExtra("CLICKED_ITEM_DESCRIPTION", attractionDescription);
                startActivity(descriptionIntent);

            }

        });

        return rootView;
    }
}
