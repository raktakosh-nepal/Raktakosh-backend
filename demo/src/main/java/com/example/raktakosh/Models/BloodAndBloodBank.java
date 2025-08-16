package com.example.raktakosh.Models;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class BloodAndBloodBank {
    @EmbeddedId
    private BloodAndBloodBankId bloodAndBloodBankId;
    private int quantity;

    public BloodAndBloodBank(BloodAndBloodBankId bloodAndBloodBankId, int quantity) {
        this.bloodAndBloodBankId = bloodAndBloodBankId;
        this.quantity = quantity;
    }

    public BloodAndBloodBank() {

    }

    public BloodAndBloodBankId getBloodAndBloodBankId() {
        return bloodAndBloodBankId;
    }

    public void setBloodAndBloodBankId(BloodAndBloodBankId bloodAndBloodBankId) {
        this.bloodAndBloodBankId = bloodAndBloodBankId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        BloodAndBloodBank that = (BloodAndBloodBank) o;
        return quantity == that.quantity && Objects.equals(bloodAndBloodBankId, that.bloodAndBloodBankId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bloodAndBloodBankId, quantity);
    }
}