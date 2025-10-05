package com.udaynarayan.LogInSecurity.SecureConfig;

import com.udaynarayan.LogInSecurity.usertable.userDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class myUserDetailsService implements UserDetailsService {
    @Autowired
    userDetailsRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        return null;

    }
}
