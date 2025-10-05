package com.UdayNarayanKhanra.PrescribeOperation.myOwnArraylistDS;


import com.UdayNarayanKhanra.PrescribeOperation.PrescriptionMaking.prescription;
import com.UdayNarayanKhanra.PrescribeOperation.prescriptionRepo.prescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class customArrayList {
    @Autowired
    prescriptionRepo repo;
    private Node root;

    public String add(prescription data){
    Node N=new Node(data);
    if(root==null){
        root=N;
    }
    else{
        Node start=root;
        while(start.getNext()!=null){
            start=start.getNext();
        }

        start.setNext(N);
    }
        return "One Data Successfully Add";
    }



//    @Scheduled(fixedRate = 6000)
    public void peak(){
//        Node start=root;
        prescription a=null;
        if(root==null){
            System.out.println("No More Request Found");
        }
        else {
            a = root.getData();
            prescription s=repo.save(a);
            System.out.print(s.getMedicineName());
            System.out.println("Prescription Add Successfull");
            root = root.getNext();

        }
    }

//    @Scheduled(cron="0 * * * * *")
//    public void s(){
//        System.out.println("hhhhhh");
//    }


}







class Node{
    private prescription data;
    private Node next;

    public Node(prescription data){
        this.data=data;
        next=null;
    }

    public prescription getData() {
        return data;
    }

    public void setData(prescription data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}