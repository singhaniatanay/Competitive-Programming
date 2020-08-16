/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int mod = 1000000007;
		int t = sc.nextInt();
		while(t-->0){
		    String num = sc.next();
		    long n = Long.parseLong(num);
		    StringBuilder sb = new StringBuilder();
		    sb.append(num);
		    String rnum = sb.reverse().toString();
		    long r = Long.parseLong(rnum);
		    System.out.println(power(n,r,mod));
		}
	}
	 public static long power(long n , long r , int b){
	     
	     if(r==0){
	         return 1 ;
	     }
	     
	     long ans = power(n,r/2,b) ;
	     if (r%2 == 0) 
           return ((ans%b)*(ans%b))%b; 
        else
           return (n*((ans*ans)%b))%b; 
	 }
	 
}