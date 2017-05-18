package com.example.raksa.googlemapapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textViewName , textViewAddress , textViewContactNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewAddress = (TextView) findViewById(R.id.textViewAddress);
        textViewContactNumber = (TextView) findViewById(R.id.textViewContactNumber);

        final BrownCenter brownCenter = new BrownCenter("Brown Aeon Super Market","#17,St.214(Near Pencil Super Market and ICS)","+855 696 970 79",11.547626,104.934540);

        textViewName.setText(brownCenter.getName());
        textViewAddress.setText(brownCenter.getAddress());
        textViewContactNumber.setText(brownCenter.getContactNumber());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMapActivityIntent = new Intent(MainActivity.this,MapsActivity.class);
                goToMapActivityIntent.putExtra(ConstantKey.LATITUDE_KEY, brownCenter.getLatitude());
                goToMapActivityIntent.putExtra(ConstantKey.LONGITUDE_KEY, brownCenter.getLongitude());
                goToMapActivityIntent.putExtra(ConstantKey.LOCATION_NAME_KEY, brownCenter.getName());
                startActivity(goToMapActivityIntent);
            }
        });



    }
}
