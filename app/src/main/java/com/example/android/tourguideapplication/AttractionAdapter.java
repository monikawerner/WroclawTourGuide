package com.example.android.tourguideapplication;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AttractionAdapter extends ArrayAdapter<Attraction> {
    /**
     * @param context     The current context. Used to inflate the layout file.
     * @param attractions A List of number objects to display in a list
     */
    public AttractionAdapter(Activity context, ArrayList<Attraction> attractions) {
        super(context, 0, attractions);
    }

    /** Provides a view for an AdapterView
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }
        /** Get the object located at this position in the list */
        Attraction currentWord = getItem(position);

        /** Find the TextView in the list_item.xml layout with the ID name_text_view */
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        /** Get the name from the current Attraction object and set this text on the name TextView */
        nameTextView.setText(currentWord.getAttractionName());

        /** Find the ImageView in the list_item.xml layout with the ID image */
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        /** Get the image resource Id from the current Attraction object and set this image resource on the image ImageView */
        image.setImageResource(currentWord.getImageResourceId());

        /** Find the TextView in the list_item.xml layout with the ID contact_text_view */
        TextView contactTextView = (TextView) listItemView.findViewById(R.id.contact_text_view);
        /** Get the contact information from the current Attraction object and set this text on the contact TextView */
        contactTextView.setText(currentWord.getAttractionContact());

        /** Find the TextView in the list_item.xml layout with the ID description_text_view */
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        /** Get the description from the current Attraction object and set this text on the description TextView */
        descriptionTextView.setText(currentWord.getAttractionDescription());

        return listItemView;
    }
}
