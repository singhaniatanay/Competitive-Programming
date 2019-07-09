import java.util.*;
 import java.lang.*;
 import java.io.*;
 
 class D6_manipulation_of_strings {
 	 
 	 public static int stringManipulation(String[] S){
 	     
 	     Stack<String> st = new Stack<>();
 	     for(int i=0;i<S.length;i++){
 	         if(st.empty()){
 	             st.push(S[i]);
 	             continue;
 	         }
 	         if(st.peek().equals(S[i])){
 	             st.pop();
 	         }else{
 	             st.push(S[i]);
 	         }
 	     }
 	     
 	     return st.size();
 	     
 	 }
 
 
 
 
 
 
 	 // Dont make changes here
         public static void main (String[] args) {
 	 	 Scanner sc=new Scanner(System.in);
 	 	     int l=sc.nextInt();
 	 	     String[] S=new String[l];
 	 	     for(int i=0;i<S.length;i++)
 	 	         S[i]=sc.next();
 	 	     System.out.println(stringManipulation(S));
 	 }
 }
