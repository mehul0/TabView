package com.pinaksoftwares.tabview;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Toast;


class ViewpagerAadapters extends FragmentStatePagerAdapter {

    int tabCount;
    Context context;

    public ViewpagerAadapters(FragmentManager fm) {
        super(fm);
    }

    public ViewpagerAadapters(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        if (position == 0){
            fragment = new FragmentA();
        }
        else if (position == 1){
            fragment = new FragmentB();
        }
        else if (position == 2){
            fragment = new FragmentC();
        }
        else{
            Toast.makeText(context, "Fragment not attached", Toast.LENGTH_SHORT).show();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "TAB 1";
            case 1:
                return "TAB 2";
            case 2:
                return "TAB 3";
        }
        return null;
    }

}
