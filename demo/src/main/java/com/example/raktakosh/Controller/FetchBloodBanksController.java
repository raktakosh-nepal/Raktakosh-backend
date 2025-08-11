package com.example.raktakosh.Controller;

import com.example.raktakosh.Models.BloodBankModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class FetchBloodBanksController {
    ArrayList<BloodBankModel> data=new ArrayList<>();

    @GetMapping("/getBloodBanks/{type}/{latitude}/{longitude}")
    public ResponseEntity<ArrayList<BloodBankModel>> getBloodBanks(@PathVariable String type, @PathVariable float latitude, @PathVariable float longitude) {
        data.add(new BloodBankModel(1.0f, 1.0f, "Prerit Rakta Seva", "xyz", 100));
        return ResponseEntity.status(HttpStatus.OK).body(data);

    }
    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }
}
