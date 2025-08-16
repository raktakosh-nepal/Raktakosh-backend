package com.example.raktakosh.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Blood {
    @Id
    @Column(name="bloodtype")
    private String type;

    public Blood(String type) {
        this.type = type;
    }

    public Blood() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
