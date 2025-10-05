package com.udaynarayan.LogInSecurity;

import com.udaynarayan.LogInSecurity.usertable.userDetailsRepo;
import com.udaynarayan.LogInSecurity.usertable.userdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class anotherService {

    @Autowired
    userDetailsRepo repo;

    public userdetails gettingUserDetails(String username) {
        return repo.findUserDetails(username);
    }
}
