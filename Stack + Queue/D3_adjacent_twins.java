import java.util.*;
 
 public class D3_adjacent_twins {
 	 public static void removeAdjTwins(String s) {
 	     
 	     Stack <Character> st = new Stack<>();
 	     String ans ="";
 	     for(int i=0;i<s.length();i++){
 	         if(!st.empty()&&st.peek()==s.charAt(i)){
 	             st.pop();
 	         }
 	         else{
 	             st.push(s.charAt(i));
 	         }
 	     }
 	     
 	     while(!st.empty()){
 	         ans = st.pop()+ans;
 	     }
 	     System.out.print(ans);
 	     
 	     
 	     
 	 }
 
 
 	 //Dont make changes here
 	 public static void main(String[] args) {
 	 	 Scanner sc=new Scanner(System.in);
 	 	 String s = sc.next();
 	 	 removeAdjTwins(s);
 	 }
 
 }
