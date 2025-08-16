package com.example.raktakosh.Models;

import jakarta.persistence.*;

import java.util.Objects;

@Embeddable
public class BloodAndBloodBankId {
    @ManyToOne
    @JoinColumn(name="bloodbankid")
    private BloodBank bloodBank;

    @ManyToOne
    @JoinColumn(name="bloodtype")
    private Blood blood;

    public BloodAndBloodBankId() {

    }

    public BloodBank getBloodBank() {
        return bloodBank;
    }

    public void setBloodBank(BloodBank bloodBank) {
        this.bloodBank = bloodBank;
    }

    public Blood getBlood() {
        return blood;
    }

    public void setBlood(Blood blood) {
        this.blood = blood;
    }

    public BloodAndBloodBankId(BloodBank bloodBank) {
        this.bloodBank = bloodBank;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BloodAndBloodBankId that = (BloodAndBloodBankId) o;
        return Objects.equals(bloodBank, that.bloodBank) && Objects.equals(blood, that.blood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bloodBank, blood);
    }
}
