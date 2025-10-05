package com.udaynarayan.LogInSecurity.userDetailsQueueList;

import com.udaynarayan.LogInSecurity.mailOtpTable.mailOtpRepo;
import com.udaynarayan.LogInSecurity.usertable.userDetailsRepo;
import com.udaynarayan.LogInSecurity.usertable.userdetails;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class UserDetailsQueue {

    @Autowired
    userDetailsRepo repouser;

    @Autowired
    mailOtpRepo otpRepo;

    private final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    private  List<userdetails> users=new ArrayList<>();

    public void addUserIntoList(userdetails user){
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword()+"Request Is Ready... If Otp Verified Then Store The Request");
        users.add(user);

    }


    @Scheduled(fixedRate = 6000)
    @Transactional
    public void RegisterSuccessFull(){
       List<String> mailAddresses= otpRepo.gettingVerifiedMail(1);

        Set<String> verifiedEmails = new HashSet<>(mailAddresses);

        // Find users from ArrayList with verified emails
        List<userdetails> usersToSave = new ArrayList<>();

        for (userdetails user : users) {
            if (verifiedEmails.contains(user.getEmail())) {
                usersToSave.add(user);
            }
        }

        // Batch save to database
        if (!usersToSave.isEmpty()) {
            repouser.saveAll(usersToSave);
            System.out.println("Saved " + usersToSave.size() + " users successfully");

            // Optional: Remove saved users from ArrayList to avoid resaving
            users.removeAll(usersToSave);
            if(users==null){
                System.out.println("The Request Queue Is Empty... Waiting For New Requests");
            }
        }
    }

}





