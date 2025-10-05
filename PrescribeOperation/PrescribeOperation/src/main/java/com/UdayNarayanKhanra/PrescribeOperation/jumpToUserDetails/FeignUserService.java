package com.UdayNarayanKhanra.PrescribeOperation.jumpToUserDetails;


import com.UdayNarayanKhanra.PrescribeOperation.userDetailsLayer.userdetails;
import jakarta.servlet.http.HttpSession;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("LogInSecurity")
public interface FeignUserService {
//    @GetMapping("findUser")
//    public userdetails findingUser(@RequestParam("userdata") String username);


    @GetMapping("l")
    public userdetails ll(@RequestParam("userdata") String username);
}
