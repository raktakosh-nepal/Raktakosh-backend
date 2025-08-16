package com.example.raktakosh.Service;

import com.example.raktakosh.Models.BloodAndBloodBank;
import com.example.raktakosh.Models.BloodBank;
import com.example.raktakosh.Repository.BloodAndBloodBankRepo;
import com.example.raktakosh.Repository.BloodBankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class FetchBloodBanksService {

    @Autowired
    BloodAndBloodBankRepo bloodAndBloodBankRepo;


    @Autowired
    private BloodBankRepo bloodBankRepo;

    public List<BloodBank> getBloodBanks(double latitude, double longitude, String type) {
        return bloodAndBloodBankRepo.findNearestBloodBanks(latitude, longitude, type);
    }

    public BloodBank addBank(BloodBank bank) {
        return bloodBankRepo.save(bank);
    }
}
