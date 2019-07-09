import java.util.*;
 
 public class D7_making_parentheses_valid {
 
     public static int minAddToMakeValid(String s) {
         
         Stack <Character> st = new Stack<>();
   	     for(int i=0;i<s.length();i++){
   	         if(s.charAt(i)=='('){
   	             st.push('(');
   	         }else{
   	             if(!st.empty()&&st.peek()=='('){
   	                 st.pop();
   	             }else{
   	                 st.push(')');
   	             }
   	         }
   	     }
   	     return st.size();
         
     }
 
     // Dont make changes here
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         String s = sc.next();
         System.out.println(minAddToMakeValid(s));
     }
 
 }
