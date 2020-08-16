// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int x = sc.nextInt();
            String[] dictionary = new String[x];
            for(int i=0;i<x;i++)
            {
                dictionary[i] = sc.next();
            }
            
            int m = Integer.parseInt(sc.next());
            int n = Integer.parseInt(sc.next());
            
            char board[][] = new char[m][n];
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    board[i][j] = sc.next().charAt(0);
                }
            }
            
            Solution T = new Solution();
            String[] ans = T.wordBoggle(board, dictionary);
            
            if(ans.length == 0) System.out.println("-1");
            else
            {
                Arrays.sort(ans);
                for(int i=0;i<ans.length;i++)
                {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }
            
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String[] wordBoggle(char b[][], String[] dict)
    {
        // Write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Character,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<dict.length;i++){
            char c = dict[i].charAt(0);
            ArrayList<Integer> indexes = map.getOrDefault(c,new ArrayList<Integer>());
            indexes.add(i);
            map.put(c,indexes);
        }
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[0].length;j++){
                char c = b[i][j];
                ArrayList<Integer> indexes = map.getOrDefault(c,new ArrayList<Integer>());
                for(int k:indexes){
                    if(!ans.contains(k)&&canBe(b,i,j,dict[k],0)){
                        ans.add(k);
                    }
                }
            }
        }
        String[] aa = new String[ans.size()];
        int l=0;
        for(int i:ans){
            aa[l++] = dict[i];
        }
        return aa;
    }
    public static boolean canBe(char[][] b,int i,int j,String st,int k){
        if(k==st.length()) return true;
        if(i<0 || j<0 || i>=b.length || j>=b[0].length) return false;

        if(b[i][j]!=st.charAt(k)){
            return false;
        }
        char t = b[i][j];
        b[i][j] = '#';
        k++;
        boolean res =    canBe(b,i+1,j,st,k) || 
                    canBe(b,i+1,j+1,st,k) || 
                    canBe(b,i+1,j-1,st,k) || 
                    canBe(b,i,j+1,st,k) || 
                    canBe(b,i,j-1,st,k) || 
                    canBe(b,i-1,j-1,st,k) || 
                    canBe(b,i-1,j,st,k) || 
                    canBe(b,i-1,j+1,st,k);
        b[i][j] = t;
        return res;
    }
}