package com.UdayNarayanKhanra.PrescribeOperation.prescriptionRealTimeService;

import com.UdayNarayanKhanra.PrescribeOperation.PrescriptionMaking.prescription;
import com.UdayNarayanKhanra.PrescribeOperation.prescriptionRepo.prescriptionRepo;
import org.springframework.stereotype.Service;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PrescriptionRealTimeService {

    @Autowired
    private prescriptionRepo prescriptionRepository;

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final int TIME_RANGE_SECONDS = 120; // 2 minutes in seconds


    @Scheduled(fixedRate = 10000) // 1000 milliseconds = 10 second
    public void checkPrescriptionTimes() {
        LocalTime currentTime = LocalTime.now().withNano(0);
        LocalDate currentDate = LocalDate.now();

        List<prescription> prescriptionsList=prescriptionRepository.findMatchingPrescription(currentTime,currentDate);




//        List<prescription> matchingPrescriptions = prescriptionRepository
//                .findActivePrescriptionsByTimeWithinTwoMinutes(currentTime, currentDate);
//
//        // Process all prescriptions first
//        if (matchingPrescriptions.isEmpty()) {
//            System.out.println("No prescriptions found");
//        } else {
//            for (prescription p : matchingPrescriptions) {
//                System.out.println(p.getMedicineName());
//            }
//            // Clear the list after processing
//            matchingPrescriptions.clear();
//            System.out.println("All prescriptions processed - no more data");
//        }



    }





}