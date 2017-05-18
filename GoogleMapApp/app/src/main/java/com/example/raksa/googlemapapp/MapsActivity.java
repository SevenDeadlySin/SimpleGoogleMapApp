package com.example.raksa.googlemapapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    double locationLatitude;
    double locationLongitude;
    String locationName;

    FloatingActionButton floatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps);

        Intent receiverDataIntent = getIntent();

        locationLatitude = receiverDataIntent.getDoubleExtra(ConstantKey.LATITUDE_KEY,0);
        locationLongitude = receiverDataIntent.getDoubleExtra(ConstantKey.LONGITUDE_KEY,0);
        locationName = receiverDataIntent.getStringExtra(ConstantKey.LOCATION_NAME_KEY);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        floatButton = (FloatingActionButton) findViewById(R.id.fab);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMap!=null){
                    LatLng location = new LatLng(locationLatitude, locationLongitude);
                    mMap.addMarker(new MarkerOptions().position(location).title("Marker at "+locationName));
                    float currentZoomLevel = mMap.getCameraPosition().zoom;
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,currentZoomLevel));
                }
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker and move the camera
        LatLng location = new LatLng(locationLatitude, locationLongitude);
        mMap.addMarker(new MarkerOptions().position(location).title(locationName));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,17));
    }
}
