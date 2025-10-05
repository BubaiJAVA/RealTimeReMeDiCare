package com.UdayNarayanKhanra.PrescribeOperation.prescriptionRepo;

import com.UdayNarayanKhanra.PrescribeOperation.PrescriptionMaking.prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface prescriptionRepo extends JpaRepository<prescription,Integer> {





//    @Query("SELECT p FROM prescription p WHERE " +
//            "FUNCTION('TIMEDIFF', p.time, :currentTime) BETWEEN -120 AND 120 " +
//            "AND p.expirydate >= :currentDate")
//    List<prescription> findActivePrescriptionsByTimeWithinTwoMinutes(
//            @Param("currentTime") LocalTime currentTime,
//            @Param("currentDate") LocalDate currentDate);

@Query("SELECT p FROM prescription p WHERE p.time>")
    List<prescription> findMatchingPrescription(LocalTime currentTime, LocalDate currentDate);
}
