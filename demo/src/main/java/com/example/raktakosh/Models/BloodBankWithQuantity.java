package com.example.raktakosh.Models;

public class BloodBankWithQuantity {
    private Integer bloodBankId;
    private String name;
    private double latitude;
    private double longitude;
    private String imageUrl;
    private String address;
    private String contact;
    private String type;
    private double quantity;

    public Integer getBloodBankId() {
        return bloodBankId;
    }

    public void setBloodBankId(Integer bloodBankId) {
        this.bloodBankId = bloodBankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public BloodBankWithQuantity(Integer bloodBankId, String name, double latitude, double longitude, String imageUrl, String address, String contact, String type, double quantity) {
        this.bloodBankId = bloodBankId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageUrl = imageUrl;
        this.address = address;
        this.contact = contact;
        this.type = type;
        this.quantity = quantity;
    }

    public BloodBankWithQuantity() {
    }
}
