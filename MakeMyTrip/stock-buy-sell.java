// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] price = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                price[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            sln.stockBuySell(price, n);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public void stockBuySell(int[] price, int n) {
        // code here
       int i=0;
       int profit=0;
       while(i<n){
           int bottom=i;
           while(bottom+1<n&&price[bottom]>=price[bottom+1]){
               bottom++;
           }
           int top=bottom;
           while(top+1<n&&price[top]<=price[top+1]){
               top++;
           }
           if(top!=bottom){
           System.out.print("("+bottom+" "+top+")"+" ");
          profit+=price[top]-price[bottom];
           }
           i=top+1;
           }
           if(profit==0){
               System.out.println("No Profit");
           }
       else
        System.out.println();
    }
}