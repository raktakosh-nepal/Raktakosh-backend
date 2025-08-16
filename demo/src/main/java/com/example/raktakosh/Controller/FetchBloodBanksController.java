package com.example.raktakosh.Controller;


import com.example.raktakosh.Models.Blood;
import com.example.raktakosh.Models.BloodBank;
import com.example.raktakosh.Service.FetchBloodBanksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FetchBloodBanksController {
    @Autowired
    FetchBloodBanksService fetchBloodBanksService;


    @GetMapping("/getbloodbanks/{latitude}/{longitude}/{type}")
    public List<BloodBank> getBloodBanks(@PathVariable double latitude, @PathVariable double longitude, @PathVariable String type) {
        return fetchBloodBanksService.getBloodBanks(latitude, longitude, type);
    }

    @PostMapping("/addBank")
    public BloodBank addBank(@RequestBody BloodBank bank) {
        return fetchBloodBanksService.addBank(bank);
    }
}
