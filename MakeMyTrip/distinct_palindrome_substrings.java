/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    String s = sc.next();
		    System.out.println(getSubs(s));
		}
	}
	public static int getSubs(String s){
	    int ans = 0;
	    char[] ar = s.toCharArray();
	    boolean[][] dp = new boolean[ar.length][ar.length];
	    int n = ar.length;
	    for(int i=0;i<n;i++) dp[i][i] = true;
	    for(int gap = 1;gap<n;gap++){
	        for(int i=0;i<n-gap;i++){
	            int j = gap+i;
	            if(ar[i]==ar[j]){
	                if(j-i==1){
	                    dp[i][j] = true;
	                    continue;
	                }
	                if(i+1>j-1) continue;
	                dp[i][j] = dp[i+1][j-1];
	            }
	        }
	    }
	    HashSet<String> set = new HashSet<String>();
	    for(int gap=0;gap<n;gap++){
	        for(int i=0;i<n-gap;i++){
	            int j = gap+i;
	            if(dp[i][j]) set.add(s.substring(i,j+1));
	        }
	    }
	    return set.size();
	}
}