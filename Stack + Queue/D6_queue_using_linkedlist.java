import java.util.Scanner;
 
 class D6_queue_using_linkedlist{
 /*The structure of the node of the queue is
 class QueueNode
 {
 	 int data;
 	 QueueNode next;
 	 QueueNode(int a)
 	 {
 	     data = a;
 	     next = null;
 	 }
 }*/
 
 static class MyQueue
 {
     QueueNode front, rear;
 
     // This function should add an item at
     // rear
 	 void push(int a)
 	 {
 	     QueueNode node = new QueueNode(a);
 	     if(front==null){
 	         front = node;
 	         rear = node;
 	     }else{
 	         rear.next = node;
 	         rear = node;
 	     }
 	 }
 	 
     // This function should remove front
     // item from queue and should return
     // the removed item.
 	 int pop()
 	 {
 	     if(front==null){
 	         return -1;
 	     }
 	     int data = front.data;
 	     front = front.next;
 	     return data;
 	 }
 }
 
 
 
 
 
 
 
 
 
 
 
 
 // Dont make changes here
 public static void main(String[] args){
 	 MyQueue queue=new MyQueue();
   	  Scanner sc=new Scanner(System.in);
   	  int n=sc.nextInt();
   	  int i=0;// number of operationsto be performed
   	  while(i!=n){
   	 	  int q=sc.nextInt();
   	 	  if(q==1){
   	 	 	  queue.push(sc.nextInt());
   	 	  }
   	 	  else if(q==2)System.out.println( queue.pop());
   	 	  i++;
   	  }
    }
 
 static class QueueNode
 {
 	 int data;
 	 QueueNode next;
 	 QueueNode(int a)
 	 {
 	     data = a;
 	     next = null;
 	 }
 }
 }
