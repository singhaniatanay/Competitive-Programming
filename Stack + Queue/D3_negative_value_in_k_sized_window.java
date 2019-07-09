import java.util.*;
 import java.lang.*;
 import java.io.*;
 
 class D3_negative_value_in_k_sized_window {
 	 
 	 public  static void window(int[] arr, int k){
 	     
 	     Queue <Integer> q = new LinkedList<>();
 	     for (int i=0;i<arr.length;i++){
 	         if(arr[i]<0){
 	             q.add(i);
 	         }
 	     }
 	     
 	     for(int i=0;i<=arr.length-k;i++){
 	         
 	         if(q.size()!=0&&i==q.peek()){
 	             System.out.print(arr[q.peek()]+" ");
                 q.remove();
                 continue;
 	         }
 	         if(q.size()!=0&&q.peek()<i+k){
 	             System.out.print(arr[q.peek()]+" ");
 	         }else{
 	             System.out.print(0+" ");
 	         }
 	         
 	     }
 	     
 	     
 	 }
 
 
 
 
 
 
 
 	 // Dont make changes here
 	 public static void main (String[] args) {
 	      Scanner s=new Scanner(System.in);
 	 	      int size=s.nextInt();
 	 	      int[]arr=new int[size];
 	 	      for(int i=0;i<size;i++){
 	 	          arr[i]=s.nextInt();
 	 	      }
 	 	      int k=s.nextInt();
 	 	      
 	 	      
 	 	     window(arr, k);
 	 	  
 	 }
 }
