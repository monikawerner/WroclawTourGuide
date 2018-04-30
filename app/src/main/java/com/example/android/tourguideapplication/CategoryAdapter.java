package com.example.android.tourguideapplication;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {


    /** Context of the app */
    private Context mContext;


    public CategoryAdapter (Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TopAttractionsFragment();
        } else if (position == 1){
            return new MonumentsFragment();
        } else if (position == 2){
            return new PublicPlacesFragment();
        } else if (position == 3){
            return new AttractionsForKidsFragment();
        } else {
            return new RestaurantsFragment();

        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        if (position == 0) {
            return mContext.getString(R.string.category_top_attractions);
        } else if (position == 1) {
            return mContext.getString(R.string.category_monuments);
        } else if (position == 2) {
            return mContext.getString(R.string.category_public_places);
        } else if (position == 3){
            return mContext.getString(R.string.category_attractions_for_kids);
        } else {
            return mContext.getString(R.string.category_restaurants);
        }
    }
}


