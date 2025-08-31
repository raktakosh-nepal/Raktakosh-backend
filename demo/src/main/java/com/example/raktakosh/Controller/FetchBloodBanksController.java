package com.example.raktakosh.Controller;


import com.example.raktakosh.Models.Blood;
import com.example.raktakosh.Models.BloodBank;
import com.example.raktakosh.Models.BloodBankWithQuantity;
import com.example.raktakosh.Repository.BloodAndBloodBankRepo;
import com.example.raktakosh.Service.FetchBloodBanksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FetchBloodBanksController {
    @Autowired
    FetchBloodBanksService fetchBloodBanksService;
    @Autowired
    BloodAndBloodBankRepo bloodAndBloodBankRepo;

    @GetMapping("/getbloodbanks/{latitude}/{longitude}/{type}")
    public List<BloodBankWithQuantity> getBloodBanks(@PathVariable double latitude, @PathVariable double longitude, @PathVariable String type) {
        return fetchBloodBanksService.getBloodBanks(latitude, longitude, type);
    }

    // Debug endpoints
    @GetMapping("/debug/junction-count")
    public Long getJunctionCount() {
        return bloodAndBloodBankRepo.countJunctionTableRecords();
    }

    @GetMapping("/debug/junction-data")
    public List<Object[]> getJunctionData() {
        return bloodAndBloodBankRepo.getJunctionTableData();
    }

    @GetMapping("/debug/available-types")
    public List<String> getAvailableTypes() {
        return bloodAndBloodBankRepo.getAvailableBloodTypes();
    }

    @GetMapping("/debug/test-join")
    public List<BloodBank> testJoin() {
        return bloodAndBloodBankRepo.testBasicJoin();
    }

    @PostMapping("/addBank")
    public BloodBank addBank(@RequestBody BloodBank bank) {
        return fetchBloodBanksService.addBank(bank);
    }
}