import java.util.*;
 import java.util.*;
 
 public class D7_queue_using_stacks {
 
     static class queUsingStack {
 
         Stack<Integer> ds=new Stack<>();
         Stack<Integer> hs=new Stack<>();
 
         queUsingStack() {
             
         }
 
         public void push(int x) {
             ds.push(x);
         }
 
         public int pop() {
             if(ds.empty()){
                 return -1;
             }
             while(ds.size()!=1){
                 hs.push(ds.pop());
             }
             int x = ds.pop();
             while(hs.size()!=0){
                 ds.push(hs.pop());
             }
             return x;
         }
 
         public int peek() {
             if(ds.empty()){
                 return -1;
             }
            while(ds.size()!=1){
                 hs.push(ds.pop());
             }
             int x = ds.peek();
             while(hs.size()!=0){
                 ds.push(hs.pop());
             }
             return x;
         }
 
         public boolean empty() {
             
             return ds.empty();
         }
 
     }
 
 
 // Dont make changes here
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         queUsingStack qs=new queUsingStack();
         int Q=sc.nextInt();
         for(int i=0;i<Q;i++){
             int q=sc.nextInt();
             if(q==1){
                 qs.push(sc.nextInt());
             }
             else if(q==2){
                 System.out.print(qs.pop()+" ");
             }
             else if(q==3){
                 System.out.print(qs.peek()+" ");
             }
             else if(q==4){
                 System.out.print(qs.empty()+" ");
             }
         }
     }
 
 }
