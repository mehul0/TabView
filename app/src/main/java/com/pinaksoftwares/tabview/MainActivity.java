package com.pinaksoftwares.tabview;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    ViewPager viewPager = null;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        /* Set tab titles */
        /*tabLayout.addTab(tabLayout.newTab().setText("first"));
        tabLayout.addTab(tabLayout.newTab().setText("second"));
        tabLayout.addTab(tabLayout.newTab().setText("third"));
        */

        ViewpagerAadapters adapter = new ViewpagerAadapters(getSupportFragmentManager(), tabLayout.getTabCount());

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(adapter);
        //FragmentManager manager = getSupportFragmentManager();
        //viewPager.setAdapter(new ViewpagerAadapters(manager));
        tabLayout.addOnTabSelectedListener(this);

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}

class ViewpagerAadapter extends FragmentPagerAdapter {

    int tabCount;
    Context context;

    public ViewpagerAadapter(FragmentManager fm) {
        super(fm);
    }

    public ViewpagerAadapter(FragmentManager fm, int tabCount) {
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
            fragment = new FragmentC();
        }
        else if (position == 2){
            fragment = new FragmentB();
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
                return "SECTION 1";
            case 1:
                return "SECTION 2";
            case 2:
                return "SECTION 3";
        }
        return null;
    }
}
