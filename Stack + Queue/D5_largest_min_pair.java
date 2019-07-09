import java.util.*;
  import java.lang.*;
  import java.io.*;
  
  class D5_largest_min_pair {
      public static long findlargest(long arr[],int n){
          
          long maxSum = 0;
          for(int i=0;i<n-1;i++){
              maxSum = Math.max(arr[i]+arr[i+1],maxSum);
          }
          
          return maxSum;
          
      }
  	  
  
  	  // Dont make changes here
  	  public static void main (String[] args)throws Exception {
  	  	  Scanner sc=new Scanner(System.in);
  	  	  int n=sc.nextInt();
  	          long arr[]=new long[n];
  	          for(int i=0;i<n;i++)arr[i]=sc.nextLong();
  	          System.out.println(findlargest(arr,n));
  	  
  	  }
  }
