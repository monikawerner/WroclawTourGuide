package com.example.android.tourguideapplication;


import android.app.Activity;
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


public class AttractionsForKidsFragment extends Fragment {

    public AttractionsForKidsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        /** Create a list of attractions */
        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(getString(R.string.wax_museum), R.drawable.wax_museum, getString(R.string.wax_museum_contact), getString(R.string.wax_museum_description)));
        attractions.add(new Attraction(getString(R.string.trams), R.drawable.trams, getString(R.string.trams_contact), getString(R.string.trams_description)));
        attractions.add(new Attraction(getString(R.string.carousel), R.drawable.carousel, getString(R.string.carousel_contact), getString(R.string.carousel_description)));
        attractions.add(new Attraction(getString(R.string.jump_world), R.drawable.jump_world, getString(R.string.jump_world_contact), getString(R.string.jump_world_description)));
        attractions.add(new Attraction(getString(R.string.polinka), R.drawable.polinka, getString(R.string.polinka_contact), getString(R.string.polinka_description)));
        attractions.add(new Attraction(getString(R.string.kolejkowo), R.drawable.kolejkowo, getString(R.string.kolejkowo_contact), getString(R.string.kolejkowo_description)));
        attractions.add(new Attraction(getString(R.string.hydropolis), R.drawable.hydropolis, getString(R.string.hydropolis_contact), getString(R.string.hydropolis_description)));
        attractions.add(new Attraction(getString(R.string.zoo), R.drawable.zoo, getString(R.string.zoo_contact), getString(R.string.zoo_description)));
        attractions.add(new Attraction(getString(R.string.aquapark), R.drawable.aquapark, getString(R.string.aquapark_contact), getString(R.string.aquapark_description)));

        /** Create an AttractionAdapter, whose data source is a list of Attractions */
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions);
        /** Find the ListView object in the view hierarchy of the Activity */
        ListView listView = (ListView) rootView.findViewById(R.id.list);
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
