package com.UdayNarayanKhanra.PrescribeOperation;

import com.UdayNarayanKhanra.PrescribeOperation.PrescriptionMaking.prescription;
import com.UdayNarayanKhanra.PrescribeOperation.myOwnArraylistDS.customArrayList;
import com.UdayNarayanKhanra.PrescribeOperation.prescriptionRepo.prescriptionRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class prescriptionService {
    @Autowired
    prescriptionRepo repo;
    @Autowired
    HttpSession session;
    public String addPrescription(List<prescription> pres) {

       String email= (String)session.getAttribute("email");
        String username=(String)session.getAttribute("username");
        for(prescription p:pres){
            p.setEmail(email);
            p.setUsername(username);
        }
repo.saveAll(pres);
//        customArrayList crl=new customArrayList();
//        for(prescription p:pres){
//            System.out.println(crl.add(p));
//        }


        return "Your Request Successfully Saved";
    }





}
