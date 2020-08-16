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
		    int m = sc.nextInt();
		    int n = sc.nextInt();
		    int d = sc.nextInt();
		    int ans = getOpns(m,n,d);
		    
		    System.out.println(ans);
		}
	}
	public static int getOpns(int m,int n,int d){
	    if(d==0) return 0;
	    if(d>Math.max(m,n)) return -1;
	    if((d % gcd(m,n))!=0) return -1;
	    return Math.min(getMoves(m,n,d),getMoves(n,m,d));
	}
	public static int gcd(int a,int b){
	    if(a==0) return b;
	    return gcd(b%a,a);
	}
	public static int getMoves(int fromTot,int toTot,int d){
	    int from = fromTot;
	    int to = 0;
	    int moves = 1;
	    while(from!=d && to!=d){
	        int waterThatCanBePoured = Math.min(from,toTot-to);
	        from -= waterThatCanBePoured;
	        to += waterThatCanBePoured;
	        moves++;
	        if(from==d || to==d) break;
	        if(from==0){
	            moves++;
	            from = fromTot;
	        }
	        if(to==toTot){
	            moves++;
	            to = 0;
	        }
	    }
	    return moves;
	}
}