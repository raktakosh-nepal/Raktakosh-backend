package com.example.raktakosh.Repository;

import com.example.raktakosh.Models.BloodBank;
import com.example.raktakosh.Models.BloodAndBloodBank;
import com.example.raktakosh.Models.BloodBankWithQuantity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
@Repository
public interface BloodAndBloodBankRepo extends JpaRepository<BloodAndBloodBank, Object> {

    @Query(value = "SELECT bb.blood_bank_id, bb.name, bb.latitude, bb.longitude, " +
            "bb.image_url, bb.address, bb.contact, babb.quantity " +
            "FROM blood_bank bb " +
            "JOIN blood_and_blood_bank babb ON bb.blood_bank_id = babb.bloodbankid " +
            "JOIN blood b ON babb.bloodtype = b.bloodtype " +
            "WHERE b.bloodtype = :bloodType " +
            "AND babb.quantity >= 1 " +
            "ORDER BY (6371 * acos(greatest(-1, least(1, " +
            "cos(radians(:lat)) * cos(radians(bb.latitude)) * " +
            "cos(radians(bb.longitude) - radians(:lon)) + " +
            "sin(radians(:lat)) * sin(radians(bb.latitude)))))) ASC " +
            "LIMIT 20", nativeQuery = true)
    List<Object[]> findNearestBloodBanksWithQuantityArray(@Param("lat") double latitude,
                                                          @Param("lon") double longitude,
                                                          @Param("bloodType") String bloodType);

    // Debug method 1: Check if junction table has any data
    @Query(value = "SELECT COUNT(*) FROM blood_and_blood_bank", nativeQuery = true)
    Long countJunctionTableRecords();

    // Debug method 2: See what's actually in the junction table
    @Query(value = "SELECT * FROM blood_and_blood_bank LIMIT 10", nativeQuery = true)
    List<Object[]> getJunctionTableData();

    // Debug method 3: Check what blood types exist in junction table
    @Query(value = "SELECT DISTINCT bloodtype FROM blood_and_blood_bank", nativeQuery = true)
    List<String> getAvailableBloodTypes();

    // Debug method 4: Test basic join without filters
    @Query(value = "SELECT bb.* FROM blood_bank bb " +
            "JOIN blood_and_blood_bank babb ON bb.blood_bank_id = babb.bloodbankid " +
            "LIMIT 5", nativeQuery = true)
    List<BloodBank> testBasicJoin();

}