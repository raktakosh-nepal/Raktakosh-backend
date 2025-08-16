package com.example.raktakosh.Models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.*;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Entity
public class BloodBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bloodbankid")
    private Integer bloodBankId;
    private double latitude;
    private double longitude;
    private String imageName;
    private String imageType;
    private byte[] iamgeData;
    private String address;
    private String contact;



    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getIamgeData() {
        return iamgeData;
    }

    public void setIamgeData(byte[] iamgeData) {
        this.iamgeData = iamgeData;
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

    public Integer getBloodBankId() {
        return bloodBankId;
    }

    public void setBloodBankId(Integer bloodBankId) {
        this.bloodBankId = bloodBankId;
    }

    public BloodBank(Integer bloodBankId, double latitude, double longitude, String imageName, String imageType, byte[] iamgeData, String address, String contact) {
        this.bloodBankId = bloodBankId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageName = imageName;
        this.imageType = imageType;
        this.iamgeData = iamgeData;
        this.address = address;
        this.contact = contact;
    }

    public BloodBank() {
    }
}
