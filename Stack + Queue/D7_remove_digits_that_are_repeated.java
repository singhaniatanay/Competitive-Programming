import java.util.*;
 import java.lang.*;
 import java.io.*;
 
 class D7_remove_digits_that_are_repeated {
 	 static long removeRep(long n) 
 	 {
            String s = n+"";
            for(int i=0;i<s.length()-1;i++){
                if(s.charAt(i)==s.charAt(i+1)){
                    s=s.substring(0,i)+s.substring(i+1);
                    i--;
                }
            }
            return Long.parseLong(s);
            
 	 } 
 	  
 
         // Dont make changes here
         public static void main (String[] args) {
 	 
             Scanner sc=new Scanner(System.in);
             long A=sc.nextLong();
             System.out.println(removeRep(A));
 	 
         }	 
 	 
 }
