package com.UdayNarayanKhanra.PrescribeOperation.SecurityConfiguration;

import com.UdayNarayanKhanra.PrescribeOperation.jumpToUserDetails.FeignUserService;
import com.UdayNarayanKhanra.PrescribeOperation.userDetailsLayer.userdetails;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    FeignUserService feignUserService;
    @Autowired
    HttpServletRequest req;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       String userdata=username;
        System.out.println(userdata);

    userdetails user=feignUserService.ll(username);
    if(user==null){
    System.out.println("USERNAME DOES NOT EXIST");
       throw new UsernameNotFoundException("User Not Found");
    }
//    System.out.println(user.getUsername());
//    System.out.println(user.getPassword());
//    System.out.println(user.getEmail());
        UserPrinciple principle=new UserPrinciple(user);
    HttpSession session=req.getSession();
    session.setAttribute("email",user.getEmail());
    session.setAttribute("username",user.getUsername());
        return principle;
    }
}
