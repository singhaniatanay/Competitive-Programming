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
		    int ans = -1;
		    for(int i=0;i<n;i++){
		        int c = sc.nextInt();
		        if(c==0) continue;
		        if(ans==-1) ans = i;
		    }
		    System.out.println(ans);
		}
	}
}