import java.util.*;
 import java.lang.*;
 import java.io.*;
 
 class D6_height_of_closest_tower {
 
 	 public static int heightClosestTower(int[] A){
 	     
 	     int[] ans = new int[A.length];
 	     Stack<Integer> st = new Stack<>();
 	     
 	     for(int i=0;i<A.length;i++){
 	         if(st.empty()){
 	             st.push(i);
 	             continue;
 	         }
 	        while(!st.empty()&&A[st.peek()]<A[i]){
 	                ans[st.pop()]=A[i];
 	        }
 	         st.push(i);
 	     }
 	     
 	     while(!st.empty()){
 	         ans[st.pop()]=0;
 	     }
 	     int sum=0;
 	     for(int i=0;i<ans.length;i++){
 	         sum+=ans[i];
 	     }
 	     return sum;
 	     
 	 }
 
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         // Dont make changes here
         public static void main (String[] args) {
 	 
             Scanner sc=new Scanner(System.in);
             int N=sc.nextInt();
             int[] A=new int[N];
             for(int i=0;i<N;i++)A[i]=sc.nextInt();
             System.out.println(heightClosestTower(A));
 	 
         }	 
 	 
 }
