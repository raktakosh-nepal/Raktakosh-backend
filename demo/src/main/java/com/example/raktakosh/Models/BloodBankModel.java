package com.example.raktakosh.Models;

public class BloodBankModel {
    public float latitude;
    public float longitude;
    public String Name;
    public String id; // It is the combination of lat, long and name
    public int contactNumber;

    public BloodBankModel() {
    }

    public BloodBankModel(float latitude, float longitude, String name, String id, int contactNumber) {
        this.latitude = latitude;
        this.longitude = longitude;
        Name = name;
        this.id = id;
        this.contactNumber = contactNumber;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }
}
