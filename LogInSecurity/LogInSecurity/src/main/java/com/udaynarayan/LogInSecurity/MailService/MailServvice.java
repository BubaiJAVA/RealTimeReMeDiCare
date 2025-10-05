package com.udaynarayan.LogInSecurity.MailService;

import com.udaynarayan.LogInSecurity.mailOtpTable.mailotpcheck;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailServvice {
@Autowired
    private JavaMailSender mailSender;
    @Value("$(spring.mail.username)")
    private String fromMail;
    public void SendingMail(String toMail){
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");


        }
        catch(Exception e){
            throw new RuntimeException("Failed to Send Email", e);
        }
    }

    public int sendingOtpToMail(mailotpcheck check) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            String tomail=check.getEmail();
            int otp=check.getOtp();
            String msg="REMEDICARE";
            String msg1="Technical Helper";
            String actualMessage="<html>"
                    + "<body style='font-family: Arial, sans-serif; text-align: center; margin: 0; padding: 20px;'>"

                    + "<h2 style='color: #333; margin: 0; text-align:center; letter-spacing:3px;'>" + msg + "</h2>"
                    + "<h3 style='color: #333; margin: 0; text-align:center; letter-spacing:3px;'>" + msg1 + "</h3>"
                    + "<p style='font-size: 24px; color: black; font-weight: bold; margin-bottom: 30px;'>"
                    + "Your Generated OTP is: " + otp + "</p>"
                    + "<p style='color: red; text-align: center; font-weight: bold;'>"
                    + "Please Don't Share This OTP with Others"
                    + "</p>"
                    +"<img src='https://img.freepik.com/free-vector/group-medical-staff-carrying-health-related-icons_53876-43071.jpg?semt=ais_hybrid&w=740&q=80' alt='Medical Notification' style='width: 100%; height: 100%; object-fit: cover;'>"
                    + "</body>"
                    + "<p style='color: #3A3333; text-align: center;'>"
                    + "In this technical world, your thoughts and skills are extremely valuable to all of us. That’s why your well-being is very important."
                    + "</p>"
                    + "<p style='color: #3A3333; text-align: center;'>"
                    + "For your health and well-being, we are here to support you technically 24x7."
                    + "</p>"
                    + "</html>";

            helper.setSubject("HEY ... OTP IS HERE..");
            helper.setTo(tomail);
            helper.setText(actualMessage,true);
            mailSender.send(message);
            return 1;
        }
        catch(Exception e){
            throw new RuntimeException("Failed to Send Email", e);
        }

    }


    public void sendingQueueWiseMail(String mail, int otp) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");


            String msg="REMEDICARE";
            String msg1="Technical Helper";
            String actualMessage="<html>"
                    + "<body style='font-family: Arial, sans-serif; text-align: center; margin: 0; padding: 20px;'>"

                    + "<h2 style='color: #333; margin: 0; text-align:center; letter-spacing:3px;'>" + msg + "</h2>"
                    + "<h3 style='color: #333; margin: 0; text-align:center; letter-spacing:3px;'>" + msg1 + "</h3>"
                    + "<p style='font-size: 24px; color: black; font-weight: bold; margin-bottom: 30px;'>"
                    + "Your Generated OTP is: " + otp + "</p>"
                    + "<p style='color: red; text-align: center; font-weight: bold;'>"
                    + "Please Don't Share This OTP with Others"
                    + "</p>"
                    +"<img src='https://img.freepik.com/free-vector/group-medical-staff-carrying-health-related-icons_53876-43071.jpg?semt=ais_hybrid&w=740&q=80' alt='Medical Notification' style='width: 100%; height: 100%; object-fit: cover;'>"
                    + "</body>"
                    + "<p style='color: #3A3333; text-align: center;'>"
                    + "In this technical world, your thoughts and skills are extremely valuable to all of us. That’s why your well-being is very important."
                    + "</p>"
                    + "<p style='color: #3A3333; text-align: center;'>"
                    + "For your health and well-being, we are here to support you technically 24x7."
                    + "</p>"
                    + "</html>";

            helper.setSubject("HEY ... OTP IS HERE..");
            helper.setTo(mail);
            helper.setText(actualMessage,true);
            mailSender.send(message);

        }
        catch(Exception e){
            throw new RuntimeException("Failed To Send Mail",e);
        }

    }

    public void sendUpdateMail(String email, int otp) {

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");


            String msg="REMEDICARE";
            String msg1="Technical Helper";
            String actualMessage="<html>"
                    + "<body style='font-family: Arial, sans-serif; text-align: center; margin: 0; padding: 20px;'>"

                    + "<h2 style='color: #333; margin: 0; text-align:center; letter-spacing:3px;'>" + msg + "</h2>"
                    + "<h3 style='color: #333; margin: 0; text-align:center; letter-spacing:3px;'>" + msg1 + "</h3>"
                    + "<p style='font-size: 24px; color: black; font-weight: bold; margin-bottom: 30px;'>"
                    + "Your Update Password Generated OTP is: " + otp + "</p>"
                    + "<p style='color: red; text-align: center; font-weight: bold;'>"
                    + "Please Don't Share This OTP with Others"
                    + "</p>"
                    +"<img src='https://img.freepik.com/free-vector/group-medical-staff-carrying-health-related-icons_53876-43071.jpg?semt=ais_hybrid&w=740&q=80' alt='Medical Notification' style='width: 100%; height: 100%; object-fit: cover;'>"
                    + "</body>"
                    + "<p style='color: #3A3333; text-align: center;'>"
                    + "In this technical world, your thoughts and skills are extremely valuable to all of us. That’s why your well-being is very important."
                    + "</p>"
                    + "<p style='color: #3A3333; text-align: center;'>"
                    + "For your health and well-being, we are here to support you technically 24x7."
                    + "</p>"
                    + "</html>";

            helper.setSubject("HEY ... OTP IS HERE..");
            helper.setTo(email);
            helper.setText(actualMessage,true);
            mailSender.send(message);

        }
        catch(Exception e){
            throw new RuntimeException("Failed To Send Mail",e);
        }
    }


}
