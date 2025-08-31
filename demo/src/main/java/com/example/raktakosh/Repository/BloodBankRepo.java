package com.example.raktakosh.Repository;

import com.example.raktakosh.Models.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BloodBankRepo extends JpaRepository<BloodBank, Integer> {
}
