import java.util.*;
 import java.lang.*;
 import java.io.*;
 
 class D6_connecting_ropes {
 	 public static long minCostRopes(long[] arr) {
 	     
 	     PriorityQueue<Long> q = new PriorityQueue<>();
 	     for(int i=0;i<arr.length;i++){
 	         q.add(arr[i]);
 	     }
 	     long ans = 0;
 	     while(q.size()!=1){
 	         long val1 = q.remove();
 	         long val2 = q.remove();
 	         ans=ans+val1+val2;
 	         q.add(val1+val2);
 	     }

 	     return ans;
 	     
 	     
 	 }
 
 
 
 
 
 
 
 
 	 // Dont make changes here
 	 public static void main(String[] args) {
 	 	 Scanner scn = new Scanner(System.in);
 	 	 	 int n = scn.nextInt();
 	 	 	 long arr[] = new long[n];
 	 	 	 for (int i = 0; i < n; i++) 
 	 	 	 	 arr[i] = scn.nextLong();
 	 	 	 System.out.println(minCostRopes(arr));
 	 	 
 	 }
 }
