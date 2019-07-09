import java.util.*;
 import java.util.Scanner;
 public class D5_stack_supporting_min_operation {
     
     static int minEle;
     static Stack<Integer> s=new Stack<>();
     
     static int getMin()
     {
         if(s.size()==0){
             return -1;
         }
         return minEle;
         
     }
     static int pop()
     {
         if(s.size()==0){
             return -1;
         }
         else if(s.peek()<minEle){
             int pop=minEle;
             minEle= 2*minEle-s.pop();
             return pop;
         }
         return s.pop();
         
     }
     static void push(int x)
     {
         if(s.size()==0){
             s.push(x);
             minEle = x;
         }
         else if(x>=minEle){
             s.push(x);
         }else{
             s.push(x+x-minEle);
             minEle=x;
         }
         
     }	 
 
 
 
 
 
 
 
 
 
 
 	 // Dont make changes here    
 	 public static void main(String[] args) {
 	 	 Scanner sc=new Scanner(System.in);
 	 	 int n=sc.nextInt();
 	 	 int[] query=new int[n];
 	 	 for(int i=0;i<n;i++){
 	 	 	 query[i]=sc.nextInt();
 	 	 }
 	 	 int i=0;
 	 	 while(i<n){
 	 	 	 if(query[i]==1){
 	 	 	 	 i++;
 	 	 	 	 push(query[i]);
 	 	 	 }
 	 	 	 else if(query[i]==2){
 	 	 	 	 System.out.println(pop()+" ");
 	 	 	 }
 	 	 	 else if(query[i]==3){
 	 	 	 	 System.out.println(getMin()+" ");
 	 	 	 }
 	 	 	 i++;
 	 	 }
 	 }
 
 }
