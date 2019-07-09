import java.util.*;
 import java.lang.*;
 import java.io.*;
 
 class D4_bracket_position {
         public static void printBracketsPos(String s){
             
             Stack<Integer>st = new Stack<>();
             int num = 1;
             for(int i=0;i<s.length();i++){
                 char c = s.charAt(i);
                 if(c=='('){
                     System.out.print(num+" ");
                     st.push(num++);
                     continue;
                 }
                 if(c==')'){
                     System.out.print(st.pop()+" ");
                 }
                 
             }
             
             
         }
 
 
 
 
 
 
 
 	 //Dont make changes here 
 	 public static void main (String[] args) {
 	     Scanner scn=new Scanner(System.in);
 	         String s=scn.next();
 	         printBracketsPos(s);
 	     
 	 }
 }
