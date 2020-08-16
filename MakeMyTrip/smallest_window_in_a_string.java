// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new solve().smallestWindow(s, t));
		    test--;
		}
	}
}// } Driver Code Ends


class solve
{
    // return the smallest window in S with all the characters of P
    // if no such window exists, return "-1" 
    public static String smallestWindow(String S, String P){
        // Your code here
        int l1 = S.length();
        int l2 = P.length();
        int[] hash_s = new int[256];
        int[] hash_p = new int[256];
        for(int i=0;i<l2;i++) hash_p[P.charAt(i)]++;
        int st=0;
        int minWindow = Integer.MAX_VALUE;
        int j=0;
        int count=0;
        int st_ans = -1;
        while(j<l1){
            char c = S.charAt(j);
            hash_s[c]++;
            if(hash_p[c]!=0 && hash_s[c]<=hash_p[c]) count++;
            if(count==l2){
                while(hash_s[S.charAt(st)]>hash_p[S.charAt(st)] || hash_p[S.charAt(st)]==0){
                    if(hash_s[S.charAt(st)]>hash_p[S.charAt(st)]) hash_s[S.charAt(st)]--;
                    st++;
                }
                int win = j-st+1;
                if(win<minWindow){
                    minWindow = win;
                    st_ans = st;
                }
            }
            j++;
        }
        if(st_ans==-1) return "-1";
        return S.substring(st_ans,st_ans+minWindow);
    }
}