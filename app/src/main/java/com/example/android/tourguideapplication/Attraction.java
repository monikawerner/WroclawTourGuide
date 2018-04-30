package com.example.android.tourguideapplication;


public class Attraction {

    /** Name of attraction */
    private String mAttractionName;

    /** Image resource Id */
    private int mImageResourceId;

    /** Contact */
    private String mAttractionContact;

    /** Description */
    private String mAttractionDescription;


    /** Create a new Attraction object.
     * @param attractionName        is the name of attraction
     * @param imageResourceId       is the image representing the attraction
     * @param attractionContact     is contact information of the attraction
     * @param attractionDescription is the description of attraction
     */
    public Attraction(String attractionName, int imageResourceId, String attractionContact, String attractionDescription) {
        mAttractionName = attractionName;
        mImageResourceId = imageResourceId;
        mAttractionContact = attractionContact;
        mAttractionDescription = attractionDescription;
    }


    /** Get the name of the attraction */
    public String getAttractionName() {
        return mAttractionName;
    }

    /** Get the Image resource ID */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /** Get the contact info of the attraction */
    public String getAttractionContact() {
        return mAttractionContact;
    }

    /** Get the description of the attraction */
    public String getAttractionDescription() {
        return mAttractionDescription;
    }

}
