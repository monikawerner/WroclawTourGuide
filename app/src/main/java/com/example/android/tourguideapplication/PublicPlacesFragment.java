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


public class PublicPlacesFragment extends Fragment {


    public PublicPlacesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        /** Create a list of attractions */
        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(getString(R.string.riverfront), R.drawable.riverfront, getString(R.string.riverfront_contact), getString(R.string.riverfront_description)));
        attractions.add(new Attraction(getString(R.string.market_hall), R.drawable.market_hall, getString(R.string.market_hall_contact), getString(R.string.market_hall_description)));
        attractions.add(new Attraction(getString(R.string.zoo), R.drawable.zoo, getString(R.string.zoo_contact), getString(R.string.zoo_description)));
        attractions.add(new Attraction(getString(R.string.aquapark), R.drawable.aquapark, getString(R.string.aquapark_contact), getString(R.string.aquapark_description)));
        attractions.add(new Attraction(getString(R.string.stadium), R.drawable.stadium, getString(R.string.stadium_contact), getString(R.string.stadium_description)));
        attractions.add(new Attraction(getString(R.string.partynice), R.drawable.partynice, getString(R.string.partynice_contact), getString(R.string.partynice_description)));
        attractions.add(new Attraction(getString(R.string.slodowa_island), R.drawable.slodowa_island, getString(R.string.slodowa_island_contact), getString(R.string.slodowa_island_description)));
        attractions.add(new Attraction(getString(R.string.japanese_garden), R.drawable.japanese_garden, getString(R.string.japanese_garden_contact), getString(R.string.japanese_garden_description)));
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
