package com.example.raktakosh.Repository;

import com.example.raktakosh.Models.BloodAndBloodBank;
import com.example.raktakosh.Models.BloodAndBloodBankId;
import com.example.raktakosh.Models.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BloodAndBloodBankRepo extends JpaRepository<BloodAndBloodBank, BloodAndBloodBankId> {
    @Query(value = "SELECT bb.* FROM blood_bank bb " +
            "JOIN blood_bank_and_blood bbb ON bb.blood_bank_id = bbb.id_blood_bank " +
            "WHERE bbb.type = :type AND bbb.quantity > 1 " +
            "ORDER BY (6371 * acos(cos(radians(:lat)) * cos(radians(bb.latitude)) * cos(radians(bb.longitude) - radians(:lon)) + sin(radians(:lat)) * sin(radians(bb.latitude)))) ASC " +
            "LIMIT 20",
            nativeQuery = true)
    List<BloodBank> findNearestBloodBanks(@Param("lat") double latitude,
                                          @Param("lon") double longitude,
                                          @Param("type") String bloodType);
}
