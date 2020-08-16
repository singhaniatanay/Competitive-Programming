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
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i=0;i<n;i++) arr[i] = sc.nextInt();
		    boolean[] bool = new boolean[10];
		    for(int i:arr){
		        char[] carr = (i+"").toCharArray();
		        for(char c:carr){
		            bool[c-'0'] = true;
		        }
		        
		    }
		    for(int k=0;k<10;k++){
		        if(bool[k]) System.out.print(k+" ");
		    }
		    System.out.println();
		}
	}
}