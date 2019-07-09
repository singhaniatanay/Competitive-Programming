import java.util.*;
 import java.lang.*;
 import java.io.*;
 
 class D7_valid_braces {
     public static void isbal(String s){
         
         
        Stack <Character> stack = new Stack<>();
        if(s.length()==0){
                System.out.println("balanced");
                return;
            }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }
            else{
                if(!stack.empty()){
                if(s.charAt(i)==')'&&stack.pop()=='('){
                    continue;
                }
                else if(s.charAt(i)=='}'&&stack.pop()=='{'){
                    continue;
                }
                else if(s.charAt(i)==']'&&stack.pop()=='['){
                    continue;
                }
                System.out.println("not balanced");
                return;
                }
                else{
                System.out.println("not balanced");
                    return;
                }
            }

            
        }
        if(stack.empty()){
                System.out.println("balanced");
            return;
        }
                System.out.println("not balanced");
        return;
         
     }
 	 
 
 
 
 
 
 
 
 
 	 //Dont make changes here
 	 public static void main (String[] args) {
 	 	 Scanner scn=new Scanner(System.in);
 	  	 String s=scn.next();
 	  	 isbal(s);
 	 
 	 }
 }
