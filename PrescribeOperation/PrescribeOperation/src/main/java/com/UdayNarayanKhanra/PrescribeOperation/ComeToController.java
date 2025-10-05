package com.UdayNarayanKhanra.PrescribeOperation;

import com.UdayNarayanKhanra.PrescribeOperation.PrescriptionMaking.prescription;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComeToController {
    @Autowired
    prescriptionService service;
    @RequestMapping("/")

    public String homePage(){
        return "Hello Alien... Welcome To Home Page";
    }

    @GetMapping("About")
    public String AboutPage(){
        return "THis Is About Page";
    }

    @GetMapping("emni")
    public String emni(HttpSession session){
        String mail=(String) session.getAttribute("email");
        String username=(String) session.getAttribute("username");
        String mailUser=mail+username;
        return mailUser;
    }

    @PostMapping("AddPrescription")
    public String addprescription(@RequestBody List<prescription> pres){
        String s= service.addPrescription(pres);

        return s;
    }


}
