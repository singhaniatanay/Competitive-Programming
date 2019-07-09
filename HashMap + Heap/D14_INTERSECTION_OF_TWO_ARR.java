import java.lang.*;
import java.io.*;
import java.util.*;

class D14_INTERSECTION_OF_TWO_ARR
{
    public static void main (String[] args) throws IOException
    {
        Scanner scn= new Scanner(System.in);
        int n = scn.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] num2 = new int[m];
        for (int i = 0; i < m; i++) {
            num2[i] = scn.nextInt();
        }

        solve(n,m,num,num2);
    }
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input two arrays and their lengths
    // Print required output
    public static void solve(int m,int n,int[] arr1,int[] arr2){
        //Write your code here
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i:arr1)
            set.add(i);
        for(int i:arr2)
            set2.add(i);

        for(int i:set2){
            if(set.contains(i)){
                continue;
            }else {
                set.remove(i);
            }
        }
        int a = set.size();
        for(int i:set){
            if(set2.contains(i)){
                continue;
            }else {
                a--;
            }
        }
        System.out.println(a);
    }


}