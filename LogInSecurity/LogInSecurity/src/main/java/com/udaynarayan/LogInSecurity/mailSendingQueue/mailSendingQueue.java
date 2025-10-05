package com.udaynarayan.LogInSecurity.mailSendingQueue;

import com.udaynarayan.LogInSecurity.ForgetPassWordOtp.passwordUpdateRepo;
import com.udaynarayan.LogInSecurity.ForgetPassWordOtp.passwordupdate;
import com.udaynarayan.LogInSecurity.MailService.MailServvice;
import com.udaynarayan.LogInSecurity.mailOtpTable.mailotpcheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class mailSendingQueue {

    @Autowired
    passwordUpdateRepo updateRepo;

    private Node Head=null;
private final List<passwordupdate> PassUpdate=new ArrayList<>();
    @Autowired
    MailServvice mailservice;


    public void mailAddToQueue(mailotpcheck check) {

        Node N=new Node(check);
        if(Head==null){
            Head=N;
        }
        else{
            Node Top=Head;

            while(Top.getNext()!=null){
                Top=Top.getNext();
            }
            Top.setNext(N);
        }
    }


    @Scheduled(cron="0 * * * * *")
    public void printallMail(){
        Node top=Head;
        while(Head!=null){
           mailotpcheck c= Head.getMailotp();

            String mail=c.getEmail();
            int otp=c.getOtp();
            mailservice.sendingQueueWiseMail(mail,otp);
            System.out.println("A Mail Successfully send to This ->"+c.getEmail());
            Head=Head.getNext();
        }

    }

    public String sendingQueueWiseMail(){

        mailotpcheck mmotp=Head.getMailotp();
        String mail=mmotp.getEmail();
        int otp=mmotp.getOtp();
        mailservice.sendingQueueWiseMail(mail,otp);
        Head=Head.getNext();
        return "";
    }


    public void updatePassWordOtpSend(passwordupdate pwUpdate) {
        PassUpdate.add(pwUpdate);
    }


    @Scheduled(fixedRate = 60000)
    public void saveUpdatePasswordRequest(){

        for(passwordupdate p:PassUpdate) {
            updateRepo.save(p);
            mailservice.sendUpdateMail(p.getEmail(), p.getOtp());
            boolean a = PassUpdate.remove(p);
            if (a) {
                System.out.println("Password Update Mail Send Successfull");
            } else {
                System.out.println("An Error Occured!");
            }
           if(PassUpdate.isEmpty()){
               break;
           }
        }

    }


}


class Node{
    private mailotpcheck mailotp;
    private Node next;

    public Node(mailotpcheck mailotp){
        this.mailotp=mailotp;
        next=null;
    }

    public mailotpcheck getMailotp() {
        return mailotp;
    }

    public void setMailotp(mailotpcheck mailotp) {
        this.mailotp = mailotp;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
