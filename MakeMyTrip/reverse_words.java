// { Driver Code Starts

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}
// } Driver Code Ends



class Solution {
    String reverseWords(String s) {
        // code here 
        String[] ar = s.split("\\.");
        StringBuilder sb = new StringBuilder();
        for(int i=ar.length-1;i>=0;i--){
            sb.append(ar[i]);
            if(i!=0) sb.append(".");
        }
        return sb.toString();
    }
}