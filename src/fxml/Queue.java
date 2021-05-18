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
public class Queue {

private int maxSize,head=0,tail=0;
private String arr[];

    public Queue(int x) {
        this.maxSize = x;
        this.arr = new String [x];
    }
    
    public void enqueueMany(String a){
        String []str = a.split(",");
       for(int tail=0;tail<maxSize;tail++){
           arr[tail]=str[tail];
       }
    }
    public void enqueue(String x){
        arr[tail] = x;
        tail++;
    }
    
     public String display(int i){
         String x ="";
            x = arr[i];
    return x;
     }
}
