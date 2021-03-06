package com.mobileappdev.teamone.meetup;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.mobileappdev.teamone.meetup.EventListContent.EventListItem;
import com.mobileappdev.teamone.meetup.dummy.DummyContent;

public class MainActivity extends AppCompatActivity
        implements
        EventsListFragment.OnListFragmentInteractionListener,
        ChatsListFragment.OnListFragmentInteractionListener,
        MapFragment.OnFragmentInteractionListener {

    private TextView mTextMessage;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private EventsListFragment eventsListFragment;
    private ChatsListFragment chatsListFragment;
    private MapFragment mapFragment;
    private com.google.android.gms.maps.SupportMapFragment mMapFragment;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_events:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentWindow, eventsListFragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_map:
                    /*fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentWindow, mapFragment);
                    fragmentTransaction.commit();*/
                    mMapFragment = com.google.android.gms.maps.SupportMapFragment.newInstance();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.fragmentWindow, mMapFragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_chats:
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentWindow, chatsListFragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventsListFragment = new EventsListFragment();
        chatsListFragment = new ChatsListFragment();
        mapFragment = new MapFragment();

        fragmentManager = getSupportFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentWindow, eventsListFragment);
        fragmentTransaction.commit();



        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onListFragmentInteraction(EventListItem item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
