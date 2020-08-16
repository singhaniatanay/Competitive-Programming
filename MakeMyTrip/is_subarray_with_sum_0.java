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
		    int sum=0;
		    boolean flag = false;
		    HashSet<Integer> sums = new HashSet<>();
		    for(int i:arr){
		        sums.add(sum);
		        sum+=i;
		        if(sums.contains(sum)) {
		            flag = true;
		            break;
		        }
		    }
		    if(flag) System.out.println("Yes");
		    else System.out.println("No");
		}
	}
}