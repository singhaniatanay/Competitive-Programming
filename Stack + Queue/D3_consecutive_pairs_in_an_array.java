import java.util.Scanner;
 import java.util.*;
 //User function Template for Java
 // your task is to complete the function
 // function should return true/false or 1/0
 class D3_consecutive_pairs_in_an_array {
 	 public static boolean pairWiseConsecutive(Stack<Integer> st) {
 	     
 	     if(st.size()%2==1){
 	         st.pop();
 	     }
 	     
 	     while(!st.empty()){
 	         
 	         if(Math.abs(st.pop()-st.pop())!=1){
 	             return false;
 	         }
 	     }
 	     return true;
 	     
 	     
 	 }
 	 
 
 
 
 	 // Dont make changes here
 	 public static void main(String[] args){
 	 	 Scanner sc=new Scanner(System.in);
 	 	 int n=sc.nextInt();
 	 	 Stack<Integer>st=new Stack<>();
 	 	 for(int i=0;i<n;i++){
 	 	 	 st.push(sc.nextInt());
 	 	 }
 	 	 System.out.println(pairWiseConsecutive(st));
 	 	 	 
 	 }
 }
