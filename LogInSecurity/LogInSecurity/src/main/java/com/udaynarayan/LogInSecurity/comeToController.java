package com.udaynarayan.LogInSecurity;

import com.udaynarayan.LogInSecurity.usertable.userdetails;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class comeToController {
    @Autowired
    userService service;
    @Autowired
    anotherService service2;
    @RequestMapping("/")
    public String Home(){
        return "Hello Welcome Alien...";
    }

    @PostMapping("/Register")
    public String Registration(@RequestBody userdetails user){
        String message=service.checkMailOtp(user);
        return message;
    }

    @GetMapping("checkOtp")
    public String checkingOtpValidation(@RequestParam("email")String mail,@RequestParam("otp") int otp){
        String message=service.checkOtpValidOrNot(mail,otp);
        return message;
    }


   @GetMapping("ForgetPassWord")

    public String forgetPassword(@RequestParam("email") String email, HttpSession session){

       session.setAttribute("mail",email);
        return service.forgetPassword(email);

   }

   @PutMapping("setNewPassword")
    public String setupNewPassword(@RequestParam("password") String password,@RequestParam("otpp") int otp, HttpSession session){
        String email=(String)session.getAttribute("mail");
        String message=service.setNewUpdatePassword(email,password,otp);
        System.out.println(email);
        return message;
   }


   @GetMapping("l")
    public userdetails ll(@RequestParam("userdata") String username){
//        session.setAttribute("l","hello");

           return service2.gettingUserDetails(username);
   }

   @GetMapping("ll")
    public void lll(HttpSession session){
       String s=(String) session.getAttribute("l");
       System.out.println(s);
   }

   @GetMapping("findUser")
    public userdetails findingUser(@RequestParam("userdata") String username){
    return service2.gettingUserDetails(username);
   }


}
