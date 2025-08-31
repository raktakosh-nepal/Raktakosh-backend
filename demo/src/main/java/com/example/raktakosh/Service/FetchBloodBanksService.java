package com.example.raktakosh.Service;

import com.example.raktakosh.Models.Blood;
import com.example.raktakosh.Models.BloodAndBloodBank;
import com.example.raktakosh.Models.BloodBank;
import com.example.raktakosh.Models.BloodBankWithQuantity;
import com.example.raktakosh.Repository.BloodAndBloodBankRepo;
import com.example.raktakosh.Repository.BloodBankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FetchBloodBanksService {

    @Autowired
    BloodAndBloodBankRepo bloodAndBloodBankRepo;
    @Autowired
    private BloodBankRepo bloodBankRepo;

    public List<BloodBankWithQuantity> getBloodBanks(double latitude, double longitude, String type) {
        return bloodAndBloodBankRepo.findNearestBloodBanksWithQuantityArray(latitude, longitude, type)
                .stream()
                .map(row -> new BloodBankWithQuantity(
                        (Integer) row[0],                    // bloodBankId
                        (String) row[1],                     // name
                        (Double) row[2],                     // latitude
                        (Double) row[3],                     // longitude
                        (String) row[4],                     // imageUrl
                        (String) row[5],                     // address
                        (String) row[6],                     // contact
                        type,                                // type
                        ((Number) row[7]).doubleValue()      // quantity (converting int to double)
                ))
                .collect(Collectors.toList());
    }

    public BloodBank addBank(BloodBank bank) {
        return bloodBankRepo.save(bank);
    }

//    public List<BloodBank> getBloodBanks(double latitude, double longitude, String type) {
//    }
}