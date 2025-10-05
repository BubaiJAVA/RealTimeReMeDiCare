package com.udaynarayan.LogInSecurity;

import com.udaynarayan.LogInSecurity.ForgetPassWordOtp.passwordUpdateRepo;
import com.udaynarayan.LogInSecurity.ForgetPassWordOtp.passwordupdate;
import com.udaynarayan.LogInSecurity.MailService.MailServvice;
import com.udaynarayan.LogInSecurity.mailOtpTable.mailOtpRepo;
import com.udaynarayan.LogInSecurity.mailOtpTable.mailotpcheck;
import com.udaynarayan.LogInSecurity.mailSendingQueue.mailSendingQueue;
import com.udaynarayan.LogInSecurity.userDetailsQueueList.UserDetailsQueue;
import com.udaynarayan.LogInSecurity.usertable.userDetailsRepo;
import com.udaynarayan.LogInSecurity.usertable.userdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class userService {
    @Autowired
    mailOtpRepo checkRepo;
    @Autowired
    MailServvice mailservice;
    @Autowired
    mailSendingQueue queue;
    @Autowired
    UserDetailsQueue userQueue;
    @Autowired
    userDetailsRepo userrepo;
    @Autowired
    passwordUpdateRepo passrepo;
    public String checkMailOtp(userdetails user) {


        String mail=user.getEmail();
        String message="";
        int count=checkRepo.findMailUniqueOrNot(mail);


        if(count==0){
            userQueue.addUserIntoList(user);
            Random random=new Random();
            int x= 100000+random.nextInt(900000);
            mailotpcheck check=new mailotpcheck();
            check.setEmail(user.getEmail());
            check.setOtp(x);
            check.setVerify(0);

            queue.mailAddToQueue(check);

            checkRepo.save(check);
//            int a=mailservice.sendingOtpToMail(check);
//            if(a==1)
//            message="Otp Send to Your Specified Mail Address... Now Verify Your OTP For Regostration Successfull...";
//        else{
//            message="Unsuccessfull to Sending Mail";
//            }

            message="A OTP is Send To Your Mail... Please Verify Your OTP Then You Will Be Registered Otherwise Your Data Will Removed";
        }
        if(count>0){
            message="The Mail Already Exist";
        }
        return message;
    }


    public String checkOtpValidOrNot(String mail, int otp) {
       boolean a= checkRepo.findingOtpValid(mail,otp);
       if(a){
           checkRepo.updateVerifyColumn(mail);
           return "OTP Matched Successfull";
       }
       else {
           return "OTP Does't Match... Please Check Your Mail And Resubmit The OTP";
       }
    }

    public String forgetPassword(String email) {
        boolean a=userrepo.findMailExistOrNot(email);
        if(a){
            Random random=new Random();
            int x= 100000+random.nextInt(900000);
            String mail=email;
             passwordupdate pwUpdate=new passwordupdate();
             pwUpdate.setEmail(mail);
             pwUpdate.setOtp(x);
                     queue.updatePassWordOtpSend(pwUpdate);
            return "A OTP is Sending To Your Mail... Verify The Otp And Set Your Password Agin";
        }
        else{
           return "This Mail Is Not Exist In Our DataBase";
        }
    }

    public String setNewUpdatePassword(String email, String password,int otp) {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
        String password1=encoder.encode(password);
        boolean check=passrepo.checkUpdatePasswordOtp(email,otp);
        String message="";
        if(check){
            int aaa=userrepo.updateUpdatedPassword(email,password1);
            if(aaa>0){
                message="Password Update Successfull";
                System.out.println("password update successfull");
            }
            else {
                message="Something Went Wrong for Password Updating ";
            }



         int deleteStatus=passrepo.deleteVerifiedData(email);
         if(deleteStatus>0){

             System.out.println("Verified Data Successfully Deleted");
         }
         else{
             System.out.println("Something Went Wrong For Deleting Verified Data");
         }




        }
        else{
            message="OTP Not Correct Please Check OTP , Reenter Your Otp";
        }
        return message;
    }
}
