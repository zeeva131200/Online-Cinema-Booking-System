/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

/**
 *
 * @author Sangeetha
 */
public class LinkedList {
//public static void main(String[] args){
//    LinkedList list = new LinkedList();
//    list.insertAtHead(0);
//    list.insertAtHead(0);
//    list.insertAtHead(0);
//    list.display();
        Node head;
    
    public void insertAtHead(String data){
        Node newnode = new Node();
        newnode.data = data;
        newnode.next = head;    //address of newnode is of the old head
        head = newnode;  //new node becomes the head     
    }  

       public void insertAtBack(String data){
        Node newnode = new Node();
        newnode.data = data;
        newnode.next = null;
        
        if(head==null){
            head = newnode;
        }
        else{
            Node current = head; 
            while(current.next!=null){ 
            current = current.next;  
            }
            current.next = newnode;    //adding new node's address to current node
        }
    }
       
       public void deleteAtHead(){
        head = head.next;
    }
       
       public void deleteAtData(String data){
        Node current = head;
        Node previous = head;
        
        if(current.data.equals(data)){
            deleteAtHead();
        }
        
        while(current.next!=null){
            previous = current;
            current = current.next;
            
            if(current.data.equals(data)){
                previous.next = current.next;
            }
        }
    }
       public String getData(int index){
        String wanted = "";
        Node current = head;
        for(int i=0;i<=index;i++){  // <index-1 cuz wanna add element before that index
           wanted = current.data;
            current = current.next;
        }
        return wanted;
       }
       
        public int length(){
        Node temp = head;
        int count =0;
        
        while(temp!=null){
          temp = temp.next;
          count++;
        }
        return count;
    }
       public String display(){
           String x = "";
        Node current = head;
        for(int i=1;i<length();i++){
            x += current.data + ",";
            current = current.next; //only prints till 2nd last value
        }
        x+= current.data;
        return x;
    }
}
class Node {
    String data;
    Node next;   
}
