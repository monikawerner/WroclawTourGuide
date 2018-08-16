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

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class TopAttractionsFragment extends Fragment {


    public TopAttractionsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        /** Create a list of attractions */
        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(getString(R.string.market_square), R.drawable.market_square, getString(R.string.market_square_contact), getString(R.string.market_square_description)));
        attractions.add(new Attraction(getString(R.string.ostrow_tumski), R.drawable.ostrow_tumski, getString(R.string.ostrow_tumski_contact), getString(R.string.ostrow_tumski_description)));
        attractions.add(new Attraction(getString(R.string.zoo), R.drawable.zoo, getString(R.string.zoo_contact), getString(R.string.zoo_description)));
        attractions.add(new Attraction(getString(R.string.centennial_hall), R.drawable.centennial_hall, getString(R.string.centennial_hall_contact), getString(R.string.centennial_hall_description)));
        attractions.add(new Attraction(getString(R.string.fountain), R.drawable.multimedia_fountain, getString(R.string.fountain_contact), getString(R.string.fountain_description)));


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
