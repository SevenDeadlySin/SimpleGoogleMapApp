package com.example.raksa.googlemapapp;

/**
 * Created by Raksa on 5/15/2017.
 */

public class BrownCenter {


    String name;
    String address;
    String contactNumber;
    double latitude;
    double longitude;



    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getContactNumber(){
        return contactNumber;
    }



    public BrownCenter(String name, String address, String contactNumber, double latitude, double longitude) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.latitude = latitude;
        this.longitude = longitude;
    }


}
