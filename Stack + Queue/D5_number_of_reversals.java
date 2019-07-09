import java.util.*;
 import java.lang.*;
 import java.io.*;
 
 class D5_number_of_reversals {
   	 public static int min_str_reversal(String s){
   	     
   	     Stack <Character> st = new Stack<>();
   	     for(int i=0;i<s.length();i++){
   	         if(s.charAt(i)=='{'){
   	             st.push('{');
   	         }else{
   	             if(!st.empty()&&st.peek()=='{'){
   	                 st.pop();
   	             }else{
   	                 st.push('}');
   	             }
   	         }
   	     }
   	     int size = st.size();
   	     int open = 0;
   	     while(!st.empty()&&st.peek()=='{'){
   	         st.pop();
   	         open++;
   	     }

   	     int close = size-open;
   	     if((open+close)%2!=0){
   	         return -1;
   	     }
   	     return (int)(Math.ceil((double)open/2)+Math.ceil((double)close/2));
   	 }
 
 
 
 
 	 // Dont make changes here
 	 public static void main (String[] args) {
 	     Scanner scn=new Scanner(System.in);
 	     String s=scn.next();
 	     System.out.println(min_str_reversal(s));
 	     
 	 }
 }
