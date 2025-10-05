package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.sql.SQLOutput;
import java.util.Scanner;
//import java.util.Scanner;
//Prime Number Check Manually Enter Number
//public class Main {
//    public static void main(String[] args) {
//        int n=19,c=0;
//        for(int i=2;i*i<=n;i++){
//            if(n%i==0){
//                System.out.println("Not Prime");
//                c++;
//                break;
//            }
//        }
//        if(c==0)
//        System.out.println("Prime");
//    }
//}

//Prime Number Ranging Number
//public class Main {
//    public static void main(String[] args) {
//
//        Scanner sc=new Scanner(System.in);
//        int start=sc.nextInt();
//        int end=sc.nextInt();
//        int c=0,count=0;
//        for(int i=2;i<=end;i++){
//            for(int j=2;j*j<=i;j++){
//                if(i%j==0){
//                    c++;
//                    break;
//                }
//                c=0;
//            }
//
//            if(c==0){
//                count++;
//                System.out.println(i);
//
//            }
//        }
//
//        System.out.println(count+"FINAL ANSWER ");
//    }
//}

//class Node{
//    public int data;
//    public Node next;
//    public Node prev;
//
//    public Node(int data){
//        this.data=data;
//        next=null;
//        prev=null;
//    }
//    public Node(){
//
//    }
//}
//
//
//class Solution{
//
//    private Node root=null;
//
//    public void Add(int data){
//
//        Node N=new Node(data);
//        if(root==null){
//            root=N;
//        }
//        else{
//            Node Head=root;
//            while(Head.next!=null){
//                Head=Head.next;
//            }
//            Head.next=N;
//            N.prev=Head;
//        }
//
//    }
//
//
//    public void Show(){
//        Node Head=root;
//
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//
//
//    }
//}


public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]=new int[10];
        int n=sc.nextInt();
        for(int i=0;i<=n-1;i++){
            arr[i]=sc.nextInt();
        }

        int low=0;
        int high=n-1;

        while(high>low){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;

        }
        for(int i=0;i<=n-1;i++){
            System.out.print(" "+arr[i]);
        }
    }
}
