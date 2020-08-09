/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class egg_drop {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] eggDrop = new int[11][51];
		eggDropfill(eggDrop,10,50);
		while(t-->0){
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    System.out.println(eggDrop[n][k]);
		}
	}
	public static void eggDropfill(int[][] dp,int max_n,int max_k){
	    for(int i=1;i<=max_n;i++){
	        dp[i][0] = 0;
	        dp[i][1] = 1;
	    }
	    for(int i=1;i<=max_k;i++){
	        dp[1][i] = i;
	    }
	    int res =0;
	    for(int i=2;i<=max_n;i++){
	        for(int j=2;j<=max_k;j++){
	            dp[i][j] = Integer.MAX_VALUE;
	            for(int k=1;k<=j;k++){
	               res = 1 + Math.max(dp[i][j-k],dp[i-1][k-1]);
	               if(res<dp[i][j]){
	                   dp[i][j] = res;
	               }
	            }
	        }
	    }
	}
}