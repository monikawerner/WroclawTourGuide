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


public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        /** Create a list of attractions */
        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(getString(R.string.szajnochy), R.drawable.szajnochy, getString(R.string.szajnochy_contact), getString(R.string.szajnochy_description)));
        attractions.add(new Attraction(getString(R.string.vega), R.drawable.vega, getString(R.string.vega_contact), getString(R.string.vega_description)));
        attractions.add(new Attraction(getString(R.string.spiz), R.drawable.spiz, getString(R.string.spiz_contact), getString(R.string.spiz_description)));
        attractions.add(new Attraction(getString(R.string.novocaina), R.drawable.novocaina, getString(R.string.novocaina_contact), getString(R.string.novocaina_description)));
        attractions.add(new Attraction(getString(R.string.jadka), R.drawable.jadka, getString(R.string.jadka_contact), getString(R.string.jadka_description)));
        attractions.add(new Attraction(getString(R.string.szynkarnia), R.drawable.szynkarnia, getString(R.string.szynkarnia_contact), getString(R.string.szynkarnia_description)));


        /** Create an AttractionAdapter, whose data source is a list of Attractions */
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions);
        /** Find the ListView object in the view hierarchy of the Activity */
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        /** Set the adapter on the ListView */
        listView.setAdapter(adapter);

        /** Set onItemClickListener on ListView and get some data to send them to another activity */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
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
