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
		    int[][] mat = new int[n][n];
		    for(int i=0;i<n;i++){
		        for(int j=0;j<n;j++){
		            mat[i][j] = sc.nextInt();
		        }
		    }
		    for(int gap=0;gap<n;gap++){
		        for(int i=0;i<n-gap;i++){
		            int j = i+gap;
		            if(i==j) continue;
		            swap(mat,i,j);
		        }
		    }
		    for(int i=0;i<n;i++){
		        for(int j=0;j<n;j++){
		            System.out.print(mat[i][j]+" ");
		        }
		    }
		    System.out.println();
		}
	}
	public static void swap(int[][] mat,int i,int j){
	    int temp = mat[i][j];
	    mat[i][j] = mat[j][i];
	    mat[j][i] = temp;
	}
}