package com.apavayan.motion;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.RecyclerView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public void xda_s3neo (View view){
        goToUrl ("http://forum.xda-developers.com/galaxy-s3-neo/development/rom-motion-rom-ll-t3294595");
    }

    public void xda_grand2 (View view){
        goToUrl("http://forum.xda-developers.com/galaxy-grand-2/development/rom-motion-rom-ll-t3295055");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Coming Sooner", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private RecyclerView mRecyclerView;
        private RecyclerView.Adapter mAdapter;
        private CardView mCardview;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            Bundle bundle = getArguments();
            int position = bundle.getInt(ARG_SECTION_NUMBER);


            switch (position) {
                case 1:
                    mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv);
                    mAdapter = new infoAdapter();
                    mRecyclerView.setAdapter(mAdapter);
                    break;
                case 2:
                    mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv);
                    mAdapter = new DeveloperAdapter();
                    mRecyclerView.setAdapter(mAdapter);
                    break;
                case 3:
                    mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv);
                    /*
                    mCardview = (CardView) rootView.findViewById(R.id.update_box);
                    TextView latest = (TextView)rootView.findViewById(R.id.latest_version_no);
                    TextView current = (TextView)rootView.findViewById(R.id.current_verison_no);
                    String latest_version = getResources().getString(R.string.app_name);
                    String current_version = getversion();
                    latest.setText(latest_version);
                    if(latest_version.equals(current_version)) {
                        current.setText(current_version);
                        current.setTextColor(getResources().getColor(R.color.green));
                    } else {
                        current.setText(current_version);
                        current.setTextColor(getResources().getColor(R.color.red));
                    }
                    Button page = (Button)rootView.findViewById(R.id.download_button);
                    page.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    goToUrl("http://google.com/");
                                }
                            }
                    );
                    */
                    break;
                case 4:
                    mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv);
                    mAdapter = new ChangelogAdapter();
                    mRecyclerView.setAdapter(mAdapter);
                    break;
                case 5:
                    mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv);
                    mAdapter = new OtherAdapter();
                    mRecyclerView.setAdapter(mAdapter);
                    break;
            }
            
            // HERE YOU SET THE RECYCLER VIEW
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            // To Optimize the RecyclerView
            mRecyclerView.setHasFixedSize(true);

            return rootView;
        }
        String getversion(){
            SystemProperty prop = new SystemProperty(getActivity());
            String version = prop.get("ro.motion.version");;
            return version;
        }
        private void goToUrl (String url) {
            Uri uriUrl = Uri.parse(url);
            Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
            startActivity(launchBrowser);
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Info";
                case 1:
                    return "Developers";
                case 2:
                    return "Update";
                case 3:
                    return "Change Logs";
                case 4:
                    return "Other";
            }
            return null;
        }
    }
}
