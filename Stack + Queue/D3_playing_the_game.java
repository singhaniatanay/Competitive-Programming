import java.util.*;
 import java.util.Scanner;
 public class D3_playing_the_game{
 	  public static int calculatePoints(String[] ops) {
 	      
 	      Stack <Integer> st = new Stack<>();
 	      int ans=0;
 	      for(int i=0;i<ops.length;i++){
 	          if(ops[i].equals("+")){
 	              int a = st.pop();
 	              int b = st.pop();
 	              int add = a+b;
 	              st.push(b);
 	              st.push(a);
 	              st.push(add);
 	              continue;
 	          }
 	          else if(ops[i].equals("D")){
 	              st.push(2*st.peek());
 	              continue;
 	          }
 	          else if(ops[i].equals("C")){
 	              st.pop();
 	              continue;
 	          }
 	          st.push(Integer.parseInt(ops[i]));
 	      }
 	      
 	      while(!st.empty()){
 	          ans += st.pop();
 	      }
 	      return ans;
 	      
 	      
 	  }
 
 
 
 	 
 
 	 //Dont make changes here
 	 public static void main(String[] args) {
 	 Scanner sc=new Scanner(System.in);
 	 int n=sc.nextInt();
 	 String[] S=new String[n];
 	 for(int i=0;i<n;i++){
 	 	 S[i]=sc.next();
 	 }
 	 System.out.println(calculatePoints(S));
 	 }
 
 }
