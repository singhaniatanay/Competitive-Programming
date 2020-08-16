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
		    int n = (2*sc.nextInt())+2;
		    int[] arr = new int[n];
		    HashSet<Integer> set = new HashSet<Integer>();
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		        if(set.contains(arr[i])){ 
		            set.remove(arr[i]);
		            continue;
		        }
		        set.add(arr[i]);
		    }
		    int[] ans = new int[2];
		    int k=0;
		    for(int l:set){
		        ans[k++] = l;
		    }
		    if(ans[0]<ans[1]){
		        System.out.println(ans[0]+" "+ans[1]);
		    }else{
		        System.out.println(ans[1]+" "+ans[0]);
		    }
		    
		}
	}
	
}